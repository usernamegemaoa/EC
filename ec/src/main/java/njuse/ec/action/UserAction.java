package njuse.ec.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.UserService;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.UserVo;

@Repository
public class UserAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7653357590671816069L;

	@Autowired
	private UserService userService;
	private String oldPassword;
	private String newPassword1;
	private String newPassword2;
	private ResultVo resultVo;
	private String result;
	private Map<String,Object> jsonResult;
	
	public String execute(){
		
		return SUCCESS;
	}
	public final String changePassword(){
		jsonResult=new HashMap<String,Object>();
		UserVo vo=new UserVo();
		if (getSession().containsKey("userId")) {
		int userId = (int) getSession().get("userId");
		vo = userService.userInfo(userId);}
		resultVo=userService.modifyPassword(vo, oldPassword, newPassword1, newPassword2);
		jsonResult.put("resultMessage", resultVo.getResultMessage());
		System.out.println(resultVo.getResultMessage());
		return SUCCESS;
	}
	

	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword1() {
		return newPassword1;
	}
	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}
	public String getNewPassword2() {
		return newPassword2;
	}
	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
