package njuse.ec.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import njuse.ec.service.UserService;
import njuse.ec.vo.AddressVo;
import njuse.ec.vo.UserVo;

@Repository
public class AddressAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7386156973597624589L;

	@Autowired
	private UserService userService;
	private List<AddressVo> addressList;
	private UserVo userVo;
	
	public String execute(){
		return SUCCESS;
	}
	
	public String getAddress(){
		int userId=0;
		if (getSession().containsKey("userId")) {
		userId = (int) getSession().get("userId");}
		userVo=userService.userInfo(userId);
		setAddressList(userVo.getAddressVoList());
		return SUCCESS;
	}

	public List<AddressVo> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressVo> addressList) {
		this.addressList = addressList;
	}
}
