package njuse.ec.service;

import java.util.List;

import njuse.ec.vo.FavouriteVo;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.UserVo;

/**
 * 用户模块.
 * @author 丞
 *
 */
public interface UserService {

	/**
	 * 用户注册.
	 * @param userVo 必要用户信息
	 * @param password1 密码
	 * @param password2 重复密码
	 * @return 	0 - 注册成功
	 *			1 - 用户名重复
	 *			2 - 密码长度少于6
	 *			3 - 密码两次重复不同
	 */
	ResultVo register(UserVo userVo, String password1, String password2);
	
	/**
	 * 用户登录.
	 * @param account 账号
	 * @param password 密码
	 * @return	0 - 登录成功(此处返回内容为UserID，为后续查找准备)
	 *			1 - 用户名不存在
	 *			2 - 密码不正确
	 */
	ResultVo login(String account, String password);
	
	/**
	 * 修改密码.
	 * @param userVo 用户信息Vo.
	 * @param oldPassword 旧密码
	 * @param password1 新密码
	 * @param password2 重复新密码
	 * @return	0 - 修改成功
	 *			1 - 旧密码不正确
	 *			2 - 密码长度少于6
	 *			3 - 密码两次重复不同
	 */
	ResultVo modifyPassword(UserVo userVo, String oldPassword, 
			String password1, String password2);
	
	/**
	 * 修改用户信息.
	 * @param userVo 用户信息Vo
	 * @return	0 - 修改成功
	 *			1 - 修改失败
	 */
	ResultVo modify(UserVo userVo);
	
	/**
	 * 获取用户信息.
	 * @param userId 用户id
	 * @return 用户信息Vo.
	 */
	UserVo userInfo(int userId);
	
	/**
	 * 收藏商品.
	 * @param favouriteVo 收藏Vo
	 * @return	0 - 收藏成功
	 *			1 - 收藏失败	
	 */
	ResultVo favour(FavouriteVo favouriteVo);
	
	/**
	 * 获取收藏列表.
	 * @param userId 用户id
	 * @return 收藏列表
	 */
	List<FavouriteVo> favourites(int userId);
	
	/**
	 * 判断是否收藏.
	 * @param userId 用户id
	 * @param goodId 商品id
	 * @return	0 - 是
	 *			1 - 否
	 */
	ResultVo isFavour(int userId, int goodId);
}