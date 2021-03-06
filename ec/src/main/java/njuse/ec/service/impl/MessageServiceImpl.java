package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.MessageDAO;
import njuse.ec.model.Message;
import njuse.ec.service.MessageService;
import njuse.ec.vo.MessageVo;
import njuse.ec.vo.ResultVo;

/**
 * 消息模块.
 * 
 * @author 文
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	/**
	 * message dao.
	 */
	@Autowired
	private MessageDAO messageDao;

	@Override
	public final ResultVo addMessage(final MessageVo message) {
		ResultVo result = new ResultVo();
		int userId = message.getUserId();
		String content = message.getMessage();
		boolean isRead = message.isRead();
		Date time = message.getTime();
		Message sendMessage = new Message();
		sendMessage.setContent(content);
		sendMessage.setIs_read(isRead);
		sendMessage.setTime(time);
		sendMessage.setUser_id(userId);
		// 判断消息是否添加到了数据库
		boolean result1 = messageDao.addMessage(sendMessage);
		if (result1) { // 消息发送成功
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

	@Override
	public final ResultVo readMessage(final MessageVo message) {
		ResultVo result = new ResultVo();
		int id = message.getId();
		Message sendMessage = new Message();
		sendMessage.setId(id);
		// 判断消息信息是否修改成功
		boolean result1 = messageDao.readMessage(sendMessage);
		if (result1) { // 消息修改成功
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

	@Override
	public final List<MessageVo> getUnReadMessage(final int userId) {
		// 从数据库中获得的未读消息列表
		List<Message> unReadMessageList = new ArrayList<Message>();
		List<MessageVo> result = new ArrayList<MessageVo>(); // 结果列表
		unReadMessageList = messageDao.getUnReadMessage(userId);
		MessageVo mv = new MessageVo();
		result = mv.convert(unReadMessageList);
		return result;
	}

	@Override
	public final List<MessageVo> getAllMessage(final int userId) {
		List<Message> allMessageList = new ArrayList<Message>();
		List<MessageVo> result = new ArrayList<MessageVo>();
		allMessageList = messageDao.getAllMessage(userId);
		MessageVo mv = new MessageVo();
		result = mv.convert(allMessageList);
		return result;
	}

}
