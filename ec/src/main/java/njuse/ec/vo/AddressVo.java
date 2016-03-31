package njuse.ec.vo;

/**
 * 地址信息Vo.
 * @author 丞
 *
 */
public class AddressVo {

	/**
	 * 广告id.
	 */
	private int id;
	/**
	 * 邮编.
	 */
	private int placeCode;
	/**
	 * 地址.
	 */
	private String placeName;
	/**
	 * 收件人.
	 */
	private String people;
	/**
	 * 电话.
	 */
	private String phone;
	
	/**
	 * 获取id.
	 * @return id
	 */
	public final int getId() {
		return id;
	}
	
	/**
	 * 设置id.
	 * @param newId 地址id
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}
	/**
	 * 获取邮编.
	 * @return 邮编
	 */
	public final int getPlaceCode() {
		return placeCode;
	}
	
	/**
	 * 设置邮编.
	 * @param newPlaceCode 邮编
	 */
	public final void setPlaceCode(final int newPlaceCode) {
		this.placeCode = newPlaceCode;
	}
	/**
	 * 获取地址.
	 * @return 地址
	 */
	public final String getPlaceName() {
		return placeName;
	}
	/**
	 * 设置地址.
	 * @param newPlaceName 地址
	 */
	public final void setPlaceName(final String newPlaceName) {
		this.placeName = newPlaceName;
	}
	/**
	 * 获取收件人.
	 * @return 收件人
	 */
	public final String getPeople() {
		return people;
	}
	/**
	 * 设置收件人.
	 * @param newPeople 收件人
	 */
	public final void setPeople(final String newPeople) {
		this.people = newPeople;
	}
	/**
	 * 获取电话.
	 * @return 电话
	 */
	public final String getPhone() {
		return phone;
	}
	/**
	 * 设置电话.
	 * @param newPhone 电话
	 */
	public final void setPhone(final String newPhone) {
		this.phone = newPhone;
	}
	
}
