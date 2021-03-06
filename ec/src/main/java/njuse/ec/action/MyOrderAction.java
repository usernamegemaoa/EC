package njuse.ec.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.model.Order;
import njuse.ec.service.GoodService;
import njuse.ec.service.OrderService;
import njuse.ec.service.UserService;
import njuse.ec.vo.ColorElement;
import njuse.ec.vo.DetailElement;
import njuse.ec.vo.FavouriteVo;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.OrderDetailVo;
import njuse.ec.vo.OrderElement;
import njuse.ec.vo.OrderVo;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.UserVo;

@Repository
public class MyOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2780549981670802793L;

	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private GoodService goodService;
	private List<OrderElement> allOrderList;
	private List<OrderElement> waitPayOrderList;
	private List<OrderElement> waitSendOrderList;
	private List<OrderElement> waitConfirmOrderList;
	private List<OrderElement> refundOrderList;
	private List<GoodVo> favouriteGoodList;
	private int userId;
	private String name;
	private int goodId;
	private String size;
	private int quantity;
	private double price;
	private String status;
	private int id;
	private String expressNumber;

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}

	private int orderId;
	private int role;// 1 用户 2店家
	private ArrayList<String> pictureList;
	private Map<String, Object> jsonResult;

	public String execute() {
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		UserVo vo = userService.userInfo(userId);
		if (vo.getRole() == 1) {
			role = 1;
			getAllOrder();
			getWaitPayOrder();
			getWaitSendOrder();
			getWaitConfirmOrder();
			getrefundOrder();
			return SUCCESS;
		} else {
			role = 2;
			getShopOrder();
			getShopWaitSendOrder();
			getShopRefundOrder();
			return "shop";
		}
	}

	public String getAllOrder() {
		System.out.println("-------------------");
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		allOrderList = orderService.viewOrder(userId);
		return SUCCESS;
	}

	private String getShopOrder() {
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		allOrderList = orderService.getShopOrder(userId);
		return SUCCESS;
	}

	private String sendOrder() {
		OrderVo vo = new OrderVo();
		vo.setId(orderId);
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		ResultVo result = orderService.shipOrder(userId, vo, expressNumber);
		jsonResult.put("resultMessage", result.getResultMessage());
		return SUCCESS;
	}

	private String refundMoney() {
		OrderVo vo = new OrderVo();
		vo.setId(orderId);
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		ResultVo result = orderService.refundMoney(userId, vo);
		jsonResult.put("resultMessage", result.getResultMessage());
		return SUCCESS;
	}

	private String getShopWaitSendOrder() {
		waitSendOrderList = orderService.getShopWaitSendOrder(userId);
		return SUCCESS;
	}

	private String getShopRefundOrder() {
		refundOrderList = orderService.getShopRefundOrder(userId);
		return SUCCESS;
	}

	public String confirmOrder() {
		OrderVo vo = new OrderVo();
		vo.setId(orderId);
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		ResultVo result = orderService.receiptOrder(userId, vo);
		jsonResult.put("resultMessage", result.getResultMessage());
		return SUCCESS;
	}

	public String cancelOrder() {
		OrderVo vo = new OrderVo();
		vo.setId(orderId);
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		ResultVo result = orderService.cancelOrder(userId, vo);
		jsonResult.put("resultMessage", result.getResultMessage());
		return SUCCESS;
	}

	public String cancelRefund() {
		OrderVo vo = new OrderVo();
		vo.setId(orderId);
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		ResultVo result = orderService.cancelRefund(userId, vo);
		jsonResult.put("resultMessage", result.getResultMessage());
		return SUCCESS;
	}

	public String refundOrder() {
		OrderVo vo = new OrderVo();
		vo.setId(orderId);
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		ResultVo result = orderService.refundOrder(userId, vo);
		jsonResult.put("resultMessage", result.getResultMessage());
		return SUCCESS;
	}

	public String getFavourite() {
		favouriteGoodList = new ArrayList<GoodVo>();
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		List<FavouriteVo> favourite = userService.favourites(userId);
		Iterator<FavouriteVo> i = favourite.iterator();
		while (i.hasNext()) {
			FavouriteVo vo = i.next();
			GoodVo good = new GoodVo();
			goodId = vo.getGoodId();
			good = goodService.getDetailGood(goodId);
			favouriteGoodList.add(good);

		}
		System.out.println("favouriteGoodList=============" + favouriteGoodList.size());
		return SUCCESS;
	}

	public String unfavour() {
		if (getSession().containsKey("userId")) {
			userId = (int) getSession().get("userId");
		}
		ResultVo result = userService.unFavour(userId, goodId);
		jsonResult.put("resultMessage", result.getResultMessage());
		return SUCCESS;
	}

	public String getWaitPayOrder() {
		waitPayOrderList = orderService.getWaitPayOrder(userId);
		return SUCCESS;
	}

	public String getWaitSendOrder() {
		waitSendOrderList = orderService.getWaitSendOrder(userId);
		return SUCCESS;
	}

	public String getWaitConfirmOrder() {
		waitConfirmOrderList = orderService.getWaitConfirm(userId);
		return SUCCESS;
	}

	public String getrefundOrder() {
		refundOrderList = orderService.getrefundOrder(userId);
		return SUCCESS;
	}

	public ArrayList<String> getPictureList() {
		return pictureList;
	}

	public void setPictureList(ArrayList<String> pictureList) {
		this.pictureList = pictureList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderElement> getAllOrderList() {
		return allOrderList;
	}

	public void setAllOrderList(List<OrderElement> allOrderList) {
		this.allOrderList = allOrderList;
	}

	public List<OrderElement> getWaitPayOrderList() {
		return waitPayOrderList;
	}

	public void setWaitPayOrderList(List<OrderElement> waitPayOrderList) {
		this.waitPayOrderList = waitPayOrderList;
	}

	public List<OrderElement> getWaitSendOrderList() {
		return waitSendOrderList;
	}

	public void setWaitSendOrderList(List<OrderElement> waitSendOrderList) {
		this.waitSendOrderList = waitSendOrderList;
	}

	public List<OrderElement> getWaitConfirmOrderList() {
		return waitConfirmOrderList;
	}

	public void setWaitConfirmOrderList(List<OrderElement> waitConfirmOrderList) {
		this.waitConfirmOrderList = waitConfirmOrderList;
	}

	public List<OrderElement> getRefundOrderList() {
		return refundOrderList;
	}

	public void setRefundOrderList(List<OrderElement> refundOrderList) {
		this.refundOrderList = refundOrderList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Map<String, Object> getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<GoodVo> getFavouriteGoodList() {
		return favouriteGoodList;
	}

	public void setFavouriteGoodList(List<GoodVo> favouriteGoodList) {
		this.favouriteGoodList = favouriteGoodList;
	}

}
