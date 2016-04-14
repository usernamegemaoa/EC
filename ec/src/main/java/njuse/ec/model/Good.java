package njuse.ec.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Good表的实体化映射.
 * @author 阳
 *
 */
@Entity
@Table(name = "good")
public class Good implements Serializable {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 商品id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	/**
	 * 商品种类id.
	 */
	@Column(name = "kind_id")
	private int kindId;
	
	/**
	 * 店主id.
	 */
	@Column(name = "shop_id")
	private int shopId;
	
	/**
	 * 商品名.
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 货号.
	 */
	@Column(name = "good_num")
	private String goodNum;
	
	/**
	 * 描述.
	 */
	@Column(name = "description")
	private String description;
	
	/**
	 * 价格.
	 */
	@Column(name = "price")
	private double price;
	
	/**
	 * 送货信息.
	 */
	@Column(name = "deliver_info")
	private String deliverInfo;
	
	/**
	 * 退货相关.
	 */
	@Column(name = "return_info")
	private String returnInfo;
	
	/**
	 * 上架时间.
	 */
	@Column(name = "time")
	private Date time;
	
	/**
	 * 收藏本商品的用户列表.
	 */
	@ManyToMany(mappedBy = "collections", fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<User>();

	/**
	 * 获取用户id.
	 * @return 用户id.
	 */
	public final int getId() {
		return id;
	}

	/**
	 * 设置用户id.
	 * @param newId 用户id
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}

	/**
	 * 获取商品种类id.
	 * @return 商品种类id
	 */
	public final int getKindId() {
		return kindId;
	}

	/**
	 * 设置商品种类id.
	 * @param newKindId 商品种类id
	 */
	public final void setKindId(final int newKindId) {
		this.kindId = newKindId;
	}

	/**
	 * 获取商家id.
	 * @return 商家id
	 */
	public final int getShopId() {
		return shopId;
	}

	/**
	 * 设置商家id.
	 * @param newShopId 商家id
	 */
	public final void setShopId(final int newShopId) {
		this.shopId = newShopId;
	}

	/**
	 * 获取商品名.
	 * @return 商品名
	 */
	public final String getName() {
		return name;
	}

	/**
	 * 设置商品名.
	 * @param newName 商品名
	 */
	public final void setName(final String newName) {
		this.name = newName;
	}

	/**
	 * 获取商品货号.
	 * @return 商品货号
	 */
	public final String getGoodNum() {
		return goodNum;
	}

	/**
	 * 设置商品货号.
	 * @param newGoodNum 商品货号
	 */
	public final void setGoodNum(final String newGoodNum) {
		this.goodNum = newGoodNum;
	}

	/**
	 * 获取商品描述.
	 * @return 商品描述
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * 设置商品描述.
	 * @param newDescription 商品描述
	 */
	public final void setDescription(final String newDescription) {
		this.description = newDescription;
	}

	/**
	 * 获取商品价格.
	 * @return 商品价格
	 */
	public final double getPrice() {
		return price;
	}

	/**
	 * 设置商品价格.
	 * @param newPrice 商品价格
	 */
	public final void setPrice(final double newPrice) {
		this.price = newPrice;
	}

	/**
	 * 获取送货信息.
	 * @return 送货信息
	 */
	public final String getDeliverInfo() {
		return deliverInfo;
	}

	/**
	 * 设置送货信息.
	 * @param newDeliverInfo 送货信息
	 */
	public final void setDeliverInfo(final String newDeliverInfo) {
		this.deliverInfo = newDeliverInfo;
	}

	/**
	 * 获取退货信息.
	 * @return 退货信息
	 */
	public final String getReturnInfo() {
		return returnInfo;
	}

	/**
	 * 设置退货信息.
	 * @param newReturnInfo 退货信息
	 */
	public final void setReturnInfo(final String newReturnInfo) {
		this.returnInfo = newReturnInfo;
	}

	/**
	 * 获取商品上架时间.
	 * @return 上架时间
	 */
	public final Date getTime() {
		return time;
	}

	/**
	 * 设置商品上架时间.
	 * @param newTime 上架时间
	 */
	public final void setTime(final Date newTime) {
		this.time = newTime;
	}
	/**
	 * 获取收藏本商品的用户列表.
	 * @return the users
	 */
	public final Set<User> getUsers() {
		return users;
	}

	/**
	 * 设置本商品的用户列表.
	 * @param newUsers the users to set
	 */
	public final void setUsers(final Set<User> newUsers) {
		this.users = newUsers;
	}
}