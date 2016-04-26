package njuse.ec.vo;

/**
 * 地址vo.
 * @author 丞
 *
 */
public class PlaceVo {

	/**
	 * id.
	 */
	private int id;
	/**
	 * 地址代码.
	 * 地址代码共6位
	 * 12位代表省
	 * 34位代表市
	 * 56位代表区
	 */
	private int placeCode;
	/**
	 * 地点名称.
	 */
	private String placeName;
	
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
	 * @return the placeCode
	 */
	public final int getPlaceCode() {
		return placeCode;
	}
	/**
	 * @param newPlaceCode the placeCode to set
	 */
	public final void setPlaceCode(final int newPlaceCode) {
		this.placeCode = newPlaceCode;
	}
	/**
	 * @return the placeName
	 */
	public final String getPlaceName() {
		return placeName;
	}
	/**
	 * @param newPlaceName the placeName to set
	 */
	public final void setPlaceName(final String newPlaceName) {
		this.placeName = newPlaceName;
	}
}
