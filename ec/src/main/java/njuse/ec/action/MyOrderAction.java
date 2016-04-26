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
	
	
	public String execute(){
		getAllOrder();
		getWaitPayOrder();
		getWaitSendOrder();
		getWaitConfirmOrder();
		getrefundOrder();
		return SUCCESS;
	}

	
	public String getAllOrder(){
		System.out.println("-------------------");
		userId=282;
		//userId=(int) session.get(userId);
		allOrderList=orderService.viewOrder(userId);
		for(int i=0;i<allOrderList.size();i++){
			int orderId=allOrderList.get(i).getId();
			setAllOrderDetailList(getOrderDetail(allOrderList));
		}
		return SUCCESS;
		}
	
	public String getWaitPayOrder(){
		waitPayOrderList=orderService.getWaitPayOrder(userId);
		for(int i=0;i<waitPayOrderList.size();i++){
			int orderId=waitPayOrderList.get(i).getId();
			setWaitPayOrderDetailList(getOrderDetail(waitPayOrderList));
		}
		return SUCCESS;
		}
	
	public String getWaitSendOrder(){
		waitSendOrderList=orderService.getWaitPayOrder(userId);
		for(int i=0;i<waitSendOrderList.size();i++){
			int orderId=waitSendOrderList.get(i).getId();
			setWaitSendOrderDetailList(getOrderDetail(waitSendOrderList));
		}
		return SUCCESS;
		}
	
	
	public String getWaitConfirmOrder(){
		waitConfirmOrderList=orderService.getWaitPayOrder(userId);
		for(int i=0;i<waitConfirmOrderList.size();i++){
			int orderId=waitConfirmOrderList.get(i).getId();
			setWaitConfirmOrderDetailList(getOrderDetail(waitConfirmOrderList));
		}
		return SUCCESS;
		}
	
	public String getrefundOrder(){
		refundOrderList=orderService.getrefundOrder(userId);
		for(int i=0;i<refundOrderList.size();i++){
			int orderId=refundOrderList.get(i).getId();
			setRefundOrderDetailList(getOrderDetail(refundOrderList));
		}
		return SUCCESS;
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


	public List<OrderDetailVo> getAllOrderDetailList() {
		return allOrderDetailList;
	}


	public void setAllOrderDetailList(List<OrderDetailVo> allOrderDetailList) {
		this.allOrderDetailList = allOrderDetailList;
	}


	public List<OrderDetailVo> getWaitSendOrderDetailList() {
		return waitSendOrderDetailList;
	}


	public void setWaitSendOrderDetailList(List<OrderDetailVo> waitSendOrderDetailList) {
		this.waitSendOrderDetailList = waitSendOrderDetailList;
	}


	public List<OrderDetailVo> getWaitConfirmOrderDetailList() {
		return waitConfirmOrderDetailList;
	}


	public void setWaitConfirmOrderDetailList(List<OrderDetailVo> waitConfirmOrderDetailList) {
		this.waitConfirmOrderDetailList = waitConfirmOrderDetailList;
	}


	public List<OrderDetailVo> getWaitPayOrderDetailList() {
		return waitPayOrderDetailList;
	}


	public void setWaitPayOrderDetailList(List<OrderDetailVo> waitPayOrderDetailList) {
		this.waitPayOrderDetailList = waitPayOrderDetailList;
	}


	public List<OrderDetailVo> getRefundOrderDetailList() {
		return refundOrderDetailList;
	}


	public void setRefundOrderDetailList(List<OrderDetailVo> refundOrderDetailList) {
		this.refundOrderDetailList = refundOrderDetailList;
	}


	public ArrayList<String> getPictureList() {
		return pictureList;
	}


	public void setPictureList(ArrayList<String> pictureList) {
		this.pictureList = pictureList;
	}
	
	
	}
