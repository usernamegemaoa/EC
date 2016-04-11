package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.SubCommentDAO;
import njuse.ec.model.SubComment;
/**
 * 自评价DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class SubCommentDAOImpl implements SubCommentDAO {

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
	public final void addSubComment(final SubComment subComment) {
		try {			
			Session session = getSession();
			session.save(subComment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void deleteSubComment(final SubComment subComment) {
		Session session = getSession();
		try {
			session.delete(subComment);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<SubComment> getSubComments(final int commentId) {
		String hql = "select * from sub_comment where comment_id = " 
	+ commentId + ";";
		Session session = getSession();
		try {			
			return session.createQuery(hql).list();
		} catch (Exception e) {
			return null;
		}
	}

}
