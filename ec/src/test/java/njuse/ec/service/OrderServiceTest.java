package njuse.ec.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.CastVo;
import njuse.ec.vo.OrderStatus;
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
//	/**
//	 * 测试创建订单. 
//	 */
//	@Test
//	public final void testCreatOrder() {
//		OrderVo order=new OrderVo();
//		order.setPeopleName("张博文");
//		order.setPhone("13016938635");
//		order.setPlaceCode(100000);
//		order.setPlaceName("南京");
//		order.setStatus(OrderStatus.WaitPay);
//		CastVo cast=new CastVo();
//		cast.setCastId(1);
//		cast.setColor("黑色");
//		cast.setGoodId(1);
//		cast.setNum(1);
//		cast.setStockId(1);
//		cast.setUserId(1);
//		cast.setSize("M");
//		List<CastVo> castList=new ArrayList<CastVo>();
//		castList.add(cast);
//		odService.creatOrder(1, castList, order);
//	}


	/**
	 * 测试取消订单. 
	 */
	@Test
	public final void testCancelOrder() {
		OrderVo order = new OrderVo();
		order.setId(1);
		order.setStatus(OrderStatus.WaitPay);
		odService.cancelOrder(1, order);
	}
//
//	/**
//	 * 测试支付订单. 
//	 */
//	@Test
//	public final void testPayOrder() {
//		OrderVo order = null;
//		assertEquals(1, odService.payOrder(-1, order).getResultCode());
//		assertEquals(0, odService.payOrder(0, order).getResultCode());
//	}
//
//	/**
//	 * 测试订单发货.
//	 */
//	@Test
//	public final void testShipOrder() {
//		OrderVo order = null;
//		assertEquals(1, odService.shipOrder(-1, order).getResultCode());
//		assertEquals(0, odService.shipOrder(0, order).getResultCode());
//	}
//
//	/**
//	 * 测试收货. 
//	 */
//	@Test
//	public final void testReceiptOrder() {
//		OrderVo order = null;
//		assertEquals(1, odService.receiptOrder(-1, order).getResultCode());
//		assertEquals(0, odService.receiptOrder(0, order).getResultCode());
//	}
//
//	/**
//	 * 测试退货. 
//	 */
//	@Test
//	public final void testRefundOrder() {
//		OrderVo order = null;
//		assertEquals(1, odService.refundOrder(-1, order).getResultCode());
//		assertEquals(0, odService.refundOrder(0, order).getResultCode());
//	}
//
//	/**
//	 * 测试退款. 
//	 */
//	@Test
//	public final void testRefundMoney() {
//		OrderVo order = null;
//		assertEquals(1, odService.refundMoney(-1, order).getResultCode());
//		assertEquals(0, odService.refundMoney(0, order).getResultCode());
//	}

}
