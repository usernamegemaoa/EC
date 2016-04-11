package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public final void addConsult(final Consult consult) {
		try {
			Session session = getSession();
			session.save(consult);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void deleteConsult(final Consult consult) {
		try {
			Session session = getSession();
			session.delete(consult);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Consult> getConsults(final int goodId) {
		String hql = "select * from consult where good_id = " + goodId + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();			
		} catch (Exception e) {
			return null;
		}
	}

}
