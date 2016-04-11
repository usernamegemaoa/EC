package njuse.ec.vo;

/**
 * 广告Vo.
 * @author 丞
 *
 */
public class AdVo {

	/**
	 * 广告id.
	 */
	private int id;
	
	/**
	 * 广告图片路径.
	 */
	private String picturePath;
	
	/**
	 * 用户id.
	 */
	private int userId;
	
	/**
	 * 商品id.
	 */
	private int goodId;
	
	/**
	 * 广告类型.
	 */
	private AdMode mode;
	
	/**
	 * 获取id.
	 * @return 广告id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * 设置id.
	 * @param newId 广告id
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}
	/**
	 * 获取图片路径.
	 * @return 图片路径 
	 */
	public final String getPicturePath() {
		return picturePath;
	}
	/**
	 * 设置图片路径.
	 * @param newPicturePath 图片路径
	 */
	public final void setPicturePath(final String newPicturePath) {
		this.picturePath = newPicturePath;
	}
	/**
	 * @return the userId
	 */
	public final int getUserId() {
		return userId;
	}
	/**
	 * @param newUserId the userId to set
	 */
	public final void setUserId(final int newUserId) {
		this.userId = newUserId;
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
	 * @return the mode
	 */
	public final AdMode getMode() {
		return mode;
	}
	/**
	 * @param newMode the mode to set
	 */
	public final void setMode(final AdMode newMode) {
		this.mode = newMode;
	}

}
