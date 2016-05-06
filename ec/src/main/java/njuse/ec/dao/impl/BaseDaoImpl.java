package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;

/**
 * 基本sql.
 * @author 丞
 *
 * @param <T>
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	/**
	 * hibernate session factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public final Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public final Session getNewSession() {
		return sessionFactory.openSession();
	}

	@Override
	public final void flush() {
		getSession().flush();
	}

	@Override
	public final void clear() {
		getSession().clear();
	}

	@Override
	@SuppressWarnings("unchecked")
	public final T load(final Class<T> c, final int id) {
		Session session = getSession();
		return (T) session.get(c, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public final List<T> getAllList(final Class<T> c) {
		String hql = "from " + c.getName();
		Session session = getSession();
		return session.createQuery(hql).list();
	}

	@Override
	public final Long getTotalCount(final Class<T> c) {
		Session session = getSession();
		String hql = "select count(*) from " + c.getName();
		Long count = (Long) session.createQuery(hql).uniqueResult();
		session.close();
		if (count != null) {
			return count.longValue();
		} else {
			return (long) 0;
		}
	}

	@Override
	public final void save(final T bean) {
		try {
			Session session = getSession();
			session.save(bean);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void update(final T bean) {
		Session session = getSession();
		session.update(bean);
		session.flush();
	}

	@Override
	public final void delete(final T bean) {

		Session session = getSession();
		session.delete(bean);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public final void delete(final Class<T> c, final String id) {
		Session session = getSession();
		T obj = (T) session.get(c, Integer.parseInt(id));
		System.out.println(id+" delete");
		session.delete(obj);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public final void delete(final Class<T> c, final String[] ids) {
		for (String id : ids) {
			T obj = (T) getSession().get(c, id);
			if (obj != null) {
				getSession().delete(obj);
			}
		}
		flush();
	}

	@Override
	@SuppressWarnings("unchecked")
	public final T find(final Class<T> c,
			final String coloum, final String value) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("FROM ");
			stringBuilder.append(c.getName());
			stringBuilder.append(" AS u WHERE u.");
			stringBuilder.append(coloum);
			stringBuilder.append(" = :value");
			String hql = stringBuilder.toString();
			Query query = session.createQuery(hql);
			query.setString("value", value);
			List<T> list = query.list();
			tx.commit();
			if ((list.size()) == 0) {
				return null;
			} else {
				return (T) list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public final List<T> findlist(final Class<T> c,
			final String coloum, final String value) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("FROM ");
			stringBuilder.append(c.getName());
			stringBuilder.append(" AS u WHERE u.");
			stringBuilder.append(coloum);
			stringBuilder.append(" = :value");
			String hql = stringBuilder.toString();
			Query query = session.createQuery(hql);
			query.setString("value", value);
			List<T> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> sortlist(Class<T> c, String column, boolean isAsc) {
		Session session = getSession();
		Criteria crit = session.createCriteria(c);
		if(isAsc) {
			crit.addOrder(Order.asc(column));
		} else {
			crit.addOrder(Order.desc(column));
		}
		return crit.list();
	}
}
