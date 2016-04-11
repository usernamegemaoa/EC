package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.PictureDAO;
import njuse.ec.model.Picture;

/**
 * 图片DAO接口实现.
 * @author 阳
 *
 */
@Repository
public class PictureDAOImpl implements PictureDAO {
	
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
	public final void addPic(final Picture pic) {
		try {
			Session session = getSession();
			session.save(pic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public final void deletePic(final Picture pic) {
		try {
			Session session = getSession();
			session.save(pic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Picture> getPics(final int goodId) {
		String hql = "select * from picture where good_id = " + goodId + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Picture> getMainPic(final int goodId) {
		String hql = "select * from picture where main = 'true' and good_id = " 
				+ goodId + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();
		} catch (Exception e) {
			return null;
		}
	}

}
