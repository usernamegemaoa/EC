package njuse.ec.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.MessageVo;


/**
 * 消息模块测试.
 * @author 文
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MessageServiceTest {

	/**
	 * 消息模块.
	 */
	@Autowired
	private MessageService meService;
	
	/**
	 * 测试添加消息. 
	 */
	@Test
	public final void testAddMessage() {
		MessageVo message = new MessageVo();
		message.setMessage("系统消息");
		message.setRead(false);
		Date now=new Date();
		message.setTime(now);
		message.setUserId(1);
		meService.addMessage(message);
	}
}

