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
	private BaseDao<SubComment> baseDao;
	
	@Override
	public final void addSubComment(final SubComment subComment) {
		baseDao.save(subComment);
	}

	@Override
	public final void deleteSubComment(final SubComment subComment) {
		baseDao.delete(subComment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<SubComment> getSubComments(final int commentId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(SubComment.class);
		crit.add(Restrictions.like("commentId", commentId));
		crit.addOrder(Order.asc("time"));
		return crit.list();
	}

}
