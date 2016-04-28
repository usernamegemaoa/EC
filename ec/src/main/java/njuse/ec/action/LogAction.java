package njuse.ec.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import njuse.ec.service.UserService;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.UserVo;

public class LogAction extends BaseAction {

	/**
	 * 序列号id.
	 */
	private static final long serialVersionUID = 942862290490137483L;

	@Autowired
	private UserService userService;
	
	// get
	private Map<String, Object> jsonResult;
	
	//set
	private String account;
	private String password;
	private String pw1;
	private String pw2;
	private String name;
	private String email;
	private String birth;
	private int male;
	private int role;
	
	public String regiest() {
		return SUCCESS;
	}
	
	public String login() {
		return SUCCESS;
	}
	
	public String regiestUser() {
		jsonResult = new HashMap<String, Object>();
		
		UserVo vo = new UserVo();
		vo.setAccount(account);
		vo.setEmail(email);
		vo.setIconPath("img/a.jpg");
		vo.setMale(male);
		vo.setRole(role);
		vo.setScore(0);
		vo.setName(name);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday;
		try {
			birthday = df.parse(birth);
		} catch (ParseException e) {
			birthday = new Date();
			e.printStackTrace();
		}
		vo.setBirthday(birthday);
		ResultVo result = userService.register(vo, pw1, pw2);
		jsonResult.put("code", result.getResultCode());
		jsonResult.put("message", result.getResultMessage());
		
		return SUCCESS;
	}
	
	public String loginUser() {
		ResultVo result = userService.login(account, password);
		if (result.getResultCode() == 0) {
			int userId = Integer.parseInt(result.getResultMessage());
			getSession().put("userId", userId);
		}
		jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", result.getResultCode());
		jsonResult.put("message", result.getResultMessage());
		
		return SUCCESS;
	}
	
	public String logout() {
		getSession().clear();
		return SUCCESS;
	}

	/**
	 * @return the jsonResult
	 */
	public final Map<String, Object> getJsonResult() {
		return jsonResult;
	}

	/**
	 * @param account the account to set
	 */
	public final void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @param pw1 the pw1 to set
	 */
	public final void setPw1(String pw1) {
		this.pw1 = pw1;
	}

	/**
	 * @param pw2 the pw2 to set
	 */
	public final void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param birth the birth to set
	 */
	public final void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * @param male the male to set
	 */
	public final void setMale(int male) {
		this.male = male;
	}

	/**
	 * @param role the role to set
	 */
	public final void setRole(int role) {
		this.role = role;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

}
