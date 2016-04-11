package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.CommentDAO;
import njuse.ec.model.Comment;

/**
 * 评论DAO接口的实现.
 * @author 阳
 *
 */
@Repository
public class CommentDAOImpl implements CommentDAO {
	
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
	public final void addComment(final Comment comment) {
		try {			
			Session session = getSession();
			session.save(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void deleteComment(final Comment comment) {
		try {
			Session session = getSession();
			session.delete(comment);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Comment> getComments(final int goodId) {
		String hql = "select * from comment where good_id = " + goodId + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();		
		} catch (Exception e) {
			return null;
		}
	}

}
