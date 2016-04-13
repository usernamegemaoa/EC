package njuse.ec.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.SubConsultDAO;
import njuse.ec.model.SubConsult;

/**
 * 子咨询DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class SubConsultDAOImpl implements SubConsultDAO {
	
	/**
	 * baseDao.
	 */
	private BaseDao<SubConsult> baseDao;

	@Override
	public final void addSubConsult(final SubConsult subConsult) {
		baseDao.save(subConsult);
	}

	@Override
	public final void deleteSubConsult(final SubConsult subConsult) {
		baseDao.delete(subConsult);
	}

	@Override
	public final List<SubConsult> getSubConsult(final int consultId) {
		return baseDao.findlist(SubConsult.class, "consultId", String.valueOf(consultId));
	}

}
