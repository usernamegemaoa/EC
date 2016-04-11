package njuse.ec.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.AddressVo;
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
	 * 数据库中用于测试的ID.
	 */
	private static final int MAGIC_ID = 123;

	/**
	 * 注册测试.
	 */
	@Test
	public final void testRegister() {
		UserVo vo = new UserVo();
		vo.setAccount("account");
		vo.setBirthday(new Date());
		vo.setEmail("504906985@qq.com");
		vo.setIconPath("/asdf/asdf.png");
		vo.setMale(0);
		vo.setName("lc");
		vo.setScore(0);
		vo.setRole(1);
		String pw  = "12345678";
		assertEquals(0, userService.register(vo, pw, pw).getResultCode());
	}

	/**
	 * 测试登录.
	 */
	@Test
	public final void testLogin() {
		UserVo vo = new UserVo();
		vo.setAccount("testlogin");
		vo.setBirthday(new Date());
		vo.setEmail("504906985@qq.com");
		vo.setIconPath("/asdf/asdf.png");
		vo.setMale(0);
		vo.setName("hehe");
		vo.setScore(0);
		vo.setRole(1);
		String pw  = "12345678";
		userService.register(vo, pw, pw);
		assertEquals(0, userService.login(vo.getAccount(), pw).getResultCode());
	}

	/**
	 * 测试修改密码.
	 */
	@Test
	public final void testModifyPassword() {
		UserVo vo = new UserVo();
		vo.setAccount("testmodifypassword");
		vo.setBirthday(new Date());
		vo.setEmail("504906985@qq.com");
		vo.setIconPath("/asdf/asdf.png");
		vo.setMale(0);
		vo.setName("hehe");
		vo.setScore(0);
		vo.setRole(1);
		String pw  = "12345678";
		userService.register(vo, pw, pw);
		String s = userService.login(vo.getAccount(), pw).getResultMessage();
		int userId = Integer.parseInt(s);
		vo = userService.userInfo(userId);
		assertEquals(0,
				userService.modifyPassword(vo, pw, pw, pw).getResultCode());
	}

	/**
	 * 测试修改个人信息.
	 */
	@Test
	public final void testModify() {
		UserVo vo = new UserVo();
		vo.setAccount("testmodify");
		vo.setBirthday(new Date());
		vo.setEmail("504906985@qq.com");
		vo.setIconPath("/asdf/asdf.png");
		vo.setMale(0);
		vo.setName("hehe");
		vo.setScore(0);
		vo.setRole(1);
		String pw  = "12345678";
		userService.register(vo, pw, pw);
		String s = userService.login(vo.getAccount(), pw).getResultMessage();
		int userId = Integer.parseInt(s);
		vo = userService.userInfo(userId);
		vo.setName("fffff");
		vo.setRole(2);
		AddressVo addressVo = new AddressVo();
		addressVo.setPeople("adsf");
		addressVo.setPhone("12345678");
		addressVo.setPlaceCode(1);
		addressVo.setPlaceName("erewrwer");
		vo.getAddressVoList().add(addressVo);
		assertEquals(0, userService.modify(vo).getResultCode());
		vo = userService.userInfo(userId);
		vo.getAddressVoList().get(0).setPhone("9999999");
		addressVo.setPlaceName("newone");
		vo.getAddressVoList().add(addressVo);
		userService.modify(vo);
	}

	/**
	 * 测试获取个人信息.
	 */
	@Test
	public final void testUserInfo() {
		UserVo vo = new UserVo();
		vo.setAccount("testuserinfo");
		vo.setBirthday(new Date());
		vo.setEmail("504906985@qq.com");
		vo.setIconPath("/asdf/asdf.png");
		vo.setMale(0);
		vo.setName("hehe");
		vo.setScore(0);
		vo.setRole(1);
		String pw  = "12345678";
		userService.register(vo, pw, pw);
		String s = userService.login(vo.getAccount(), pw).getResultMessage();
		int userId = Integer.parseInt(s);
		vo = userService.userInfo(userId);
		assertEquals("hehe", vo.getName());
	}

	/**
	 * 测试添加收藏.
	 */
	@Test
	public final void testFavour() {
		assertNotNull(userService.favour(MAGIC_ID, MAGIC_ID));
	}

	/**
	 * 测试获取收藏列表.
	 */
	@Test
	public final void testFavourites() {
		assertNotNull(userService.favour(MAGIC_ID, MAGIC_ID));
		assertTrue(userService.favourites(MAGIC_ID).size() > 0);
	}

	/**
	 * 测试是否为收藏. 
	 */
	@Test
	public final void testIsFavour() {
		assertNotNull(userService.favour(MAGIC_ID, MAGIC_ID));
		assertEquals(0,
				userService.isFavour(MAGIC_ID, MAGIC_ID).getResultCode());
	}

	/**
	 * 测试取消收藏.
	 */
	@Test
	public final void testUnFavour() {
		assertNotNull(userService.favour(MAGIC_ID, MAGIC_ID));
		assertEquals(0,
				userService.unFavour(MAGIC_ID, MAGIC_ID).getResultCode());
	}
}
