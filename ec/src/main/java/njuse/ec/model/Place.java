package njuse.ec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 地名表.
 * @author 丞
 *
 */
@Entity
@Table(name = "place")
public class Place implements Serializable {
	
	/**
	 * 序列号id.
	 */
	private static final long serialVersionUID = 8449362371280039622L;

	/**
	 * 地点id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	
	/**
	 * 地名.
	 */
	@Column(name = "place_name")
	private String placeName;
	
	/**
	 * 地址编号.
	 */
	@Column(name = "place_code")
	private int placeCode;

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
	
}
