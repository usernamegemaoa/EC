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
	 * 图片.
	 */
	private String img;
	
	/**
	 * 商品名.
	 */
	private String name;
	
	/**
	 * 颜色节点.
	 */
	private List<ColorElement> colorList;
	
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
	 * @return the img
	 */
	public final String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public final void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the colorList
	 */
	public final List<ColorElement> getColorList() {
		return colorList;
	}

	/**
	 * @param colorList the colorList to set
	 */
	public final void setColorList(List<ColorElement> colorList) {
		this.colorList = colorList;
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
