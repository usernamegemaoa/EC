package njuse.ec.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.OrderService;
import njuse.ec.vo.OrderVo;

@Repository
public class MyOrderAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2780549981670802793L;
	
	@Autowired
	private OrderService orderService;
	private List<OrderVo> orderList;
	
	public String getMyOrder(){
		int userId=0;
		orderList=orderService.viewOrder(userId);
		return "ViewOrderSuccess";
		
	}
}
