package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Hot;

/**
 * 同类热销DAO的接口设计.
 * @author 阳
 *
 */
public interface HotDAO {
	
	/**
	 * 添加同类热销.
	 * @param hot 同类热销
	 */
	void addHot(Hot hot);
	
	/**
	 * 删除同类热销.
	 * @param hot 同类热销
	 */
	void deleteHot(Hot hot);
	
	/**
	 * 获取同类热销列表.
	 * @param firstId 第一个商品的id
	 * @return 同类热销列表
	 */
	List<Hot> getHot(int firstId);
}
