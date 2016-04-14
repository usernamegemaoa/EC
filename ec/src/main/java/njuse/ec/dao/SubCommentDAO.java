package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.SubComment;

/**
 * 子评价DAO接口设计.
 * @author 阳
 *
 */
public interface SubCommentDAO {
	
	/**
	 * 添加子评价.
	 * @param subComment 子评价
	 */
	void addSubComment(SubComment subComment);
	
	/**
	 * 删除子评价.
	 * @param subComment 子评价
	 */
	void deleteSubComment(SubComment subComment);
	
	/**
	 * 获取子评价.
	 * @param commentId 父评价id
	 * @return 子评价列表
	 */
	List<SubComment> getSubComments(int commentId);
}
