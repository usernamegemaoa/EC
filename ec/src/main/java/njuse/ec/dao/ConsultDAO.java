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
	 * 获取商品咨询.
	 * @param goodId 商品id
	 * @return 咨询列表
	 */
	List<Consult> getConsults(int goodId);
	
}
