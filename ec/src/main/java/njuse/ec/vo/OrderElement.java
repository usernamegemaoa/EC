package njuse.ec.vo;

import java.util.List;

/**
 * 订单节点.
 * @author 丞
 *
 */
public class OrderElement {

	/**
	 * 订单号.
	 */
	private int orderId;
	
	/**
	 * 订单状态.
	 */
	private String status;
	
	/**
	 * 商品列表.
	 */
	private List<GoodElement> goodList;
	
	/**
	 * 总价.
	 */
	private double totalPrice;

	/**
	 * @return the orderId
	 */
	public final int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public final void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the status
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the goodList
	 */
	public final List<GoodElement> getGoodList() {
		return goodList;
	}

	/**
	 * @param goodList the goodList to set
	 */
	public final void setGoodList(List<GoodElement> goodList) {
		this.goodList = goodList;
	}

	/**
	 * @return the totalPrice
	 */
	public final double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public final void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
