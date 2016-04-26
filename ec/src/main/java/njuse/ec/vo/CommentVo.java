package njuse.ec.vo;

/**
 * 评论vo.
 * @author 阳
 *
 */
public class CommentVo {

	/**
	 * 评论id.
	 */
	private int commentId;
	
	/**
	 * 评论者id.
	 */
	private int userId;
	
	/**
	 * 父评论.
	 */
	private CommentVo fatherComment;
	
	/**
	 * 评论内容.
	 */
	private String comment;

	/**
	 * 获取评论id.
	 * @return 评论id
	 */
	public final int getCommentId() {
		return commentId;
	}

	/**
	 * 设置评论id.
	 * @param newCommentId 评论id
	 */
	public final void setCommentId(final int newCommentId) {
		this.commentId = newCommentId;
	}

	/**
	 * 获取评论者id.
	 * @return 评论者id
	 */
	public final int getUserId() {
		return userId;
	}

	/**
	 * 设置评论者id.
	 * @param newUserId 评论者id
	 */
	public final void setUserId(final int newUserId) {
		this.userId = newUserId;
	}

	/**
	 * 获取父评论.
	 * @return 父评论
	 */
	public final CommentVo getFatherComment() {
		return fatherComment;
	}

	/**
	 * 设置父评论.
	 * @param newFatherComment 父评论
	 */
	public final void setFatherComment(final CommentVo newFatherComment) {
		this.fatherComment = newFatherComment;
	}

	/**
	 * 获取评论内容.
	 * @return 评论内容
	 */
	public final String getComment() {
		return comment;
	}

	/**
	 * 设置评论内容.
	 * @param newComment 评论内容
	 */
	public final void setComment(final String newComment) {
		this.comment = newComment;
	}
}
