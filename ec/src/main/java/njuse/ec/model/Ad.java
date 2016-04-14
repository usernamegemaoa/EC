package njuse.ec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 广告表.
 * @author 丞
 *
 */
@Entity
@Table(name = "ad")
public class Ad implements Serializable {

	/**
	 * 序列化id.
	 */
	private static final long serialVersionUID = 4047302994470882082L;
	
	/**
	 * 广告id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	
	/**
	 * 图片路径.
	 */
	@Column(name = "picture")
	private String picPath;
	
	/**
	 * 广告类型.
	 */
	@Column(name = "mode")
	private int mode;
	
	/**
	 * 广告商品.
	 */
	@ManyToOne(targetEntity = Good.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "good_id")
	private Good good;
	
	/**
	 * 广告店家.
	 */
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

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
	 * @return the picPath
	 */
	public final String getPicPath() {
		return picPath;
	}

	/**
	 * @param newPicPath the picPath to set
	 */
	public final void setPicPath(final String newPicPath) {
		this.picPath = newPicPath;
	}

	/**
	 * @return the mode
	 */
	public final int getMode() {
		return mode;
	}

	/**
	 * @param newMode the mode to set
	 */
	public final void setMode(final int newMode) {
		this.mode = newMode;
	}

	/**
	 * @return the good
	 */
	public final Good getGood() {
		return good;
	}

	/**
	 * @param newGood the good to set
	 */
	public final void setGood(final Good newGood) {
		this.good = newGood;
	}

	/**
	 * @return the user
	 */
	public final User getUser() {
		return user;
	}

	/**
	 * @param newUser the user to set
	 */
	public final void setUser(final User newUser) {
		this.user = newUser;
	}

}
