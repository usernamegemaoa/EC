package njuse.ec.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import njuse.ec.model.Message;

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
	 * 消息发送时间
	 */
	private Date time;
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
	/**
	 * @return time
	 */
	public final Date getTime(){
		return time;
	}
	/**
	 * @param newTime the time to set
	 */
	public final void setTime(final Date newTime){
		this.time=newTime;
	}
	
	public List<MessageVo> convert(List<Message> message){
		List<MessageVo> result=new ArrayList<MessageVo>();       //结果列表  
		for(int i=0;i<message.size();i++){             //将message转化为messageVo
			MessageVo thisMessage=new MessageVo();
			int id=message.get(i).getId();
			String newMessage=message.get(i).getContent();
			Date time=message.get(i).getTime();
			thisMessage.setId(id);
			thisMessage.setRead(message.get(i).getIs_read());
			thisMessage.setUserId(userId);
			thisMessage.setMessage(newMessage);
			thisMessage.setTime(time);
			result.add(thisMessage);
		}
		return result;
	}
}
