package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Kind;

/**
 * 商品种类DAO的接口设计.
 * @author 阳
 *
 */
public interface KindDAO {
	
	/**
	 * 添加商品种类.
	 * @param kind 商品种类
	 */
	void addKind(Kind kind);
	
	/**
	 * 删除商品种类.
	 * @param kind 商品种类
	 */
	void deleteKind(Kind kind);

	/**
	 * 返回第一级种类列表.
	 * @return 第一级种类列表
	 */
	List<Kind> getFatherKinds();
	
	/**
	 * 返回子种类列表.
	 * @param fatherId 父种类id
	 * @return 子种类列表
	 */
	List<Kind> getSonKinds(int fatherId);
}
