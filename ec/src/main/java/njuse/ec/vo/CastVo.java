package njuse.ec.vo;

/**
 * 进货单vo.
 * @author 阳
 *
 */
public class CastVo {

	/**
	 * 用户id.
	 */
	private int userId;
	
	/**
	 * 购物单id.
	 */
	private int castId;
	
	/**
	 * 商品id.
	 */
	private int goodId;
	
	/**
	 * 库存id.
	 */
	private int stockId;

	/**
	 * 商品颜色.
	 */
	private String color;
	
	/**
	 * 商品型号.
	 */
	private String size;
	
	/**
	 * 商品数量.
	 */
	private int num;
	

	/**
	 * 获取用户id.
	 * @return 用户id
	 */
	public final int getUserId() {
		return userId;
	}

	/**
	 * 设置用户id.
	 * @param newUserId 用户id
	 */
	public final void setUserId(final int newUserId) {
		this.userId = newUserId;
	}

	/**
	 * 获取购物单id.
	 * @return 购物单id
	 */
	public final int getCastId() {
		return castId;
	}

	/**
	 * 设置购物单id.
	 * @param newCastId 购物单id
	 */
	public final void setCastId(final int newCastId) {
		this.castId = newCastId;
	}

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
	 * 获取库存id.
	 * @return 库存id
	 */
	public final int getStockId() {
		return stockId;
	}

	/**
	 * 设置库存id.
	 * @param newStockId 库存id
	 */
	public final void setStockId(final int newStockId) {
		this.stockId = newStockId;
	}

	/**
	 * 获取商品颜色.
	 * @return 商品颜色
	 */
	public final String getColor() {
		return color;
	}

	/**
	 * 设置商品颜色.
	 * @param newColor 商品颜色
	 */
	public final void setColor(final String newColor) {
		this.color = newColor;
	}

	/**
	 * 获取商品型号.
	 * @return 商品型号
	 */
	public final String getSize() {
		return size;
	}

	/**
	 * 设置商品型号.
	 * @param newSize 商品型号
	 */
	public final void setSize(final String newSize) {
		this.size = newSize;
	}

	/**
	 * 获取商品数量.
	 * @return 商品数量
	 */
	public final int getNum() {
		return num;
	}

	/**
	 * 设置商品数量.
	 * @param newNum 商品数量
	 */
	public final void setNum(final int newNum) {
		this.num = newNum;
	}
}
