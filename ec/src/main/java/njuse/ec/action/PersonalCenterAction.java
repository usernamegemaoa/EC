package njuse.ec.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.model.User;
import njuse.ec.service.UserService;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.UserVo;

@Repository
public class PersonalCenterAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4771186324983326532L;

	@Autowired
	private UserService userService;
	private int userId;
	private User user;
	private String name;
	private String sex;
	private int male;

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	private int role;
	private String icon;
	private String email;
	private int score;
	private String birthday;
	private Date modifybirthday;
	private Map<String, Object> jsonResult;

	public String execute() {
		UserVo vo = new UserVo();
		if (getSession().containsKey("userId")) {
			int userId = (int) getSession().get("userId");
			vo = userService.userInfo(userId);
		}
		if(vo.getRole()==1){
			role=1;
		}else
			role=2;
		return SUCCESS;
	}

	public String getUserInfo() {
		UserVo vo = new UserVo();
		if (getSession().containsKey("userId")) {
			int userId = (int) getSession().get("userId");
			vo = userService.userInfo(userId);
		}
		name = vo.getName();
		int thisSex = vo.getMale();
		if (thisSex == 0) {
			sex = "男";
		} else {
			sex = "女";
		}
		icon = vo.getIconPath();
		email = vo.getEmail();
		score = vo.getScore();
		Date thisbirthday = vo.getBirthday();
		DateFormat df1 = DateFormat.getDateInstance();// 日期格式，精确到日
		birthday = df1.format(thisbirthday);
		return SUCCESS;
	}

	public String modifyInfo() {
		jsonResult = new HashMap<String, Object>();
		UserVo vo = new UserVo();
		if (getSession().containsKey("userId")) {
			int userId = (int) getSession().get("userId");
			vo = userService.userInfo(userId);
		}
		vo.setName(name);
		vo.setMale(male);
		vo.setEmail(email);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			modifybirthday = df.parse(birthday);
		} catch (ParseException e) {
			modifybirthday = new Date();
			e.printStackTrace();
		}
		vo.setBirthday(modifybirthday);
		ResultVo result = userService.modify(vo);
		jsonResult.put("resultMessage", result.getResultMessage());
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getModifybirthday() {
		return modifybirthday;
	}

	public void setModifybirthday(Date modifybirthday) {
		this.modifybirthday = modifybirthday;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
