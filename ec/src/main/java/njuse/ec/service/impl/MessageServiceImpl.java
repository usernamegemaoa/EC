package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import njuse.ec.service.MessageService;
import njuse.ec.vo.MessageVo;
import njuse.ec.vo.ResultVo;

/**
 * 消息模块.
 * @author 文
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public final ResultVo addMessage(final MessageVo message) {
		ResultVo result = new ResultVo();
		if (message == null) {
			result.setResultCode(1);
		} else {
			result.setResultCode(0);
		}
		return result;
	}
	

	@Override
	public final ResultVo readMessage(final int userId, 
			final MessageVo message) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(1);
		} else {
			result.setResultCode(0);
		}
		return result;
	}

	@Override
	public final List<MessageVo> getUnReadMessage(final int userId, 
			final MessageVo message) {
		List<MessageVo> messageList = new ArrayList<MessageVo>();
		if (userId < 0) {
			return messageList;
		} else {
			messageList.add(message);
			return messageList;
		}
	}

	@Override
	public final List<MessageVo> getAllMessage(final int userId, 
			final MessageVo message) {
		List<MessageVo> messageList = new ArrayList<MessageVo>();
		if (userId < 0) {
			return messageList;
		} else {
			messageList.add(message);
			return messageList;
		}
	}

}
