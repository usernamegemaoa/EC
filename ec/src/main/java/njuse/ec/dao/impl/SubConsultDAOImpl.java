package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.SubConsultDAO;
import njuse.ec.model.SubConsult;

/**
 * 子咨询DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class SubConsultDAOImpl implements SubConsultDAO {
	
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
	private BaseDao<SubConsult> baseDao;

	@Override
	public final void addSubConsult(final SubConsult subConsult) {
		baseDao.save(subConsult);
	}

	@Override
	public final void deleteSubConsult(final SubConsult subConsult) {
		baseDao.delete(subConsult);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<SubConsult> getSubConsults(final int consultId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(SubConsult.class);
		crit.add(Restrictions.like("consultId", consultId));
		crit.addOrder(Order.asc("time"));
		return crit.list();
	}

}
