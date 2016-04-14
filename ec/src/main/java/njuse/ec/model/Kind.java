package njuse.ec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Kind表的实体化映射.
 * @author 阳
 *
 */
@Entity
@Table(name = "kind")
public class Kind implements Serializable {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 商品种类id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	/**
	 * 父种类id.
	 */
	@Column(name = "father_id")
	private int fatherId;
	
	/**
	 * 种类名.
	 */
	@Column(name = "kind_name")
	private String kindName;

	/**
	 * 获取商品种类id.
	 * @return 种类id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * 设置商品种类id.
	 * @param newId 种类id
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}

	/**
	 * 获取商品父种类id.
	 * @return 父种类id
	 */
	public final int getFatherId() {
		return fatherId;
	}

	/**
	 * 设置商品父种类id.
	 * @param newFatherId 父种类id
	 */
	public final void setFatherId(final int newFatherId) {
		this.fatherId = newFatherId;
	}

	/**
	 * 获取商品种类名.
	 * @return 种类名
	 */
	public final String getKindName() {
		return kindName;
	}

	/**
	 * 设置商品种类名.
	 * @param newKindName 种类名
	 */
	public final void setKindName(final String newKindName) {
		this.kindName = newKindName;
	}

	
}
