package njuse.ec.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.CastVo;
import njuse.ec.vo.OrderVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderServiceTest {

	/**
	 * 订单模块.
	 */
	@Autowired
	private OrderService odService;
	
	@Test
	public void testCreatOrder() {
		List<CastVo> casts=null;
		assertEquals(1,odService.creatOrder(-1, casts).getResultCode());
		assertEquals(0,odService.creatOrder(0, casts).getResultCode());
	}

	@Test
	public void testCancelOrder() {
		OrderVo order=null;
		assertEquals(1,odService.cancelOrder(-1, order).getResultCode());
		assertEquals(0,odService.cancelOrder(0, order).getResultCode());
	}

	@Test
	public void testPayOrder() {
		OrderVo order=null;
		assertEquals(1,odService.payOrder(-1, order).getResultCode());
		assertEquals(0,odService.payOrder(0, order).getResultCode());
	}

	@Test
	public void testShipOrder() {
		OrderVo order=null;
		assertEquals(1,odService.shipOrder(-1, order).getResultCode());
		assertEquals(0,odService.shipOrder(0, order).getResultCode());
	}

	@Test
	public void testReceiptOrder() {
		OrderVo order=null;
		assertEquals(1,odService.receiptOrder(-1, order).getResultCode());
		assertEquals(0,odService.receiptOrder(0, order).getResultCode());
	}

	@Test
	public void testRefundOrder() {
		OrderVo order=null;
		assertEquals(1,odService.refundOrder(-1, order).getResultCode());
		assertEquals(0,odService.refundOrder(0, order).getResultCode());
	}

	@Test
	public void testRefundMoney() {
		OrderVo order=null;
		assertEquals(1,odService.refundMoney(-1, order).getResultCode());
		assertEquals(0,odService.refundMoney(0, order).getResultCode());
	}

}
