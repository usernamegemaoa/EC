package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public final void addGood(final Good good) {
		try {
			Session session = getSession();
			session.save(good);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void deleteGood(final Good good) {
		try {
			Session session = getSession();
			session.delete(good);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Good> getLatestGoods() {
		String hql = "select * from good order by time desc" + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();		
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Good> getKindGoods(final int kindId) {
		String hql = "select * from good where kind_id = " + kindId + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();			
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Good> getNameGoods(final String name) {
		String hql = "select * from good where name = " + name + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();			
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Good> getGood(final int id) {
		String hql = "select * from good where id =" + id + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();			
		} catch (Exception e) {
			return null;
		}
	}

}
