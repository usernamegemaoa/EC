package njuse.ec.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.FavouriteVo;
import njuse.ec.vo.UserVo;

/**
 * 用户模块测试.
 * @author 丞
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
	
	/**
	 * 用户service.
	 */
	@Autowired
	private UserService userService;

	/**
	 * 注册测试.
	 */
	@Test
	public final void testRegister() {
		assertEquals(0, 
				userService.register(new UserVo(), "", "").getResultCode());
		assertEquals(1, userService.register(null, "", "").getResultCode());
	}

	/**
	 * 测试登录.
	 */
	@Test
	public final void testLogin() {
		assertEquals(0, userService.login("", "").getResultCode());
		assertEquals(1, userService.login(null, null).getResultCode());
	}

	/**
	 * 测试修改密码.
	 */
	@Test
	public final void testModifyPassword() {
		assertEquals(0, userService.modifyPassword(new UserVo(), "", "", "")
				.getResultCode());
		assertEquals(1, userService.modifyPassword(null, "", "", "")
				.getResultCode());
	}

	/**
	 * 测试修改个人信息.
	 */
	@Test
	public final void testModify() {
		assertEquals(0, userService.modify(new UserVo()).getResultCode());
		assertEquals(1, userService.modify(null).getResultCode());
	}

	/**
	 * 测试获取个人信息.
	 */
	@Test
	public final void testUserInfo() {
		assertNull(userService.userInfo(-1));
		assertNotNull(userService.userInfo(1));
	}

	/**
	 * 测试添加收藏.
	 */
	@Test
	public final void testFavour() {
		assertEquals(1, userService.favour(null).getResultCode());
		assertEquals(0, userService.favour(new FavouriteVo()).getResultCode());
	}

	/**
	 * 测试获取收藏列表.
	 */
	@Test
	public final void testFavourites() {
		assertTrue(userService.favourites(-1).size() == 0);
		assertTrue(userService.favourites(1).size() > 0);
	}

	/**
	 * 测试是否为收藏. 
	 */
	@Test
	public final void testIsFavour() {
		assertEquals(1, userService.isFavour(-1, -1).getResultCode());
		assertEquals(0, userService.isFavour(1, 1).getResultCode());
	}

}
