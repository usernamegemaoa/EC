package njuse.ec.vo;

/**
 * 订单状态枚举.
 * @author 丞
 *
 */
public enum OrderStatus {
	/**
	 * 待支付.
	 */
	WaitPay(0),
	/**
	 * 待发货.
	 */
	WaitSend(1),
	/**
	 * 待收货.
	 */
	WaitConfirm(2),
	/**
	 * 待评价.
	 */
	WaitRate(3),
	/**
	 * 退款中. 
	 */
	Refund(4),
	/**
	 * 已完成.
	 */
	Finish(5);
	
	/**
	 * 状态码.
	 */
	private int orderCode;
	
	/**
	 * 私有构造函数.
	 * @param i 状态码
	 */
	OrderStatus(final int i) {
		this.orderCode = i;
	}
	
	/**
	 * 获取状态码.
	 * @return 状态码
	 */
	public int getCode() {
		return orderCode;
	}
	
	/**
	 * 设置状态码.
	 * @param i 状态码.
	 */
	public void setCode(final int i) {
		this.orderCode = i;
	}
}
