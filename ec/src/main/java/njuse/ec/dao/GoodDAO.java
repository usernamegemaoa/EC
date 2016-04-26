package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Good;

/**
 * 商品DAO的接口设计.
 * @author 阳
 *
 */
public interface GoodDAO {
	
	/**
	 * 添加商品.
	 * @param good 商品
	 * @return 商品id
	 */
	int addGood(Good good);
	
	/**
	 * 删除商品.
	 * @param good 商品
	 */
	void deleteGood(Good good);
	
	/**
	 * 获取最近上新商品列表.
	 * @return 商品列表
	 */
	List<Good> getLatestGoods();
	
	/**
	 * 获取最近上新商品列表的一段.
	 * @param firstResult 起始值
	 * @param maxResult 最大值
	 * @return 商品列表
	 */
	List<Good> getLatestGoods(int firstResult, int maxResult);
	
	/**
	 * 获取某一种类的商品列表.
	 * @param kindId 种类id
	 * @return 商品列表
	 */
	List<Good> getKindGoods(int kindId);
	
	/**
	 * 获取某一种类商品列表的一段.
	 * @param kindId 种类id
	 * @param firstResult 起始值
	 * @param maxResult 最大值
	 * @return 商品列表
	 */
	List<Good> getKindGoods(int kindId, int firstResult, int maxResult);
	
	/**
	 * 根据商品名获取商品列表.
	 * @param name 商品名
	 * @return 商品列表
	 */
	List<Good> getNameGoods(String name);
	
	/**
	 * 根据商品名获取商品列表的一段.
	 * @param name 商品名
	 * @param firstResult 起始值
	 * @param maxResult 最大值
	 * @return 商品列表
	 */
	List<Good> getNameGoods(String name, int firstResult, int maxResult);
	
	/**
	 * 获取商品.
	 * @param id 商品id
	 * @return 商品
	 */
	Good getGood(int id);
	
	/**
	 * 获取最近上新商品的个数.
	 * @return 个数
	 */
	int getLatestGoodNum();
	
	/**
	 * 获取某一种类商品的个数.
	 * @return 个数
	 */
	int getKindGoodNum(int kindId);
	
	/**
	 * 根据商品名获取商品列表个数.
	 * @param name 商品名
	 * @return 个数
	 */
	int getNameGoodNum(String name);
	
	
}
