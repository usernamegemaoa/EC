package njuse.ec.vo;

/**
 * 订单详情.
 * @author 丞
 *
 */
public class OrderDetilVo {

	/**
	 * 细节id.
	 */
	private int id;
	/**
	 * 商品id.
	 */
	private int goodId;
	/**
	 * 尺寸.
	 */
	private String size;
	/**
	 * 颜色.
	 */
	private String color;
	/**
	 * 数量.
	 */
	private int quantity;
	/**
	 * 单价.
	 */
	private int price;
	
	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * @param newId the id to set
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}
	/**
	 * @return the goodId
	 */
	public final int getGoodId() {
		return goodId;
	}
	/**
	 * @param newGoodId the goodId to set
	 */
	public final void setGoodId(final int newGoodId) {
		this.goodId = newGoodId;
	}
	/**
	 * @return the size
	 */
	public final String getSize() {
		return size;
	}
	/**
	 * @param newSize the size to set
	 */
	public final void setSize(final String newSize) {
		this.size = newSize;
	}
	/**
	 * @return the color
	 */
	public final String getColor() {
		return color;
	}
	/**
	 * @param newColor the color to set
	 */
	public final void setColor(final String newColor) {
		this.color = newColor;
	}
	/**
	 * @return the quantity
	 */
	public final int getQuantity() {
		return quantity;
	}
	/**
	 * @param newQuantity the quantity to set
	 */
	public final void setQuantity(final int newQuantity) {
		this.quantity = newQuantity;
	}
	/**
	 * @return the price
	 */
	public final int getPrice() {
		return price;
	}
	/**
	 * @param newPrice the price to set
	 */
	public final void setPrice(final int newPrice) {
		this.price = newPrice;
	}
}
