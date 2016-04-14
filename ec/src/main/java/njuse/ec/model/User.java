package njuse.ec.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * rbac_user表.
 * @author 丞
 *
 */
@Entity
@Table(name = "rbac_user")
public class User implements Serializable {

	/**
	 * 序列号id.
	 */
	private static final long serialVersionUID = 6801315564181546347L;
	
	/**
	 * 用户id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	
	/**
	 * 账号.
	 */
	@Column(name = "account")
	private String account;

	/**
	 * 盐.
	 */
	@Column(name = "salt")
	private String salt;
	
	/**
	 * 密码.
	 */
	@Column(name = "password")
	private String password;
	
	/**
	 * 昵称.
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * email.
	 */
	@Column(name = "email")
	private String email;

	/**
	 * birthday.
	 */
	@Column(name = "birthday", columnDefinition = "DATETIME")
	private Date birthday;

	/**
	 * 头像.
	 */
	@Column(name = "icon")
	private String icon;

	/**
	 * 积分.
	 */
	@Column(name = "score")
	private int score;

	/**
	 * 性别.
	 */
	@Column(name = "male")
	private int male;
	
	/**
	 * 收藏列表.
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "collect",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "good_id"))
	private Set<Good> collections = new HashSet<Good>();
	
	/**
	 * 角色列表.
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "rbac_user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();
	
	/**
	 * 地址列表.
	 */
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "user")
	private Set<Address> addressSet = new HashSet<Address>();

	/**
	 * 发布广告列表.
	 */
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "user")
	private Set<Ad> ads = new HashSet<Ad>();

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
	 * @return the salt
	 */
	public final String getSalt() {
		return salt;
	}

	/**
	 * @param newSalt the salt to set
	 */
	public final void setSalt(final String newSalt) {
		this.salt = newSalt;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param newPassword the password to set
	 */
	public final void setPassword(final String newPassword) {
		this.password = newPassword;
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
	 * @return the icon
	 */
	public final String getIcon() {
		return icon;
	}

	/**
	 * @param newIcon the icon to set
	 */
	public final void setIcon(final String newIcon) {
		this.icon = newIcon;
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
	 * @return the roles
	 */
	public final Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param newRoles the roles to set
	 */
	public final void setRoles(final Set<Role> newRoles) {
		this.roles = newRoles;
	}

	/**
	 * @return the addressSet
	 */
	public final Set<Address> getAddressSet() {
		return addressSet;
	}

	/**
	 * @param newAddressSet the addressSet to set
	 */
	public final void setAddressSet(final Set<Address> newAddressSet) {
		this.addressSet = newAddressSet;
	}

	/**
	 * @return the collections
	 */
	public final Set<Good> getCollections() {
		return collections;
	}

	/**
	 * @param newCollections the collections to set
	 */
	public final void setCollections(final Set<Good> newCollections) {
		this.collections = newCollections;
	}

	/**
	 * @return the ads
	 */
	public final Set<Ad> getAds() {
		return ads;
	}

	/**
	 * @param newAds the ads to set
	 */
	public final void setAds(final Set<Ad> newAds) {
		this.ads = newAds;
	}
	
	
}
