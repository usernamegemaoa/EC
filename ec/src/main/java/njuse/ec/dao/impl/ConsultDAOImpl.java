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
import njuse.ec.dao.ConsultDAO;
import njuse.ec.model.Consult;

/**
 * 咨询DAO接口实现.
 * @author 阳
 *
 */
@Repository
public class ConsultDAOImpl implements ConsultDAO {

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
	private BaseDao<Consult> baseDao;
	
	@Override
	public final void addConsult(final Consult consult) {
		baseDao.save(consult);
	}

	@Override
	public final void deleteConsult(final Consult consult) {
		baseDao.delete(consult);
	}

	@Override
	public final List<Consult> getConsults(final int goodId) {
		return baseDao.findlist(Consult.class, "goodId", String.valueOf(goodId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consult> getConsults(int goodId, int firstResult, int maxResult) {
		Session session = getSession();
		Criteria crit = session.createCriteria(Consult.class);
		crit.add(Restrictions.like("goodId", goodId));
		crit.addOrder(Order.desc("time"));
		crit.setFirstResult(firstResult);
		crit.setMaxResults(maxResult);
		return crit.list();
	}

	@Override
	public int getConsultNum(int goodId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(Consult.class);
		crit.add(Restrictions.like("goodId", goodId));
		crit.setProjection(Projections.rowCount());
		int count = Integer.parseInt(String.valueOf(crit.uniqueResult()));
		crit.setProjection(null);
		return count;
	}
}
