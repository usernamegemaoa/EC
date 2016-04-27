package njuse.ec.vo;

import java.util.Date;
import java.util.List;

import njuse.ec.model.Order;

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
	private List<OrderDetailVo> casts;
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
	private int read;
	/**
	 * 时间.
	 */
	private Date time;
	/**
	 * 订单编号
	 */
	private String express_number;
	
	/**
	 * 状态编号
	 */
	private String state;
	
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
	public final List<OrderDetailVo> getCasts() {
		return casts;
	}
	/**
	 * @param newCasts the casts to set
	 */
	public final void setCasts(final List<OrderDetailVo> newCasts) {
		this.casts = newCasts;
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
	public final int isRead() {
		return read;
	}
	/**
	 * @param newRead the read to set
	 */
	public final void setRead(final int newRead) {
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
	/**
	 * @return the express_number
	 */
	public final String getExpress_number(){
		return express_number;
	}
	/**
	 * @param newExpress_number the express_number to set
	 */
	public final void setExpress_number(final String newExpress_number){
		this.express_number=newExpress_number;
	}
	
	public Order convertOrderVo(OrderVo order){
		Order newOrder=new Order();
		newOrder.setId(order.getId());
		newOrder.setUser_id(order.getUserId());
		newOrder.setIs_read(order.isRead());
		newOrder.setExpress_number(order.getExpress_number());
		newOrder.setPeople(order.getPeopleName());
		newOrder.setShop_id(order.getShopId());
		newOrder.setPhone(order.getPhone());
		newOrder.setPlace_code(order.getPlaceCode());
		newOrder.setPlace_name(order.getPlaceName());
		newOrder.setTime(order.getTime());
		switch(order.getStatus()){//1:未支付，2:代发货,3:待确认,4:待评价,5:申请退款中,6：已退款
		case Finish:
			newOrder.setState(6);
			break;
		case Refund:
			newOrder.setState(5);
			break;
		case WaitRate:
			newOrder.setState(4);
			break;
		case WaitConfirm:
			newOrder.setState(3);
			break;
		case WaitSend:
			newOrder.setState(2);
			break;
		case WaitPay:
			newOrder.setState(1);
			break;
	}
		System.out.println(newOrder.getId());
		return newOrder;
	}
	
	public OrderVo convertOrder(Order order){
		OrderVo newOrder=new OrderVo();
		newOrder.setId(order.getId());
		newOrder.setUserId(order.getUser_id());
		newOrder.setRead(order.isIs_read());
		newOrder.setExpress_number(order.getExpress_number());
		newOrder.setPeopleName(order.getPeople());
		newOrder.setShopId(order.getShop_id());
		newOrder.setPhone(order.getPhone());
		newOrder.setPlaceCode(order.getPlace_code());
		newOrder.setPlaceName(order.getPlace_name());
		newOrder.setTime(order.getTime());
		switch(order.getState()){
		case 1:
			newOrder.setStatus(OrderStatus.WaitPay);
			newOrder.setState("待支付");
			break;
		case 2:
			newOrder.setStatus(OrderStatus.WaitSend);
			newOrder.setState("待发货");
			break;
		case 3:
			newOrder.setStatus(OrderStatus.WaitConfirm);
			newOrder.setState("待确认");
			break;
		case 4:
			newOrder.setStatus(OrderStatus.WaitRate);
			newOrder.setState("待评价");
			break;
		case 5:
			newOrder.setStatus(OrderStatus.Refund);
			newOrder.setState("退款中");
			break;
		case 6:
			newOrder.setStatus(OrderStatus.Finish);
			newOrder.setState("已完成");
			break;
			
		}
		return newOrder;
	}
	public final String getState() {
		return state;
	}
	public void setState( final String state) {
		this.state = state;
	}
}
