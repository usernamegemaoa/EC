package njuse.ec.service;

import java.util.List;

import njuse.ec.vo.CastVo;
import njuse.ec.vo.OrderVo;
import njuse.ec.vo.ResultVo;

/**
 * 订单模块.
 * @author 文
 *
 */
public interface OrderService {
	
	/**
	 * 创建订单.
	 * @param userId 用户编号
	 * @param casts 购物车列表
	 * @return 结果
	 */
	ResultVo creatOrder(int userId, List<CastVo> casts); 
	
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
	 * @return 结果
	 */
	ResultVo shipOrder(int storeId, OrderVo order);
	
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
	
}
