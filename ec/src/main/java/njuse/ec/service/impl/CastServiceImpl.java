package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.PlanDAO;
import njuse.ec.dao.StockDAO;
import njuse.ec.model.Plan;
import njuse.ec.model.Stock;
import njuse.ec.service.CastService;
import njuse.ec.vo.CastVo;
import njuse.ec.vo.ResultVo;

/**
 * 进货单服务实现.
 * @author 阳
 *
 */
@Service
public class CastServiceImpl implements CastService {

	/**
	 * PlanDAO.
	 */
	@Autowired
	private PlanDAO planDao;
	
	/**
	 * StockDAO.
	 */
	@Autowired
	private StockDAO stockDao;
	
	@Override
	public final List<CastVo> getMyCast(final int userId) {
		List<CastVo> myCast = new ArrayList<CastVo>();
		try {
			List<Plan> plans = planDao.getPlan(userId);
			for (int i = 0; i < plans.size(); i++) {
				Plan plan = plans.get(i);
				CastVo cast = convertToCast(plan);
				myCast.add(cast);
			}
			return myCast;
		} catch (Exception e) {
			e.printStackTrace();
			return myCast;
		}
	}

	@Override
	public final ResultVo addCast(final int userId, final CastVo cast) {
		cast.setUserId(userId);
		Plan plan = convertToPlan(cast);
		ResultVo addCastResult = new ResultVo();
		try {
			planDao.addPlan(plan);
			addCastResult.setResultCode(0);
			addCastResult.setResultMessage("订单添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			addCastResult.setResultCode(1);
			addCastResult.setResultMessage("订单添加失败");
		}
		return addCastResult;
	}

	@Override
	public final ResultVo deleteCast(final int userId, final CastVo cast) {
		cast.setUserId(userId);
		Plan plan = convertToPlan(cast);
		ResultVo deleteCastResult = new ResultVo();
		try {
			planDao.deletePlan(plan);
			deleteCastResult.setResultCode(0);
			deleteCastResult.setResultMessage("订单删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			deleteCastResult.setResultCode(1);
			deleteCastResult.setResultMessage("订单删除失败");
		}
		return deleteCastResult;
	}

	@Override
	public final ResultVo modifyCast(final int userId, final CastVo cast) {
		cast.setUserId(userId);
		Plan plan = convertToPlan(cast);
		ResultVo modifyCastResult = new ResultVo();
		try {
			planDao.modifyPlan(plan);
			modifyCastResult.setResultCode(0);
			modifyCastResult.setResultMessage("订单修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			modifyCastResult.setResultCode(1);
			modifyCastResult.setResultMessage("订单修改失败");
		}
		return modifyCastResult;
	}
	
	/**
	 * 将plan实体转化为CastVo.
	 * @param plan plan实体
	 * @return CastVo
	 */
	public CastVo convertToCast(final Plan plan) {
		CastVo cast = new CastVo();
		int id = plan.getId();
		int stockId = plan.getStockId();
		int userId = plan.getUserId();
		int quantity = plan.getQuantity();
		Stock stock = stockDao.getStock(stockId);
		int goodId = stock.getGoodId();
		String color = stock.getColor();
		String size = stock.getSize();
		cast.setCastId(id);
		cast.setStockId(stockId);
		cast.setUserId(userId);
		cast.setNum(quantity);
		cast.setGoodId(goodId);
		cast.setColor(color);
		cast.setSize(size);
		return cast;
	}

	/**
	 * 将CastVo转化成Plan实体.
	 * @param cast castVo
	 * @return plan实体
	 */
	public Plan convertToPlan(final CastVo cast) {
		Plan plan = new Plan();
		int id = cast.getCastId();
		int stockId = cast.getStockId();
		int userId = cast.getUserId();
		int quantity = cast.getNum();
		plan.setId(id);
		plan.setStockId(stockId);
		plan.setUserId(userId);
		plan.setQuantity(quantity);
		return plan;
	}
}
