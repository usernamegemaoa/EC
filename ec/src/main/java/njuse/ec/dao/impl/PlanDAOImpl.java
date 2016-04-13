package njuse.ec.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.PlanDAO;
import njuse.ec.model.Plan;

/**
 * 进货单DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class PlanDAOImpl implements PlanDAO {

	/**
	 * baseDao.
	 */
	private BaseDao<Plan> baseDao;
	
	@Override
	public final void addPlan(final Plan plan) {
		baseDao.save(plan);
	}

	@Override
	public final void deletePlan(final Plan plan) {
		baseDao.delete(plan);	
	}

	@Override
	public final void modifyPlan(final Plan plan) {
		baseDao.update(plan);
	}

	@Override
	public final List<Plan> getPlan(final int userId) {
		return baseDao.findlist(Plan.class, "userId", String.valueOf(userId));
	}
}
