package njuse.ec.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.CastVo;
import njuse.ec.vo.OrderVo;

/**
 * 订单测试类.
 * @author 丞
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderServiceTest {

	/**
	 * 订单模块.
	 */
	@Autowired
	private OrderService odService;
	
	/**
	 * 测试创建订单. 
	 */
	@Test
	public final void testCreatOrder() {
		List<CastVo> casts = null;
		assertEquals(1, odService.creatOrder(-1, casts).getResultCode());
		assertEquals(0, odService.creatOrder(0, casts).getResultCode());
	}

	/**
	 * 测试取消订单. 
	 */
	@Test
	public final void testCancelOrder() {
		OrderVo order = null;
		assertEquals(1, odService.cancelOrder(-1, order).getResultCode());
		assertEquals(0, odService.cancelOrder(0, order).getResultCode());
	}

	/**
	 * 测试支付订单. 
	 */
	@Test
	public final void testPayOrder() {
		OrderVo order = null;
		assertEquals(1, odService.payOrder(-1, order).getResultCode());
		assertEquals(0, odService.payOrder(0, order).getResultCode());
	}

	/**
	 * 测试订单发货.
	 */
	@Test
	public final void testShipOrder() {
		OrderVo order = null;
		assertEquals(1, odService.shipOrder(-1, order).getResultCode());
		assertEquals(0, odService.shipOrder(0, order).getResultCode());
	}

	/**
	 * 测试收货. 
	 */
	@Test
	public final void testReceiptOrder() {
		OrderVo order = null;
		assertEquals(1, odService.receiptOrder(-1, order).getResultCode());
		assertEquals(0, odService.receiptOrder(0, order).getResultCode());
	}

	/**
	 * 测试退货. 
	 */
	@Test
	public final void testRefundOrder() {
		OrderVo order = null;
		assertEquals(1, odService.refundOrder(-1, order).getResultCode());
		assertEquals(0, odService.refundOrder(0, order).getResultCode());
	}

	/**
	 * 测试退款. 
	 */
	@Test
	public final void testRefundMoney() {
		OrderVo order = null;
		assertEquals(1, odService.refundMoney(-1, order).getResultCode());
		assertEquals(0, odService.refundMoney(0, order).getResultCode());
	}

}
