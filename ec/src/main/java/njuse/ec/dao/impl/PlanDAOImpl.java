package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.PlanDAO;
import njuse.ec.model.Plan;

/**
 * 进货单DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class PlanDAOImpl implements PlanDAO {

	/**
	 * sessionFactory.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 获取一个session.
	 * @return session
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public final void addPlan(final Plan plan) {
		try {
		Session session = getSession();
		session.save(plan);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public final void deletePlan(final Plan plan) {
		try {
			Session session = getSession();
			session.delete(plan);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public final void modifyPlan(final Plan plan) {
		try {
			Session session = getSession();
			session.update(plan);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Plan> getPlan(final int userId) {
		String hql = "select * from plan where user_id = " + userId + ";";
		Session session = getSession();
		try {
		return session.createQuery(hql).list();
		} catch (Exception e) {
			return null;
		}
	}

}
