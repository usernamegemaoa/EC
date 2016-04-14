package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Comment;

/**
 * 评价DAO的接口设计.
 * @author 阳
 *
 */
public interface CommentDAO {
	
	/**
	 * 添加评价.
	 * @param comment 评价
	 */
	void addComment(Comment comment);
	
	/**
	 * 删除评价.
	 * @param comment 评价
	 */
	void deleteComment(Comment comment);
	
	/**
	 * 获取某件商品评论列表的个数.
	 * @param goodId 商品id
	 * @return 个数
	 */
	int getCommentNum(int goodId);
	
	/**
	 * 获取某一商品的评论列表. 
	 * @param goodId 商品id
	 * @return 评论列表
	 */
	List<Comment> getComments(int goodId);
	
	/**
	 * 获取某一商品评论的一部分.
	 * @param goodId 商品id
	 * @param firstResult 起始值
	 * @param maxResult 最大值
	 * @return 评论列表
	 */
	List<Comment> getComments(int goodId, int firstResult, int maxResult);
}
