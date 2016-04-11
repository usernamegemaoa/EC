package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public final void addSubConsult(final SubConsult subConsult) {
		Session session = getSession();
		session.save(subConsult);
	}

	@Override
	public final void deleteSubConsult(final SubConsult subConsult) {
		Session session = getSession();
		session.delete(subConsult);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<SubConsult> getSubConsult(final int consultId) {
		String hql = "selete * from sub_consult where consult_id = " 
	+ consultId + ";";
		Session session = getSession();
		return session.createQuery(hql).list();
	}

}
