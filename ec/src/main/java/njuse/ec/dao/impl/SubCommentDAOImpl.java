package njuse.ec.dao.impl;

import java.util.List;

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

	@Override
	public final List<SubComment> getSubComments(final int commentId) {
		return baseDao.findlist(SubComment.class, "commentId", String.valueOf(commentId));
	}

}
