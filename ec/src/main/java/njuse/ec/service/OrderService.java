package njuse.ec.service;

import java.util.List;

import njuse.ec.vo.CastVo;
import njuse.ec.vo.OrderDetailVo;
import njuse.ec.vo.OrderVo;
import njuse.ec.vo.ResultVo;

/**
 * 订单模块.
 * @author 文
 *
 */
public interface OrderService {
	
	/**
	 * 查看订单.
	 * @param userId 用户编号
	 * @return 订单列表
	 */
	List<OrderVo> viewOrder(int userId);
	
	/**
	 * 查看订单详情.
	 * @param userId 用户编号
	 * @param order 订单
	 * @return 订单详情列表
	 */
	List<OrderDetailVo>  viewOrderDetail(int userId, OrderVo order);
	/**
	 * 创建订单.
	 * @param userId 用户编号
	 * @param casts 购物车列表
	 * @param order 订单
	 * @return 结果
	 */
	ResultVo creatOrder(int userId, List<CastVo> casts, OrderVo order); 
	
	/**
	 * 取消订单.
	 * @param userId 用户编号
	 * @param order 订单
	 * @return 结果
	 */
	ResultVo cancelOrder(int userId, OrderVo order);
	
	/**
	 * 订单支付.
	 * @param userId 用户编号
	 * @param order 订单
	 * @return 结果
	 */
	ResultVo payOrder(int userId, OrderVo order);
	
	/**
	 * 订单发货.
	 * @param storeId 商家编号
	 * @param order 订单
	 * @param expressNumber 快递单号
	 * @return 结果
	 */
	ResultVo shipOrder(int storeId, OrderVo order, String expressNumber);
	
	/**
	 * 订单收货.
	 * @param userId 用户编号
	 * @param order 订单
	 * @return 结果
	 */
	ResultVo receiptOrder(int userId, OrderVo order);
	
	/**
	 * 申请退款.
	 * @param userId 用户编号
	 * @param order 订单
	 * @return 结果
	 */
	ResultVo refundOrder(int userId, OrderVo order);
	 
	/**
	 * 退款成功.
	 * @param userId 用户编号
	 * @param order 订单
	 * @return 结果
	 */
	ResultVo refundMoney(int userId, OrderVo order);

	/**
	 * 获得待付款订单
	 * @param userId
	 * @return 订单列表
	 */
	List<OrderVo> getWaitPayOrder(int userId); 
	/**
	 * 获得待发货订单
	 * @param userId
	 * @return 订单列表
	 */
	List<OrderVo> getWaitSendOrder(int userId);
	
	
	/**
	 * 获得待确认收货订单
	 * @param userId
	 * @return 订单列表
	 */
	List<OrderVo> getWaitConfirm(int userId);
	


	/**
	 * 获得可以申请退款的订单
	 * @param userId
	 * @return
	 */
	List<OrderVo> getrefundOrder(int userId);
	}

