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
	 * 数量总计.
	 */
	private int totalNum;
	
	/**
	 * 邮编.
	 */
	private int placeCode;
	/**
	 * 地址.
	 */
	private String placeName;
	/**
	 * 收件人.
	 */
	private String peopleName;
	/**
	 * 电话.
	 */
	private String phone;

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

	/**
	 * @return the totalNum
	 */
	public final int getTotalNum() {
		return totalNum;
	}

	/**
	 * @param totalNum the totalNum to set
	 */
	public final void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	/**
	 * @return the placeCode
	 */
	public final int getPlaceCode() {
		return placeCode;
	}

	/**
	 * @param placeCode the placeCode to set
	 */
	public final void setPlaceCode(int placeCode) {
		this.placeCode = placeCode;
	}

	/**
	 * @return the placeName
	 */
	public final String getPlaceName() {
		return placeName;
	}

	/**
	 * @param placeName the placeName to set
	 */
	public final void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	/**
	 * @return the peopleName
	 */
	public final String getPeopleName() {
		return peopleName;
	}

	/**
	 * @param peopleName the peopleName to set
	 */
	public final void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	/**
	 * @return the phone
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public final void setPhone(String phone) {
		this.phone = phone;
	}
}
