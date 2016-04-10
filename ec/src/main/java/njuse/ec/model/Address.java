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
 * address表.
 * @author 丞
 *
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	/**
	 * 序列号id.
	 */
	private static final long serialVersionUID = 6822836941567885920L;

	/**
	 * 地址id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;

	/**
	 * 邮编.
	 */
	@Column(name = "place_code")
	private int placeCode;
	
	/**
	 * 地址.
	 */
	@Column(name = "place_name")
	private String placeName;
	
	/**
	 * 收件人.
	 */
	@Column(name = "people")
	private String people;

	/**
	 * 联系方式.
	 */
	@Column(name = "phone")
	private String phone;
	
	/**
	 * 地址归属用户.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
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
	 * @return the placeCode
	 */
	public final int getPlaceCode() {
		return placeCode;
	}

	/**
	 * @param newPlaceCode the placeCode to set
	 */
	public final void setPlaceCode(final int newPlaceCode) {
		this.placeCode = newPlaceCode;
	}

	/**
	 * @return the placeName
	 */
	public final String getPlaceName() {
		return placeName;
	}

	/**
	 * @param newPlaceName the placeName to set
	 */
	public final void setPlaceName(final String newPlaceName) {
		this.placeName = newPlaceName;
	}

	/**
	 * @return the people
	 */
	public final String getPeople() {
		return people;
	}

	/**
	 * @param newPeople the people to set
	 */
	public final void setPeople(final String newPeople) {
		this.people = newPeople;
	}

	/**
	 * @return the phone
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * @param newPhone the phone to set
	 */
	public final void setPhone(final String newPhone) {
		this.phone = newPhone;
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
