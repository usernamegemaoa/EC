package njuse.ec.vo;

import java.util.Date;

/**
 * 评价vo.
 * @author 阳
 *
 */
public class CommentVo {

	/**
	 * 评价id.
	 */
	private int commentId;
	
	/**
	 * 评价者id.
	 */
	private int userId;
	
	/**
	 * 评价商品id.
	 */
	private int goodId;
	
	/**
	 * 评价分数.
	 */
	private int score;
	
	/**
	 * 父评价.
	 */
	private int fatherId;
	
	/**
	 * 评价内容.
	 */
	private String comment;
	
	/**
	 * 评价时间.
	 */
	private Date time;

	/**
	 * 获取评价id.
	 * @return 评价id
	 */
	public final int getCommentId() {
		return commentId;
	}

	/**
	 * 设置评价id.
	 * @param newCommentId 评价id
	 */
	public final void setCommentId(final int newCommentId) {
		this.commentId = newCommentId;
	}

	/**
	 * 获取评价者id.
	 * @return 评价者id
	 */
	public final int getUserId() {
		return userId;
	}

	/**
	 * 设置评价者id.
	 * @param newUserId 评价者id
	 */
	public final void setUserId(final int newUserId) {
		this.userId = newUserId;
	}

	/**
	 * 获取评价商品id.
	 * @return 评价商品id
	 */
	public int getGoodId() {
		return goodId;
	}

	/**
	 * 设置评价商品id.
	 * @param newGoodId 商品id
	 */
	public void setGoodId(int newGoodId) {
		this.goodId = newGoodId;
	}

	/**
	 * 获取评价分数.
	 * @return 评价分数
	 */
	public final int getScore() {
		return score;
	}

	/**
	 * 设置评价分数.
	 * @param newScore 评价分数
	 */
	public final void setScore(final int newScore) {
		this.score = newScore;
	}

	/**
	 * 获取父评价.
	 * @return 父评价
	 */
	public final int getFatherComment() {
		return fatherId;
	}

	/**
	 * 设置父评价.
	 * @param newFatherId 父评价
	 */
	public final void setFatherComment(final int newFatherId) {
		this.fatherId = newFatherId;
	}

	/**
	 * 获取评价内容.
	 * @return 评价内容
	 */
	public final String getComment() {
		return comment;
	}

	/**
	 * 设置评价内容.
	 * @param newComment 评价内容
	 */
	public final void setComment(final String newComment) {
		this.comment = newComment;
	}

	/**
	 * 获取评价时间.
	 * @return 评价时间
	 */
	public final Date getTime() {
		return time;
	}

	/**
	 * 设置评价时间.
	 * @param newTime 评价时间
	 */
	public final void setTime(final Date newTime) {
		this.time = newTime;
	}
}
