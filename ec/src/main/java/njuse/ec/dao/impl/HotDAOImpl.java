package njuse.ec.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.HotDAO;
import njuse.ec.model.Hot;

/**
 * 同类热销DAO的接口设计.
 * @author 阳
 *
 */
@Repository
public class HotDAOImpl implements HotDAO {
	
	/**
	 * baseDao.
	 */
	@Autowired
	private BaseDao<Hot> baseDao;
	
	@Override
	public final void addHot(final Hot hot) {
		baseDao.save(hot);
	}

	@Override
	public final void deleteHot(final Hot hot) {
		baseDao.delete(hot);
	}

	@Override
	public final List<Hot> getHot(final int firstId) {
		return baseDao.findlist(Hot.class, "firstId", String.valueOf(firstId));
	}
}
