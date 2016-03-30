package njuse.ec.vo;

/**
 * 收藏商品Vo.
 * @author 丞
 *
 */
public class FavouriteVo {

	int id;
	int userId;
	int goodId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	
}
