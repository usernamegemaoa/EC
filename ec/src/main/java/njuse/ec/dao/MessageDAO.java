package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Message;
import njuse.ec.vo.MessageVo;

public interface MessageDAO {
       List<Message> getUnReadMessage(int userId);
       List<Message> getAllMessage(int userId);
       boolean addMessage(Message message);
       boolean readMessage(Message message);
	   
}
