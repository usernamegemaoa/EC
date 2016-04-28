package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.OrderDAO;
import njuse.ec.dao.PlanDAO;
import njuse.ec.model.Order;
import njuse.ec.model.OrderInfo;
import njuse.ec.model.Plan;
import njuse.ec.service.CastService;
import njuse.ec.service.GoodService;
import njuse.ec.service.OrderService;
import njuse.ec.vo.CastVo;
import njuse.ec.vo.ColorElement;
import njuse.ec.vo.DetailElement;
import njuse.ec.vo.GoodElement;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.OrderDetailVo;
import njuse.ec.vo.OrderElement;
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
	 * plan dao.
	 */
	@Autowired
	private PlanDAO castDao;
	
	@Autowired
	private CastService castService;
	
	@Autowired
	private BaseDao<Order> orderBaseDao;
	
	@Autowired
	private BaseDao<OrderInfo> infoDao;
	
	@Autowired
	private GoodService goodService;

	@Override
	public final ResultVo creatOrder(
			final int userId,
			final List<CastVo> casts,
			final OrderVo order) {
		// 订单创建
		ResultVo result = new ResultVo();
		CastVo firstCast = casts.get(0);
		Plan thisPlan = castService.convertToPlan(firstCast);
		int shopId = castDao.getShopId(thisPlan);
		Order thisOrder = order.convertOrderVo(order);
		// 订单创建是否成功
		boolean success = orderDao.creatOrder(shopId, casts, thisOrder);
		if (success) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
			result.setResultMessage("订单创建失败");
		}
		return null;
	}

	@Override
	public final ResultVo cancelRefund(final int userId,final OrderVo order){
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(1);
			result.setResultMessage("请先登录");
		}else{
			Order newOrder = order.convertOrderVo(order);
			boolean success = orderDao.cancelRefund(newOrder);
			if (success) {
				result.setResultCode(0);
			} else {
				result.setResultCode(1);
				result.setResultMessage("取消申请退款失败");
			}
		}
		return result;
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
	public final List<OrderElement> viewOrder(final int userId) {
		// 订单查看
		List<Order> orders = orderBaseDao.findlist(
				Order.class, 
				"user_id", 
				String.valueOf(userId));
		
		return convertOrders(orders);
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
	
	@Override
	public final List<OrderElement> getWaitPayOrder(
			final int userId) {
		//查看待支付订单
		List<Order> orders = orderBaseDao.findlist(
				Order.class, 
				"user_id", 
				String.valueOf(userId));
		Iterator<Order> i = orders.iterator();
		while (i.hasNext()) {
			Order order = i.next();
			if (order.getState() != OrderStatus.WaitPay.getCode() + 1) {
				i.remove();
			}
		}
		
		return convertOrders(orders);
	}

	@Override
	public final List<OrderElement> getWaitSendOrder(final int userId) {
		//查看待发货订单
				List<Order> orders = orderBaseDao.findlist(
						Order.class, 
						"user_id", 
						String.valueOf(userId));
				Iterator<Order> i = orders.iterator();
				while (i.hasNext()) {
					Order order = i.next();
					if (order.getState() != OrderStatus.WaitSend.getCode() + 1) {
						i.remove();
					}
				}
				
				return convertOrders(orders);
	}

	@Override
	public final List<OrderElement> getWaitConfirm(final int userId) {

		//查看待确认订单
				List<Order> orders = orderBaseDao.findlist(
						Order.class, 
						"user_id", 
						String.valueOf(userId));
				Iterator<Order> i = orders.iterator();
				while (i.hasNext()) {
					Order order = i.next();
					System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
					System.out.println(order.getState());
					System.out.println(OrderStatus.WaitConfirm.getCode());
					if (order.getState() != (OrderStatus.WaitConfirm.getCode() + 1)) {
						
						i.remove();
					}
				}
				
				return convertOrders(orders);
	}

	@Override
	public final List<OrderElement> getrefundOrder(final int userId) {

		//查看可退款订单
				List<Order> orders = orderBaseDao.findlist(
						Order.class, 
						"user_id", 
						String.valueOf(userId));
				Iterator<Order> i = orders.iterator();
				while (i.hasNext()) {
					Order order = i.next();
					if (order.getState() != OrderStatus.Refund.getCode() + 1) {
						i.remove();
					}
				}
				
				return convertOrders(orders);
	}
	
	/**
	 * order to orderElement.
	 * @param orders model
	 * @return vo
	 */
	private List<OrderElement> convertOrders(final List<Order> orders) {
		List<OrderElement> elements = new ArrayList<OrderElement>();
		
		// 逐个遍历order
		Iterator<Order> iOrder = orders.iterator();
		while (iOrder.hasNext()) {
			Order order = iOrder.next();
			OrderElement element = new OrderElement();
			element.setOrderId(order.getId());
			switch(order.getState()) {
			case 1:
				element.setStatus("待支付");
				break;
			case 2:
				element.setStatus("待发货");
				break;
			case 3:
				element.setStatus("待确认");
				break;
			case 4:
				element.setStatus("待评价");
				break;
			case 5:
				element.setStatus("退款中");
				break;
			case 6:
				element.setStatus("已完成");
				break;
			default:
				element.setStatus("status异常");
				break;
			}
			List<OrderInfo> infos = infoDao.findlist(
					OrderInfo.class, 
					"order_id", 
					String.valueOf(order.getId()));
			Iterator<OrderInfo> iInfo = infos.iterator();
			HashMap<Integer, List<OrderInfo>> goodSplit = new HashMap<>();
			element.setGoodList(new ArrayList<GoodElement>());
			double totalPrice = 0;
			int totalNum = 0;
			while (iInfo.hasNext()) {
				OrderInfo info = iInfo.next();
				if (!goodSplit.containsKey(info.getGood_id())) {
					goodSplit.put(info.getGood_id(), new ArrayList<OrderInfo>());
				}
				goodSplit.get(info.getGood_id()).add(info);
			}
			Iterator<Entry<Integer, List<OrderInfo>>> iGoodSplit = goodSplit.entrySet().iterator();
			while (iGoodSplit.hasNext()) {
				Entry<Integer, List<OrderInfo>> entry = iGoodSplit.next();
				int goodId = entry.getKey();
				List<OrderInfo> infoList = entry.getValue();
				GoodVo goodVo = goodService.getDetailGood(goodId);
				GoodElement goodElement = new GoodElement();
				goodElement.setImg(goodVo.getMainPic());
				goodElement.setName(goodVo.getName());
				
				HashMap<String, ColorElement> colorMap = new HashMap<>();
				Iterator<OrderInfo> iInfoList = infoList.iterator();
				while (iInfoList.hasNext()) {
					OrderInfo singleInfo = iInfoList.next();
					if (!colorMap.containsKey(singleInfo.getColor())) {
						ColorElement colorElement = new ColorElement();
						colorElement.setColor(singleInfo.getColor());
						colorElement.setDetailList(new ArrayList<DetailElement>());
						colorMap.put(singleInfo.getColor(), colorElement);
					}
					ColorElement colorElement = colorMap.get(singleInfo.getColor());
					DetailElement detailElement = new DetailElement();
					detailElement.setNum(singleInfo.getQuantity());
					detailElement.setSize(singleInfo.getSize());
					detailElement.setUnitPrice(goodVo.getPrice());
					double singleTotal = goodVo.getPrice() * singleInfo.getQuantity();
					detailElement.setTotalPrice(singleTotal);
					totalPrice += singleTotal;
					totalNum += singleInfo.getQuantity();
					colorElement.getDetailList().add(detailElement);
				}
				goodElement.setColorList(new ArrayList<ColorElement>(colorMap.values()));
				element.getGoodList().add(goodElement);
				elements.add(element);
			}
			element.setTotalPrice(totalPrice);
			element.setTotalNum(totalNum);
			elements.add(element);
		}
		
		return elements;
	}

	@Override
	public final OrderElement oneOrder(final int orderId) {
		System.out.println("orderid"+orderId);
		Order order = orderBaseDao.load(Order.class, orderId);
		List<Order> oneList = new ArrayList<>();
		oneList.add(order);
		List<OrderElement> oneElement = convertOrders(oneList);
		return oneElement.get(0);
	}
}
