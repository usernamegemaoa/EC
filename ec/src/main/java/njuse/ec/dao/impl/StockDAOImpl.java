package njuse.ec.dao.impl;


import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.StockDAO;
import njuse.ec.model.Stock;

/**
 * 库存DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class StockDAOImpl implements StockDAO {
	
	/**
	 * baseDao.
	 */
	private BaseDao<Stock> baseDao;

	@Override
	public final void addStock(final Stock stock) {
		baseDao.save(stock);
	}

	@Override
	public final void deleteStock(final Stock stock) {
		baseDao.delete(stock);
	}

	@Override
	public final void modifyStock(final Stock stock) {
		baseDao.update(stock);
	}

	@Override
	public final Stock getStock(final int stockId) {
		return baseDao.load(Stock.class, stockId);
	}

}
