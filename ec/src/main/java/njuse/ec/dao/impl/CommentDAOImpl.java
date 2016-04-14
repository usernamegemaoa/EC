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
	private BaseDao<Comment> baseDao;

	@Override
	public final void addComment(final Comment comment) {
		baseDao.save(comment);
	}

	@Override
	public final void deleteComment(final Comment comment) {
		baseDao.delete(comment);
	}

	@Override
	public final List<Comment> getComments(final int goodId) {
		return baseDao.findlist(Comment.class, "goodId", String.valueOf(goodId));
	}

	@Override
	public int getCommentNum(int goodId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(Comment.class);
		crit.add(Restrictions.like("goodId", goodId));
		crit.setProjection(Projections.rowCount());
		int count = Integer.parseInt(String.valueOf(crit.uniqueResult()));
		crit.setProjection(null);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getComments(int goodId, int firstResult, int maxResult) {
		Session session = getSession();
		Criteria crit = session.createCriteria(Comment.class);
		crit.add(Restrictions.like("goodId", goodId));
		crit.addOrder(Order.desc("time"));
		crit.setFirstResult(firstResult);
		crit.setMaxResults(maxResult);
		return crit.list();
	}
}
