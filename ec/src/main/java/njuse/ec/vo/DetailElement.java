package njuse.ec.vo;

/**
 * 详情节点.
 * @author 丞
 *
 */
public class DetailElement {
	
	/**
	 * 尺码.
	 */
	private String size;
	
	/**
	 * 选购数量.
	 */
	private int num;
	
	/**
	 * 单价.
	 */
	private double unitPrice;
	
	/**
	 * 总价.
	 */
	private double totalPrice;
	
	private int stockNum;

	/**
	 * @return the size
	 */
	public final String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public final void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the num
	 */
	public final int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public final void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the unitPrice
	 */
	public final double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public final void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
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

	public final int getStockNum() {
		return stockNum;
	}

	public final void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
}
