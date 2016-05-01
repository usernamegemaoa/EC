package njuse.ec.service;

import java.util.List;

import njuse.ec.model.Plan;
import njuse.ec.vo.CastVo;
import njuse.ec.vo.GoodElement;
import njuse.ec.vo.ResultVo;


/**
 * 购物车模块.
 * @author 阳
 *
 */
public interface CastService {

	/**
	 * 获取用户的购物车列表.
	 * @param userId 用户id
	 * @return 购物车列表
	 */
	List<CastVo> getMyCast(int userId);

	/**
	 * 在购物车中添加商品.
	 * @param userId 用户id
	 * @param cast 进货单
	 * @return 是否添加成功
	 */
	ResultVo addCast(int userId, CastVo cast);

	/**
	 * 在购物车中删除商品.
	 * @param userId 用户id
	 * @param cast 进货单
	 * @return 是否删除成功
	 */
	ResultVo deleteCast(int userId, CastVo cast);

	/**
	 * 修改购物车中的商品.
	 * @param userId 用户id
	 * @param cast 进货单
	 * @return 是否修改成功
	 */
	ResultVo modifyCast(int userId, CastVo cast);
	
	/**
	 * 将CastVo转化成Plan实体.
	 * @param cast castVo
	 * @return plan实体
	 */
	Plan convertToPlan(final CastVo cast);
	
	/**
	 * 将plan实体转化为CastVo.
	 * @param plan plan实体
	 * @return CastVo
	 */
	CastVo convertToCast(final Plan plan);
	
	/**
	 * 获取进货单节点.
	 * @param userId 用户id
	 * @return 进货单节点
	 */
	List<GoodElement> getCastElement(int userId);
}
