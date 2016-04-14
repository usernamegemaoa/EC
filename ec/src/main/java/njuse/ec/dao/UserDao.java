package njuse.ec.dao;

import njuse.ec.model.User;

/**
 * user database.
 * @author 丞
 *
 */
public interface UserDao {

	/**
	 * 根据id查找用户.
	 * @param userId 用户id
	 * @return 用户model
	 */
	User find(int userId);

	/**
	 * 根据账户查找用户.
	 * @param account 用户account
	 * @return 用户model
	 */
	User find(String account);
	
}
