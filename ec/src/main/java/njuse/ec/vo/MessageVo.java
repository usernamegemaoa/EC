package njuse.ec.vo;

/**
 * 消息vo.
 * @author 丞
 *
 */
public class MessageVo {

	/**
	 * 消息id.
	 */
	private int id;
	/**
	 * 用户id.
	 */
	private int userId;
	/**
	 * 消息内容.
	 */
	private String message;
	/**
	 * 是否阅读.
	 */
	private boolean read;
	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * @param newId the id to set
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}
	/**
	 * @return the userId
	 */
	public final int getUserId() {
		return userId;
	}
	/**
	 * @param newUserId the userId to set
	 */
	public final void setUserId(final int newUserId) {
		this.userId = newUserId;
	}
	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}
	/**
	 * @param newMessage the message to set
	 */
	public final void setMessage(final String newMessage) {
		this.message = newMessage;
	}
	/**
	 * @return the read
	 */
	public final boolean isRead() {
		return read;
	}
	/**
	 * @param newRead the read to set
	 */
	public final void setRead(final boolean newRead) {
		this.read = newRead;
	}
}
