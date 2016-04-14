package njuse.ec.vo;

import java.util.Date;
import java.util.List;

/**
 * 用户信息Vo.
 * @author 丞
 *
 */
public class UserVo {

	/**
	 * 用户id.
	 */
	private int id;
	/**
	 * 账号.
	 */
	private String account;
	/**
	 * 姓名or店名.
	 */
	private String name;
	/**
	 * 邮箱.
	 */
	private String email;
	/**
	 * 生日.
	 */
	private Date birthday;
	/**
	 * 头像路径.
	 */
	private String iconPath;
	/**
	 * 积分.
	 */
	private int score;
	/**
	 * 性别.
	 */
	private int male;
	/**
	 * 角色.
	 */
	private int role;
	/**
	 * 地址列表.
	 */
	private List<AddressVo> addressVoList;
	
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
	 * @return the account
	 */
	public final String getAccount() {
		return account;
	}
	/**
	 * @param newAccount the account to set
	 */
	public final void setAccount(final String newAccount) {
		this.account = newAccount;
	}
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @param newName the name to set
	 */
	public final void setName(final String newName) {
		this.name = newName;
	}
	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}
	/**
	 * @param newEmail the email to set
	 */
	public final void setEmail(final String newEmail) {
		this.email = newEmail;
	}
	/**
	 * @return the birthday
	 */
	public final Date getBirthday() {
		return birthday;
	}
	/**
	 * @param newBirthday the birthday to set
	 */
	public final void setBirthday(final Date newBirthday) {
		this.birthday = newBirthday;
	}
	/**
	 * @return the iconPath
	 */
	public final String getIconPath() {
		return iconPath;
	}
	/**
	 * @param newIconPath the iconPath to set
	 */
	public final void setIconPath(final String newIconPath) {
		this.iconPath = newIconPath;
	}
	/**
	 * @return the score
	 */
	public final int getScore() {
		return score;
	}
	/**
	 * @param newScore the score to set
	 */
	public final void setScore(final int newScore) {
		this.score = newScore;
	}
	/**
	 * @return the male
	 */
	public final int getMale() {
		return male;
	}
	/**
	 * @param newMale the male to set
	 */
	public final void setMale(final int newMale) {
		this.male = newMale;
	}
	/**
	 * @return the role
	 */
	public final int getRole() {
		return role;
	}
	/**
	 * @param newRole the role to set
	 */
	public final void setRole(final int newRole) {
		this.role = newRole;
	}
	/**
	 * @return the addressVoList
	 */
	public final List<AddressVo> getAddressVoList() {
		return addressVoList;
	}
	/**
	 * @param newAddressVoList the addressVoList to set
	 */
	public final void setAddressVoList(final List<AddressVo> newAddressVoList) {
		this.addressVoList = newAddressVoList;
	}
	
}
