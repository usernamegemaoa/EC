package njuse.ec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * hot表的实体化映射.
 * @author 阳
 *
 */
@Entity
@Table(name = "hot")
public class Hot implements Serializable {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 同类热销id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	/**
	 * 商品1id.
	 */
	@Column(name = "first_id")
	private int firstId;
	
	/**
	 * 商品2id.
	 */
	@Column(name = "second_id")
	private int secondId;

	/**
	 * 获取热销id.
	 * @return 热销id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * 设置热销id.
	 * @param newId 热销id
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}

	/**
	 * 获取第一个商品的id.
	 * @return 第一个商品的id
	 */
	public final int getFirstId() {
		return firstId;
	}

	/**
	 * 设置第一个商品的id.
	 * @param newFirstId 第一个商品的id
	 */
	public final void setFirstId(final int newFirstId) {
		this.firstId = newFirstId;
	}

	/**
	 * 获取第二个商品的id.
	 * @return 第二个商品的id
	 */
	public final int getSecondId() {
		return secondId;
	}

	/**
	 * 设置第二个商品的id.
	 * @param newSecondId 第二个商品的id
	 */
	public final void setSecondId(final int newSecondId) {
		this.secondId = newSecondId;
	}
}
