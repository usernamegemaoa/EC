package njuse.ec.vo;

/**
 * 商品种类vo.
 * @author 阳
 *
 */
public class KindVo {
	
	/**
	 * 分类id.
	 */
	private int kindId;
	
	/**
	 * 父种类id.
	 */
	private int fatherId;
	
	/**
	 * 种类名称.
	 */
	private String name;

	/**
	 * 获取分类id.
	 * @return 分类id
	 */
	public final int getKindId() {
		return kindId;
	}

	/**
	 * 设置分类id.
	 * @param newKindId 分类id
	 */
	public final void setKindId(final int newKindId) {
		this.kindId = newKindId;
	}

	/**
	 * 获取商品父种类.
	 * @return 商品父种类
	 */
	public final int getFatherKind() {
		return fatherId;
	}

	/**
	 * 设置商品父种类.
	 * @param newFatherId 商品父种类
	 */
	public final void setFatherKind(final int newFatherId) {
		this.fatherId = newFatherId;
	}

	/**
	 * 获取商品种类名称.
	 * @return 种类名称
	 */
	public final String getName() {
		return name;
	}

	/**
	 * 设置商品种类名称.
	 * @param newName 种类名称
	 */
	public final void setName(final String newName) {
		this.name = newName;
	}

}
