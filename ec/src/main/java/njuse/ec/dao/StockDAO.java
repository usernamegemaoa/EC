package njuse.ec.dao;


import njuse.ec.model.Stock;

/**
 * 库存DAO接口设计.
 * @author 阳
 *
 */
public interface StockDAO {

	/**
	 * 添加库存.
	 * @param stock 库存
	 */
	void addStock(Stock stock);
	
	/**
	 * 删除库存.
	 * @param stock 库存
	 */
	void deleteStock(Stock stock);
	
	/**
	 * 修改库存.
	 * @param stock 库存
	 */
	void modifyStock(Stock stock);
	
	/**
	 * 获取库存.
	 * @param stockId 库存id
	 * @return 库存列表
	 */
	Stock getStock(int stockId);
	
	
}
