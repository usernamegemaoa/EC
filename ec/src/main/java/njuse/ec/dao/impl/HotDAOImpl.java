package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.HotDAO;
import njuse.ec.model.Hot;

/**
 * 同类热销DAO的接口设计.
 * @author 阳
 *
 */
@Repository
public class HotDAOImpl implements HotDAO {
	
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
	public final void addHot(final Hot hot) {
		try {
			Session session = getSession();
			session.save(hot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void deleteHot(final Hot hot) {
		try {
			Session session = getSession();
			session.delete(hot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Hot> getHot(final int firstId) {
		String hql = "select * from hot where first_id = " + firstId + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();
		} catch (Exception e) {
			return null;
		}
	}
}
