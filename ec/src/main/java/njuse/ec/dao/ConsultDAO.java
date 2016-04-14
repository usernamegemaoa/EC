package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Consult;

/**
 * 咨询DAO的接口设计.
 * @author 阳
 *
 */
public interface ConsultDAO {
	
	/**
	 * 添加咨询.
	 * @param consult 咨询
	 */
	void addConsult(Consult consult);

	/**
	 * 删除咨询.
	 * @param consult 咨询
	 */
	void deleteConsult(Consult consult);
	
	/**
	 * 获取某件商品咨询列表的个数.
	 * @param goodId 商品id
	 * @return 个数
	 */
	int getConsultNum(int goodId);
	
	/**
	 * 获取商品咨询.
	 * @param goodId 商品id
	 * @return 咨询列表
	 */
	List<Consult> getConsults(int goodId);
	
	/**
	 * 获取某一商品咨询的一部分.
	 * @param goodId 商品id
	 * @param firstResult 起始值
	 * @param maxResult 最大值
	 * @return 咨询列表
	 */
	List<Consult> getConsults(int goodId, int firstResult, int maxResult);
}
