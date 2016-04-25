package njuse.ec.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.model.Order;
import njuse.ec.service.OrderService;
import njuse.ec.vo.OrderDetailVo;
import njuse.ec.vo.OrderVo;

@Repository
public class MyOrderAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2780549981670802793L;
	
	@Autowired
	private OrderService orderService;
	private List<OrderVo> allOrderList;
	private List<OrderVo> waitPayOrderList;
	private List<OrderVo> waitSendOrderList;
	private List<OrderVo> waitConfirmOrderList;
	private List<OrderVo> refundOrderList;
	private List<OrderDetailVo> allOrderDetailList;
	private List<OrderDetailVo> waitPayOrderDetailList;
	private List<OrderDetailVo> waitSendOrderDetailList;
	private List<OrderDetailVo> waitConfirmOrderDetailList;
	private List<OrderDetailVo> refundOrderDetailList;
	private int userId;
	private ArrayList<String> pictureList;
	
	
	public String excute(){
		getAllOrder();
		getWaitPayOrder();
		getWaitSendOrder();
		getWaitConfirmOrder();
		getrefundOrder();
		return SUCCESS;
	}

	
	public String getAllOrder(){
		System.out.println("-------------------");
		int userId=123;
		//userId=(int) session.get(userId);
		allOrderList=orderService.viewOrder(userId);
		for(int i=0;i<allOrderList.size();i++){
			int orderId=allOrderList.get(i).getId();
			allOrderDetailList=getOrderDetail(allOrderList);
		}
		return "ViewOrderSuccess";
		}
	
	public String getWaitPayOrder(){
		waitPayOrderList=orderService.getWaitPayOrder(userId);
		for(int i=0;i<waitPayOrderList.size();i++){
			int orderId=waitPayOrderList.get(i).getId();
			waitPayOrderDetailList=getOrderDetail(waitPayOrderList);
		}
		return "getWaitPayOrderSuccess";
		}
	
	public String getWaitSendOrder(){
		waitSendOrderList=orderService.getWaitPayOrder(userId);
		for(int i=0;i<waitSendOrderList.size();i++){
			int orderId=waitSendOrderList.get(i).getId();
			waitSendOrderDetailList=getOrderDetail(waitSendOrderList);
		}
		return "getWaitSendOrderSuccess";
		}
	
	
	public String getWaitConfirmOrder(){
		waitConfirmOrderList=orderService.getWaitPayOrder(userId);
		for(int i=0;i<waitConfirmOrderList.size();i++){
			int orderId=waitConfirmOrderList.get(i).getId();
			waitConfirmOrderDetailList=getOrderDetail(waitConfirmOrderList);
		}
		return "getWaitConfirmOrderSuccess";
		}
	
	public String getrefundOrder(){
		refundOrderList=orderService.getrefundOrder(userId);
		for(int i=0;i<refundOrderList.size();i++){
			int orderId=refundOrderList.get(i).getId();
			refundOrderDetailList=getOrderDetail(refundOrderList);
		}
		return "getrefundOrderSuccess";
		}
	
	public void getPictureList(){
			
			
		}
	
	
	public List<OrderDetailVo> getOrderDetail(List<OrderVo> orderList){
		List<OrderDetailVo> orderDetailList=new ArrayList<OrderDetailVo>();
		for(int i=0;i<orderList.size();i++){
		OrderVo thisOrder=orderList.get(i);
		List<OrderDetailVo> thisorderDetailList=orderService.viewOrderDetail(userId, thisOrder);
		orderDetailList.addAll(thisorderDetailList);
		}
		return orderDetailList;
	}
	
	
	}
