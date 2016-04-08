package njuse.ec.dao;

import java.util.List;

import org.hibernate.Session;

/**
 * 基本dao语句.
 * @author 丞
 *
 * @param <T> model 类型
 */
public interface BaseDao<T> {
	
	/**
	 * 获取可自动关闭的session.
	 * @return session
	 */
	Session getSession();

	/**
	 * 必须手动关闭的session.
	 * @return session
	 */
	Session getNewSession();
	
	/**
	 * flush.
	 */
	void flush();

	/**
	 * clear().
	 */
	void clear();

	/**
	 * 根据主键id查找数据库中的一条.
	 * @param c class name
	 * @param id 主键id
	 * @return 对应model类
	 */
	T load(Class<T> c, Long id);

	/**
	 * 获取某张表所有行.
	 * @param c T.CLASS
	 * @return 列表
	 */
	List<T> getAllList(Class<T> c);
	
	/**
	 * 获取总行数.
	 * @param c T.CLASS
	 * @return 行数
	 */
	Long getTotalCount(Class<T> c);

	/**
	 * 保存model.
	 * @param bean model
	 */
	void save(T bean);

	/**
	 * 更新model.
	 * @param bean model
	 */
	void update(T bean);

	/**
	 * 删除model.
	 * @param bean model
	 */
	void delete(T bean);
	
	/**
	 * 根据主键id删除model.
	 * @param c T.CLASS
	 * @param id ID
	 */
	void delete(Class<T> c, String id);

	/**
	 * 删除多个.
	 * @param c T.CLASS
	 * @param ids IDs
	 */
	void delete(Class<T> c, String[] ids);
	
	/**
	 * 根据列名查找一行.
	 * @param c T.CLASS
	 * @param coloum 列头
	 * @param value 值
	 * @return 单行
	 */
	T find(Class<T> c, String coloum, String value);

	/**
	 * 根据列名查找一行.
	 * @param c T.CLASS
	 * @param coloum 列头
	 * @param value 值
	 * @return 列表
	 */
	List<T> findlist(Class<T> c, String coloum, String value);
}
