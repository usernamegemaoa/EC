package njuse.ec.service;

import java.util.List;

import njuse.ec.vo.MessageVo;
import njuse.ec.vo.ResultVo;

/**
 * 消息模块.
 * @author 文
 *
 */
public interface MessageService {
	/**
	 * 添加消息.
	 * @param message 消息
	 * @return 结果
	 */
	ResultVo addMessage(MessageVo message);
	
	/**
	 * 阅读消息.
	 * @param message 消息
	 * @return 结果
	 */
	ResultVo readMessage(MessageVo message);
	
	/**
	 * 获取未读消息.
	 * @param userId 用户编号
	 * @return 消息列表
	 */
	List<MessageVo> getUnReadMessage(int userId);
	
	/**
	 * 获取所有消息.
	 * @param userId 用户编号
	 * @return 消息列表
	 */
	List<MessageVo> getAllMessage(int userId);
	
}
