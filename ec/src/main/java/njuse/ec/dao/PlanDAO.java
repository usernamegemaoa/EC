package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Plan;
/**
 * 进货单DAO接口设计.
 * @author 阳
 *
 */
public interface PlanDAO {
	
	/**
	 * 添加进货单.
	 * @param plan 进货单
	 */
	void addPlan(Plan plan);
	
	/**
	 * 删除进货单.
	 * @param plan 进货单
	 */
	void deletePlan(Plan plan);
	
	/**
	 * 修改进货单.
	 * @param plan 进货单
	 */
	void modifyPlan(Plan plan);
	
	/**
	 * 获取用户进货单.
	 * @param userId 用户id
	 * @return 进货单
	 */
	List<Plan> getPlan(int userId);
}
