package njuse.ec.vo;

/**
 * 收藏商品Vo.
 * @author 丞
 *
 */
public class FavouriteVo {

	/**
	 * 关注id.
	 */
	private int id;
	/**
	 * 用户id.
	 */
	private int userId;
	/**
	 * 商品id.
	 */
	private int goodId;
	
	/**
	 * 获取id.
	 * @return 关注id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * 设置关注id.
	 * @param newId 关注id
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}
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
	 * 设置商品id.
	 * @return 商品id
	 */
	public final int getGoodId() {
		return goodId;
	}
	/**
	 * 获取商品id.
	 * @param newGoodId 商品id
	 */
	public final void setGoodId(final int newGoodId) {
		this.goodId = newGoodId;
	}
	
}
