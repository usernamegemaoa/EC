package njuse.ec.action;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.OrderService;
import njuse.ec.service.UserService;
import njuse.ec.vo.AddressVo;
import njuse.ec.vo.OrderElement;
import njuse.ec.vo.OrderVo;
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
	private int addressId;
	
	private OrderElement element;
	
	private UserVo userVo;

	public String execute() {
		super.execute();
		element = orderService.oneOrder(orderId);
		if (getSession().containsKey("userId")) {
			userVo = userService.userInfo((int) getSession().get("userId"));
		}
		return SUCCESS;
	}
	
	public String pay() {
		OrderVo vo = orderService.getOrder(orderId);
		userVo = userService.userInfo((int) getSession().get("userId"));
		Iterator<AddressVo> i = userVo.getAddressVoList().iterator();
		while (i.hasNext()) {
			AddressVo address = i.next();
			if (address.getId() == addressId) {
				vo.setPeopleName(address.getPeople());
				vo.setPhone(address.getPhone());
				vo.setPlaceCode(address.getPlaceCode());
				vo.setPlaceName(address.getPlaceName());
				break;
			}
		}
		orderService.payOrder(userVo.getId(), vo);
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

	/**
	 * @param addressId the addressId to set
	 */
	public final void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}
