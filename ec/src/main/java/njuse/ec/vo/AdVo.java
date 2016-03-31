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
	 * 商品网址.
	 */
	private String goodPath;
	
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
	 * 获取商品网址.
	 * @return 设置商品网址
	 */
	public final String getGoodPath() {
		return goodPath;
	}
	/**
	 * 设置商品网址.
	 * @param newGoodPath 商品网址
	 */
	public final void setGoodPath(final String newGoodPath) {
		this.goodPath = newGoodPath;
	}

}
