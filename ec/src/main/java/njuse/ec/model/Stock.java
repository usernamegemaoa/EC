package njuse.ec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Stock表的实体化映射.
 * @author 阳
 *
 */
@Entity
@Table(name = "stock")
public class Stock implements Serializable {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 库存id.
	 */
	@Id
	@Column(name = "id")
	private int id;
	
	/**
	 * 商品id.
	 */
	@Column(name = "good_id")
	private int goodId;
	
	/**
	 * 商品尺寸.
	 */
	@Column(name = "size")
	private String size;
	
	/**
	 * 商品颜色.
	 */
	@Column(name = "color")
	private String color;
	
	/**
	 * 商品数量.
	 */
	@Column(name = "quantity")
	private int quantity;

	/**
	 * 获取存储id.
	 * @return 存储id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * 设置存储id.
	 * @param newId 存储id
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}

	/**
	 * 获取商品id.
	 * @return 商品id
	 */
	public final int getGoodId() {
		return goodId;
	}

	/**
	 * 设置商品id.
	 * @param newGoodId 商品id
	 */
	public final void setGoodId(final int newGoodId) {
		this.goodId = newGoodId;
	}

	/**
	 * 获取商品型号. 
	 * @return 商品型号
	 */
	public final String getSize() {
		return size;
	}

	/**
	 * 设置商品型号.
	 * @param newSize 商品型号
	 */
	public final void setSize(final String newSize) {
		this.size = newSize;
	}

	/**
	 * 获取商品颜色.
	 * @return 商品颜色
	 */
	public final String getColor() {
		return color;
	}

	/**
	 * 设置商品颜色.
	 * @param newColor 商品颜色
	 */
	public final void setColor(final String newColor) {
		this.color = newColor;
	}

	/**
	 * 获取商品数量.
	 * @return 商品数量
	 */
	public final int getQuantity() {
		return quantity;
	}

	/**
	 * 设置商品数量.
	 * @param newQuantity 商品数量
	 */
	public final void setQuantity(final int newQuantity) {
		this.quantity = newQuantity;
	}	
}
