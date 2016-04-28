package njuse.ec.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.OrderService;
import njuse.ec.service.UserService;
import njuse.ec.vo.OrderElement;
import njuse.ec.vo.UserVo;

/**
 * 订单页面.
 * @author 丞
 *
 */
@Repository
public class OrderAction extends BaseAction {

	/**
	 * 序列化id.
	 */
	private static final long serialVersionUID = 5891565058143752226L;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	private int orderId;
	
	private OrderElement element;
	
	private UserVo userVo;

	public String execute() {
		element = orderService.oneOrder(orderId);
		if (getSession().containsKey("userId")) {
			userVo = userService.userInfo((int) getSession().get("userId"));
		}
		return SUCCESS;
	}
	
	public String pay() {
		
		return SUCCESS;
	}

	/**
	 * @return the element
	 */
	public final OrderElement getElement() {
		return element;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public final void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the userVo
	 */
	public final UserVo getUserVo() {
		return userVo;
	}

}
