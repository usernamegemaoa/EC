package njuse.ec.dao;

import njuse.ec.model.Cast;

/**
 * 进货单dao.
 * @author 丞
 *
 */
public interface CastDAO {
    /**
     * 获取商品id.
     * @param cast cast
     * @return id
     */
    int getShopId(Cast cast);

	/**
	 * 获取价格.
	 * @param cast cast
	 * @return 价格
	 */
	int getPrice(Cast cast);
	
}
