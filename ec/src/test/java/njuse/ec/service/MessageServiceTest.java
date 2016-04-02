package njuse.ec.service;

import static org.junit.Assert.*;

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
	 * 消息模块
	 */
	@Autowired
	private MessageService meService;
	
	@Test
	public void testAddMessage() {
		MessageVo message=null;
		MessageVo message1=null;
		message1.setUserId(0);
		assertEquals(1,meService.addMessage(message).getResultCode());
		assertEquals(0,meService.addMessage(message1).getResultCode());
	}

	@Test
	public void testReadMessage() {
		MessageVo message=null;
		assertEquals(1,meService.readMessage(-1, message).getResultCode());
		assertEquals(0,meService.readMessage(0, message).getResultCode());
	}

	@Test
	public void testGetUnReadMessage() {
		MessageVo message=null;
		assertEquals(0,meService.getUnReadMessage(0,message).size());
	}

	@Test
	public void testGetAllMessage() {
		MessageVo message=null;
		assertEquals(0,meService.getAllMessage(0,message).size());
	}

}
