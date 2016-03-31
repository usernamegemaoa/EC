package njuse.ec.vo;

/**
 * 简单商品vo.
 * @author 阳
 *
 */
public class SimpleGoodVo {

	/**
	 * 商品id.
	 */
	private int goodId;
	
	/**
	 * 商品图片路径.
	 */
	private String img;
	
	/**
	 * 商品名.
	 */
	private String name;
	
	/**
	 * 商品价格.
	 */
	private double price;
	
	/**
	 * 店主id.
	 */
	private int sellerId;

	/**
	 * 获取商品id.
	 * @return 商品id
	 */
	public final int getGoodId() {
		return goodId;
	}

	/**
	 * 设置商品id.
	 * @param newGoodId 商品id
	 */
	public final void setGoodId(final int newGoodId) {
		this.goodId = newGoodId;
	}

	/**
	 * 获取商品图片.
	 * @return 商品图片路径
	 */
	public final String getImg() {
		return img;
	}

	/**
	 * 设置商品图片.
	 * @param newImg 商品图片路径
	 */
	public final void setImg(final String newImg) {
		this.img = newImg;
	}

	/**
	 * 获取商品名称.
	 * @return 商品名称
	 */
	public final String getName() {
		return name;
	}

	/**
	 * 设置商品名称.
	 * @param newName 商品名称
	 */
	public final void setName(final String newName) {
		this.name = newName;
	}

	/**
	 * 获取商品价格.
	 * @return 商品价格
	 */
	public final double getPrice() {
		return price;
	}

	/**
	 * 设置商品价格.
	 * @param newPrice 商品价格
	 */
	public final void setPrice(final double newPrice) {
		this.price = newPrice;
	}

	/**
	 * 设置店家id.
	 * @return 店家id
	 */
	public final int getSellerId() {
		return sellerId;
	}

	/**
	 * 获取店家id.
	 * @param newSellerId 店家id
	 */
	public final void setSellerId(final int newSellerId) {
		this.sellerId = newSellerId;
	}
}
