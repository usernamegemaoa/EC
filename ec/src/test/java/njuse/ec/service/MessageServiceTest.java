package njuse.ec.service;

import static org.junit.Assert.assertEquals;

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
		MessageVo nullMessage = null;
		message.setUserId(0);
		assertEquals(0, meService.addMessage(message).getResultCode());
		assertEquals(1, meService.addMessage(nullMessage).getResultCode());
	}

	/**
	 * 测试阅读消息.
	 */
	@Test
	public final void testReadMessage() {
		MessageVo message = new MessageVo();
		assertEquals(1, meService.readMessage(-1, message).getResultCode());
		assertEquals(0, meService.readMessage(0, message).getResultCode());
	}

	/**
	 * 测试获取未读列表.
	 */
	@Test
	public final void testGetUnReadMessage() {
		MessageVo message = new MessageVo();
		assertEquals(1, meService.getUnReadMessage(0, message).size());
	}

	/**
	 * 测试获取所有消息列表.
	 */
	@Test
	public final void testGetAllMessage() {
		MessageVo message = new MessageVo();
		assertEquals(1, meService.getAllMessage(0, message).size());
	}

}
