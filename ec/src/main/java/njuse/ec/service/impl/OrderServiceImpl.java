package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.CastDAO;
import njuse.ec.dao.OrderDAO;
import njuse.ec.model.Cast;
import njuse.ec.model.Order;
import njuse.ec.model.OrderInfo;
import njuse.ec.service.OrderService;
import njuse.ec.vo.CastVo;
import njuse.ec.vo.OrderDetailVo;
import njuse.ec.vo.OrderStatus;
import njuse.ec.vo.OrderVo;
import njuse.ec.vo.ResultVo;

/**
 * 订单模块.
 * 
 * @author 文
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	/**
	 * order dao.
	 */
	@Autowired
	private OrderDAO orderDao;
	/**
	 * cast dao.
	 */
	@Autowired
	private CastDAO castDao;

	@Override
	public final ResultVo creatOrder(
			final int userId,
			final List<CastVo> casts,
			final OrderVo order) {
		// 订单创建
		ResultVo result = new ResultVo();
		CastVo firstCast = casts.get(0);
		Cast thisCast = firstCast.convertCastVoToCast(firstCast);
		List<Cast> castList = new ArrayList<Cast>();
		int shopId = castDao.getShopId(thisCast);
		for (int i = 0; i < casts.size(); i++) {
			CastVo castVo = casts.get(i);
			Cast cast = castVo.convertCastVoToCast(castVo);
			castList.add(cast);
		}
		Order thisOrder = order.convertOrderVo(order);
		// 订单创建是否成功
		boolean success = orderDao.creatOrder(shopId, castList, thisOrder);
		if (success) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
			result.setResultMessage("订单创建失败");
		}
		return null;
	}

	@Override
	public final ResultVo cancelOrder(final int userId, final OrderVo order) {
		// 取消订单
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(1);
			result.setResultMessage("请先登录");
		} else {
			OrderStatus state = order.getStatus();
			Order newOrder = order.convertOrderVo(order);
			if (state == OrderStatus.WaitConfirm) {
				result.setResultCode(1);
				result.setResultMessage("订单已发货无法取消");
			} else if (state == OrderStatus.Refund) {
				result.setResultCode(1);
				result.setResultMessage("该订单正在申请退款，无法取消");
			} else {
				// System.out.println("TEST-------------------");
				boolean success = orderDao.cancelOrder(newOrder);
				if (success) {
					result.setResultCode(0);
				} else {
					result.setResultCode(1);
					result.setResultMessage("取消订单时发生错误，请稍后再试");
				}
			}
		}
		return result;
	}

	@Override
	public final ResultVo payOrder(final int userId, final OrderVo order) {
		// 订单支付
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(1);
			result.setResultMessage("请先登录");
		} else {
			Order newOrder = order.convertOrderVo(order);
			OrderStatus state = order.getStatus();
			if (state != OrderStatus.WaitPay) {
				result.setResultCode(1);
				result.setResultMessage("订单不处于待支付状态");
			} else {
				boolean success = orderDao.payOrder(newOrder);
				if (success) {
					result.setResultCode(0);
				} else {
					result.setResultCode(1);
					result.setResultMessage("订单支付时发生错误");
				}
			}
		}
		return result;
	}

	@Override
	public final ResultVo shipOrder(
			final int storeId, 
			final OrderVo order, 
			final String expressNumber) {
		// 订单发货
		ResultVo result = new ResultVo();
		if (storeId < 0) {
			result.setResultCode(1);
			result.setResultMessage("请先登录");
		} else {
			Order sendOrder = order.convertOrderVo(order);
			boolean success = orderDao.shipOrder(sendOrder, expressNumber);
			if (success) {
				result.setResultCode(0);
			} else {
				result.setResultCode(1);
				result.setResultMessage("确认发货时发生错误");
			}
		}
		return result;
	}

	@Override
	public final ResultVo receiptOrder(final int userId, final OrderVo order) {
		// 确认收货
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(1);
			result.setResultMessage("请先登录");
		} else {
			Order sendOrder = order.convertOrderVo(order);
			boolean success = orderDao.receiptOrder(sendOrder);
			if (success) {
				result.setResultCode(0);
			} else {
				result.setResultCode(1);
				result.setResultMessage("确认收货时发生错误");
			}
		}
		return result;
	}

	@Override
	public final ResultVo refundOrder(final int userId, final OrderVo order) {
		// 申请退款
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(1);
			result.setResultMessage("请先登录");
		} else {
			Order sendOrder = order.convertOrderVo(order);
			boolean success = orderDao.refundOrder(sendOrder);
			if (success) {
				result.setResultCode(0);
			} else {
				result.setResultCode(1);
				result.setResultMessage("申请退款时发生错误");
			}
		}
		return result;
	}

	@Override
	public final ResultVo refundMoney(final int userId, final OrderVo order) {
		// 确认退款
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(1);
			result.setResultMessage("请先登录");
		} else {
			Order sendOrder = order.convertOrderVo(order);
			boolean success = orderDao.refundMoney(sendOrder);
			if (success) {
				result.setResultCode(0);
			} else {
				result.setResultCode(1);
				result.setResultMessage("确认退款时发生错误");
			}
		}
		return result;
	}

	@Override
	public final List<OrderVo> viewOrder(final int userId) {
		// 订单查看
		List<OrderVo> result = new ArrayList<OrderVo>();
		if (userId > 0) {
			OrderVo order = new OrderVo();
			List<Order> allOrder = new ArrayList<Order>();
			allOrder = orderDao.viewOrder(userId);
			for (int i = 0; i < allOrder.size(); i++) {
				Order thisOrder = allOrder.get(i);
				OrderVo thisOrderVo = order.convertOrder(thisOrder);
				result.add(thisOrderVo);
			}
		}
		return result;
	}

	@Override
	public final List<OrderDetailVo> viewOrderDetail(
			final int userId, final OrderVo order) {
		// 查看订单详情
		List<OrderDetailVo> result = new ArrayList<OrderDetailVo>();
		if (userId > 0) {
			List<OrderInfo> orderInfo = new ArrayList<OrderInfo>();
			Order sendOrder = new Order();
			OrderDetailVo orderDetail = new OrderDetailVo();
			sendOrder = order.convertOrderVo(order);
			orderInfo = orderDao.getOrderInfo(sendOrder);
			result = orderDetail.convert(orderInfo);
		}
		return result;
	}

}
