package njuse.ec.action;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.model.User;
import njuse.ec.service.UserService;
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
	private String icon;
	private String email;
    private int score;
    private String birthday;
    
    
    public String execute(){
    	return SUCCESS;
    }
    
    public String getUserInfo(){
    	UserVo vo=new UserVo();
    	if (getSession().containsKey("userId")) {
			int userId = (int) getSession().get("userId");
			vo = userService.userInfo(userId);
		}
    	name=vo.getName();
    	int thisSex=vo.getMale();
    	if(thisSex==0){
    		sex="男";
    	}else{
    		sex="女";
    	}
    	icon=vo.getIconPath();
    	email=vo.getEmail();
    	score=vo.getScore();
    	Date thisbirthday=vo.getBirthday();
    	DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        birthday=df1.format(thisbirthday);
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
    
    
}
