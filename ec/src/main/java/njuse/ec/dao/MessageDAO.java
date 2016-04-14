package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Message;

/**
 * message dao.
 * 
 * @author 丞
 *
 */
public interface MessageDAO {
	/**
	 * 获取未读消息.
	 * @param userId 用户id
	 * @return 消息列表.
	 */
	List<Message> getUnReadMessage(int userId);

	/**
	 * 获取全部消息.
	 * @param userId 用户id
	 * @return 消息列表
	 */
	List<Message> getAllMessage(int userId);

	/**
	 * 添加消息.
	 * @param message 消息
	 * @return 是否成功
	 */
	boolean addMessage(Message message);

	/**
	 * 阅读消息.
	 * @param message 消息
	 * @return 是否成功
	 */
	boolean readMessage(Message message);

}
