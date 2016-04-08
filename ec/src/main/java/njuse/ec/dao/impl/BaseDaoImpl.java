package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	public final T load(final Class<T> c, final Long id) {
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
		Session session = getNewSession();
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
	public final void save(final Object bean) {
		try {
			Session session = getNewSession();
			session.save(bean);
			session.flush();
			session.clear();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void update(final Object bean) {
		Session session = getNewSession();
		session.update(bean);
		session.flush();
		session.clear();
		session.close();
	}

	@Override
	public final void delete(final Object bean) {

		Session session = getNewSession();
		session.delete(bean);
		session.flush();
		session.clear();
		session.close();
	}

	@Override
	public final void delete(final Class<T> c, final String id) {
		Session session = getNewSession();
		Object obj = session.get(c, id);
		session.delete(obj);
		session.flush();
		session.clear();
	}

	@Override
	public final void delete(final Class<T> c, final String[] ids) {
		for (String id : ids) {
			Object obj = getSession().get(c, id);
			if (obj != null) {
				getSession().delete(obj);
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public final T find(final Class<T> c,
			final String coloum, final String value) {
		Session session = getNewSession();
		Transaction tx = session.beginTransaction();

		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("FROM ");
			stringBuilder.append(c.getName());
			stringBuilder.append(" AS u WHERE u.");
			stringBuilder.append(coloum);
			stringBuilder.append(" = ?");
			String hql = stringBuilder.toString();
			Query query = session.createQuery(hql);
			query.setString(0, value);
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
		} finally {
			session.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public final List<T> findlist(final Class<T> c,
			final String coloum, final String value) {
		Session session = getNewSession();
		Transaction tx = session.beginTransaction();

		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("FROM ");
			stringBuilder.append(c.getName());
			stringBuilder.append(" AS u WHERE u.");
			stringBuilder.append(coloum);
			stringBuilder.append(" = ?");
			String hql = stringBuilder.toString();
			Query query = session.createQuery(hql);
			query.setString(0, value);
			List<T> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			session.close();
		}
	}
}