package njuse.ec.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * 商品vo.
 * @author 阳
 *
 */
public class GoodVo {
	
	/**
	 * 商品id.
	 */
	private int goodId;
	
	/**
	 * 商品种类id.
	 */
	private int kindId;
	
	/**
	 * 商家id.
	 */
	private int sellerId;
	
	/**
	 * 商品名称.
	 */
	private String name;
	
	/**
	 * 商品货号.
	 */
	private String goodNum;
	
	/**
	 * 商品描述.
	 */
	private String description;
	
	/**
	 * 商品单价.
	 */
	private double price;
	
	/**
	 * 送货信息.
	 */
	private String deliverInfo;
	
	/**
	 * 退货信息.
	 */
	private String returnInfo;
	
	/**
	 * 上架时间.
	 */
	private Date time;
	
	/**
	 * 商品图片.
	 */
	private ArrayList<String> imgs = new ArrayList<String>();
	
	/**
	 * 商品主图片.
	 */
	private String mainPic = "defaultImg";

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
	 * 获取种类id.
	 * @return 种类id
	 */
	public final int getKindId() {
		return kindId;
	}

	/**
	 * 设置种类id.
	 * @param newKindId 种类id
	 */
	public final void setKindId(final int newKindId) {
		this.kindId = newKindId;
	}

	/**
	 * 获取商家id.
	 * @return 商家id
	 */
	public final int getSellerId() {
		return sellerId;
	}

	/**
	 * 设置商家id.
	 * @param newSellerId 商家id
	 */
	public final void setSellerId(final int newSellerId) {
		this.sellerId = newSellerId;
	}

	/**
	 * 获取商品名称.
	 * @return 商品名称
	 */
	public final String getName() {
		return name;
	}

	/**
	 * 设置商品名称.
	 * @param newName 商品名称
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
	 * 获取上架时间.
	 * @return 上架时间
	 */
	public final Date getTime() {
		return time;
	}

	/**
	 * 设置上架时间.
	 * @param newTime 上架时间
	 */
	public final void setTime(final Date newTime) {
		this.time = newTime;
	}

	/**
	 * 获取商品图片.
	 * @return 商品图片
	 */
	public final ArrayList<String> getImgs() {
		return imgs;
	}

	/**
	 * 设置商品图片.
	 * @param newImgs 商品图片
	 */
	public final void setImgs(final ArrayList<String> newImgs) {
		this.imgs = newImgs;
	}

	/**
	 * 获取商品主图片.
	 * @return 主图片
	 */
	public final String getMainPic() {
		return mainPic;
	}

	/**
	 * 设置商品主图片.
	 * @param newMainPic 主图片
	 */
	public final void setMainPic(final String newMainPic) {
		this.mainPic = newMainPic;
	}
}
