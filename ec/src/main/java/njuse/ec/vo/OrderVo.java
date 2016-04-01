package njuse.ec.vo;

import java.util.Date;
import java.util.List;

/**
 * 订单vo.
 * @author 丞
 *
 */
public class OrderVo {

	/**
	 * 订单id.
	 */
	private int id;
	/**
	 * 用户id.
	 */
	private int userId;
	/**
	 * 商店id.
	 */
	private int shopId;
	/**
	 * 商品列表.
	 */
	private List<OrderDetilVo> casts;
	/**
	 * 邮编.
	 */
	private String placeCode;
	/**
	 * 地址.
	 */
	private String placeName;
	/**
	 * 收件人.
	 */
	private String peopleName;
	/**
	 * 电话.
	 */
	private String phone;
	/**
	 * 订单状态.
	 */
	private OrderStatus status;
	/**
	 * 已读标签.
	 */
	private boolean read;
	/**
	 * 时间.
	 */
	private Date time;
	
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
	 * @return the shopId
	 */
	public final int getShopId() {
		return shopId;
	}
	/**
	 * @param newShopId the shopId to set
	 */
	public final void setShopId(final int newShopId) {
		this.shopId = newShopId;
	}
	/**
	 * @return the casts
	 */
	public final List<OrderDetilVo> getCasts() {
		return casts;
	}
	/**
	 * @param newCasts the casts to set
	 */
	public final void setCasts(final List<OrderDetilVo> newCasts) {
		this.casts = newCasts;
	}
	/**
	 * @return the placeCode
	 */
	public final String getPlaceCode() {
		return placeCode;
	}
	/**
	 * @param newPlaceCode the placeCode to set
	 */
	public final void setPlaceCode(final String newPlaceCode) {
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
	/**
	 * @return the peopleName
	 */
	public final String getPeopleName() {
		return peopleName;
	}
	/**
	 * @param newPeopleName the peopleName to set
	 */
	public final void setPeopleName(final String newPeopleName) {
		this.peopleName = newPeopleName;
	}
	/**
	 * @return the phone
	 */
	public final String getPhone() {
		return phone;
	}
	/**
	 * @param newPhone the phone to set
	 */
	public final void setPhone(final String newPhone) {
		this.phone = newPhone;
	}
	/**
	 * @return the status
	 */
	public final OrderStatus getStatus() {
		return status;
	}
	/**
	 * @param newStatus the status to set
	 */
	public final void setStatus(final OrderStatus newStatus) {
		this.status = newStatus;
	}
	/**
	 * @return the read
	 */
	public final boolean isRead() {
		return read;
	}
	/**
	 * @param newRead the read to set
	 */
	public final void setRead(final boolean newRead) {
		this.read = newRead;
	}
	/**
	 * @return the time
	 */
	public final Date getTime() {
		return time;
	}
	/**
	 * @param newTime the time to set
	 */
	public final void setTime(final Date newTime) {
		this.time = newTime;
	}
	
}
