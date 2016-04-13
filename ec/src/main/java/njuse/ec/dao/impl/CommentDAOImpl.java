package njuse.ec.dao.impl;

import java.util.List;

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
	 * baseDao.
	 */
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
}
