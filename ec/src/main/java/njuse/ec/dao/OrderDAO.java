package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Cast;
import njuse.ec.model.Order;
import njuse.ec.model.OrderInfo;


public interface OrderDAO {
	List<OrderInfo> getOrderInfo(Order order);
	List<Order> viewOrder(int useId);
	boolean creatOrder(int shop_id, List<Cast> casts,Order order); 
	boolean cancelOrder(Order order);
	boolean payOrder(Order order);
	boolean shipOrder(Order order, String express_number);
	boolean receiptOrder(Order order);
	boolean refundOrder(Order order);
	boolean refundMoney(Order order);
}
