package njuse.ec.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.GoodDAO;
import njuse.ec.model.Good;

/**
 * 商品DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class GoodDAOImpl implements GoodDAO {
	
	/**
	 * baseDao.
	 */
	private BaseDao<Good> baseDao;

	@Override
	public final void addGood(final Good good) {
		baseDao.save(good);
	}

	@Override
	public final void deleteGood(final Good good) {
		baseDao.delete(good);
	}

	@Override
	public final List<Good> getLatestGoods() {
		return baseDao.sortlist(Good.class, "time", false);
	}

	@Override
	public final List<Good> getKindGoods(final int kindId) {
		return baseDao.findlist(Good.class, "kindId", String.valueOf(kindId));
	}

	@Override
	public final List<Good> getNameGoods(final String name) {
		String newName = "%" + name + "%";
		return baseDao.findlist(Good.class, "name", newName);
	}

	@Override
	public final Good getGood(final int id) {
		return baseDao.load(Good.class, id);
	}
}
