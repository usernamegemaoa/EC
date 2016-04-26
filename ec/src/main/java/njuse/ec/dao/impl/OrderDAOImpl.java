package njuse.ec.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.CastDAO;
import njuse.ec.dao.OrderDAO;
import njuse.ec.dao.PlanDAO;
import njuse.ec.model.OrderInfo;
import njuse.ec.model.Picture;
import njuse.ec.model.Plan;
import njuse.ec.service.CastService;
import njuse.ec.vo.CastVo;
import njuse.ec.model.Cast;
import njuse.ec.model.Order;

/**
 * order dao.
 * 
 * @author 丞
 *
 */
@Repository
public class OrderDAOImpl implements OrderDAO {
	/**
	 * session factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BaseDao<Order> baseDao;
	/**
	 * plan dao.
	 */
	@Autowired
	private PlanDAO planDao;
	@Autowired
	private CastService castService;

	/**
	 * 获取session.
	 * 
	 * @return session
	 */
	public final Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public final boolean creatOrder(
			final int shopId, 
			final List<CastVo> casts, 
			final Order order) {
		// 创建订单
		// !!!缺少库存数量判断
		boolean success = true;
		order.setUser_id(casts.get(0).getUserId());
		Date now = new Date();
		order.setTime(now);
		order.setShop_id(shopId);
		order.setIs_read(1);
		order.setState(1);
		order.setExpress_number(null);
		Session session = getSession();
		int orderId = 0;
		try {
			orderId = (int) session.save(order);
		} catch (Exception e) {
			success = false; // 订单创建时出错
		}
		if (success) {
			List<OrderInfo> orderInfo = new ArrayList<OrderInfo>();
			for (int i = 0; i < casts.size(); i++) { // 将castVo转化为orderinfo
				CastVo cast = casts.get(i);
				Plan thisPlan=castService.convertToPlan(cast);
				OrderInfo singleInfo = new OrderInfo();
				singleInfo.setColor(cast.getColor());
				singleInfo.setGood_id(cast.getGoodId());
				singleInfo.setOrder_id(orderId);
				singleInfo.setPrice(planDao.getPrice(thisPlan));
				singleInfo.setQuantity(cast.getNum());
				singleInfo.setSize(cast.getSize());
				orderInfo.add(singleInfo);
			}
			try {
				for (int i = 0; i < orderInfo.size(); i++) {
					session.save(orderInfo.get(i));
					if (i % 20 == 0) {
						session.flush();
					}
				}
				session.flush();
			} catch (Exception e) {
				success = false; // 订单创建时出错
			}
		}
		return success;
	}

	@Override
	public final boolean cancelOrder(final Order order) {
		boolean success = true;
		int id = order.getId();
		Session session = getSession();

		try {
			// System.out.println("TEST-------------");
			Order delOrder = (Order) session.get(Order.class, id);
			session.delete(delOrder);
			session.flush();
		} catch (Exception e) {
			success = false; // 订单删除时出错
		}
		return success;
	}

	@Override
	public final boolean payOrder(final Order order) {
		boolean success = true;
		order.setState(2);
		Session session = getSession();
		try {
			session.update(order);
			session.flush();
		} catch (Exception e) {
			success = false;// 修改订单状态时出错
		}
		return success;
	}

	@Override
	public final boolean shipOrder(
			final Order order, final String expressNumber) {
		boolean success = true;
		order.setExpress_number(expressNumber);
		order.setState(3);
		Session session = getSession();
		try {
			session.update(order);
			session.flush();
		} catch (Exception e) {
			success = false; // 修改订单状态时出错
		}
		return success;
	}

	@Override
	public final boolean receiptOrder(final Order order) {
		boolean success = true;
		order.setState(4);
		Session session = getSession();
		try {
			session.update(order);
			session.flush();
		} catch (Exception e) {
			success = false; // 修改订单状态时出错
		}
		return success;
	}

	@Override
	public final boolean refundOrder(final Order order) {
		boolean success = true;
		order.setState(5);
		Session session = getSession();
		try {
			session.update(order);
			session.flush();
		} catch (Exception e) {
			success = false; // 修改订单状态时出错
		}
		return success;
	}

	@Override
	public final boolean refundMoney(final Order order) {
		boolean success = true;
		order.setState(6);
		Session session = getSession();
		try {
			session.update(order);
			session.flush();
		} catch (Exception e) {
			success = false; // 修改订单状态时出错
		}
		return success;
	}

	@Override
	public final List<Order> viewOrder(final int userId) {
		return baseDao.findlist(Order.class, "user_id", String.valueOf(userId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<OrderInfo> getOrderInfo(final Order order) {
		int id = order.getId();
		String hql = "select * from `orderInfo` where order_id=" + id + "";
		Session session = getSession();
		return session.createSQLQuery(hql).list();
	}

	@Override
	public final List<Order> getWaitPayOrder(final int userId) {
		
		return baseDao.findlist(Order.class, "user_id", String.valueOf(userId));
	}

	@Override
	public final List<Order> getWaitSendOrder(final int userId) {
		String hql = "select * from `order` where user_id=" + userId + " and state=2";
		Session session = getSession();
		return session.createSQLQuery(hql).list();
	}

	@Override
	public final List<Order> getWaitConfirmOrder(final int userId) {
		String hql = "select * from `order` where user_id=" + userId + " and state=3";
		Session session = getSession();
		return session.createSQLQuery(hql).list();
	}

	@Override
	public final List<Order> getrefundOrder(final int userId) {
		String hql = "select * from `order` where user_id=" + userId + " and state=5";
		Session session = getSession();
		return session.createSQLQuery(hql).list();
	}

}
