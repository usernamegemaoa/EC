package njuse.ec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Plan表的实体化映射.
 * @author 阳
 *
 */
@Entity
@Table(name = "plan")
public class Plan implements Serializable {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 进货单id.
	 */
	@Id
	@Column(name = "id")
	private int id;
	
	/**
	 * 库存id.
	 */
	@Column(name = "stock_id")
	private int stockId;
	
	/**
	 * 用户id.
	 */
	@Column(name = "user_id")
	private int userId;
	
	/**
	 * 数量.
	 */
	@Column(name = "quantity")
	private int quantity;

	/**
	 * 获取进货单id.
	 * @return 进货单id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * 设置进货单id.
	 * @param newId 进货单id
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}

	/**
	 * 获取库存id.
	 * @return 库存id
	 */
	public final int getStockId() {
		return stockId;
	}

	/**
	 * 设置库存id.
	 * @param newStockId 库存id
	 */
	public final void setStockId(final int newStockId) {
		this.stockId = newStockId;
	}

	/**
	 * 获取用户id.
	 * @return 用户id
	 */
	public final int getUserId() {
		return userId;
	}

	/**
	 * 设置用户id.
	 * @param newUserId 用户id
	 */
	public final void setUserId(final int newUserId) {
		this.userId = newUserId;
	}

	/**
	 * 获取数量.
	 * @return 数量
	 */
	public final int getQuantity() {
		return quantity;
	}

	/**
	 * 设置数量.
	 * @param newQuantity 数量
	 */
	public final void setQuantity(final int newQuantity) {
		this.quantity = newQuantity;
	}

}
