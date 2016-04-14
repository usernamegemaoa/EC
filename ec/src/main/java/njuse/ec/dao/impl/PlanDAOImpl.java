package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.PlanDAO;
import njuse.ec.model.Cast;
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
	@Autowired
	private BaseDao<Plan> baseDao;
	@Autowired
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
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
	
	@Override
	public final int getShopId(final Plan plan) {
		int stockId = plan.getStockId();
		String hql = "select shop_id from good,stock where id=" + stockId + " and good.id=stock.good_id";
		Session session = getSession();
		List result = session.createSQLQuery(hql).list();
		int shopId = (int) result.get(0);

		return shopId;
	}

	@Override
	public final int getPrice(final Plan plan) {
		int stockId = plan.getStockId();
		String hql = "select price from good where id=" + stockId + " and good.id=stock.good_id";
		Session session = getSession();
		List result = session.createSQLQuery(hql).list();
		int price = (int) result.get(0);
		return price;
	}
}
