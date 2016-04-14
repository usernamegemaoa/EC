package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.SubConsult;

/**
 * 子咨询DAO接口设计.
 * @author 阳
 *
 */
public interface SubConsultDAO {
	
	/**
	 * 添加子咨询.
	 * @param subConsult 子咨询
	 */
	void addSubConsult(SubConsult subConsult);
	
	/**
	 * 删除子咨询.
	 * @param subConsult subConsult
	 */
	void deleteSubConsult(SubConsult subConsult);

	/**
	 * 获取子咨询.
	 * @param consultId 父咨询id
	 * @return 子咨询列表
	 */
	List<SubConsult> getSubConsults(int consultId);
}
