package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.GoodDAO;
import njuse.ec.model.Good;

/**
 * 商品DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class GoodDAOImpl implements GoodDAO {
	
	/**
	 * hibernate session factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	public final Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * baseDao.
	 */
	@Autowired
	private BaseDao<Good> baseDao;

	@Override
	public final int addGood(final Good good) {
		baseDao.save(good);
		return good.getId();
	}

	@Override
	public final void deleteGood(final Good good) {
		baseDao.delete(good);
	}

	@Override
	public final List<Good> getLatestGoods() {
		return baseDao.sortlist(Good.class, "time", false);
	}

	@Override
	public final List<Good> getKindGoods(final int kindId) {
		return baseDao.findlist(Good.class, "kindId", String.valueOf(kindId));
	}

	@Override
	public final List<Good> getNameGoods(final String name) {
		String newName = "%" + name + "%";
		return baseDao.findlist(Good.class, "name", newName);
	}

	@Override
	public final Good getGood(final int id) {
		return baseDao.load(Good.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Good> getLatestGoods(int firstResult, int maxResult) {
		Session session = getSession();
		Criteria crit = session.createCriteria(Good.class);
		crit.addOrder(Order.desc("time"));
		crit.setFirstResult(firstResult);
		crit.setMaxResults(maxResult);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Good> getKindGoods(int kindId, int firstResult, int maxResult) {
		Session session = getSession();
		Criteria crit = session.createCriteria(Good.class);
		crit.add(Restrictions.like("kindId", kindId));
		crit.setFirstResult(firstResult);
		crit.setMaxResults(maxResult);
		return crit.list();
	}

	@Override
	public int getLatestGoodNum() {
		Session session = getSession();
		Criteria crit = session.createCriteria(Good.class);
		crit.setProjection(Projections.rowCount());
		crit.addOrder(Order.desc("time"));
		int count = Integer.parseInt(String.valueOf(crit.uniqueResult()));
		crit.setProjection(null);
		return count;
	}

	@Override
	public int getKindGoodNum(int kindId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(Good.class);
		crit.add(Restrictions.like("kindId", kindId));
		crit.setProjection(Projections.rowCount());
		int count = Integer.parseInt(String.valueOf(crit.uniqueResult()));
		crit.setProjection(null);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Good> getNameGoods(String name, int firstResult, int maxResult) {
		String search = "%" + name + "%";
		Session session = getSession();
		Criteria crit = session.createCriteria(Good.class);
		crit.add(Restrictions.like("name", search));
		crit.setFirstResult(firstResult);
		crit.setMaxResults(maxResult);
		return crit.list();
	}

	@Override
	public int getNameGoodNum(String name) {
		String search = "%" + name + "%";
		Session session = getSession();
		Criteria crit = session.createCriteria(Good.class);
		crit.add(Restrictions.like("name", search));
		crit.setProjection(Projections.rowCount());
		int count = Integer.parseInt(String.valueOf(crit.uniqueResult()));
		crit.setProjection(null);
		return count;
	}
}
