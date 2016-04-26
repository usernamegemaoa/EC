package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Cast;
import njuse.ec.model.Order;
import njuse.ec.model.OrderInfo;
import njuse.ec.vo.CastVo;

/**
 * order dao.
 * @author 丞
 *
 */
public interface OrderDAO {
	/**
	 * 获取订单详情.
	 * @param order 订单
	 * @return 订单详情列表.
	 */
	List<OrderInfo> getOrderInfo(Order order);

	/**
	 * 查看用户订单.
	 * @param useId id
	 * @return 订单列表.
	 */
	List<Order> viewOrder(int useId);

	/**
	 * 创建订单.
	 * @param shopId 店铺id
	 * @param casts 购物车列表
	 * @param order 订单
	 * @return 是否成功
	 */
	boolean creatOrder(int shopId, List<CastVo> casts, Order order);

	/**
	 * 取消订单.
	 * @param order 订单
	 * @return 是否成功
	 */
	boolean cancelOrder(Order order);

	/**
	 * 支付订单.
	 * @param order 订单
	 * @return 是否成功
	 */
	boolean payOrder(Order order);

	/**
	 * 发货.
	 * @param order 订单
	 * @param expressNumber 快递单号码
	 * @return 是否成功
	 */
	boolean shipOrder(Order order, String expressNumber);

	/**
	 * 收货.
	 * @param order 订单
	 * @return 是否成功
	 */
	boolean receiptOrder(Order order);

	/**
	 * 退货.
	 * @param order 订单
	 * @return 是否成功
	 */
	boolean refundOrder(Order order);

	/**
	 * 退款.
	 * @param order 订单
	 * @return 是否成功
	 */
	boolean refundMoney(Order order);
	
	/**
	 * 查看待付款订单
	 * @param userId
	 * @return 订单列表
	 */

}
