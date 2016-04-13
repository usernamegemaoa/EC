package njuse.ec.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.ConsultDAO;
import njuse.ec.model.Consult;

/**
 * 咨询DAO接口实现.
 * @author 阳
 *
 */
@Repository
public class ConsultDAOImpl implements ConsultDAO {

	/**
	 * baseDao.
	 */
	private BaseDao<Consult> baseDao;
	
	@Override
	public final void addConsult(final Consult consult) {
		baseDao.save(consult);
	}

	@Override
	public final void deleteConsult(final Consult consult) {
		baseDao.delete(consult);
	}

	@Override
	public final List<Consult> getConsults(final int goodId) {
		return baseDao.findlist(Consult.class, "goodId", String.valueOf(goodId));
	}
}
