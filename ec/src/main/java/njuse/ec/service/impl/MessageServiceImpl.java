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
public class MessageServiceImpl implements MessageService{

	@Override
	public ResultVo addMessage(MessageVo message) {
		ResultVo result = new ResultVo();
		if (message == null) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}
	

	@Override
	public ResultVo readMessage(int userId, MessageVo message) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

	@Override
	public List<MessageVo> getUnReadMessage(int userId, MessageVo message) {
		List<MessageVo> messageList=new ArrayList<MessageVo>();
		if(userId < 0){
			return messageList;
		} else {
			messageList.add(message);
			return messageList;
		}
	}

	@Override
	public List<MessageVo> getAllMessage(int userId, MessageVo message) {
		List<MessageVo> messageList=new ArrayList<MessageVo>();
		if(userId < 0){
			return messageList;
		} else {
			messageList.add(message);
			return messageList;
		}
	}

}
