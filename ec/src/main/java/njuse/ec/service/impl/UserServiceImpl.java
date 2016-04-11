package njuse.ec.service.impl;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.BaseDao;
import njuse.ec.model.Address;
import njuse.ec.model.Good;
import njuse.ec.model.Role;
import njuse.ec.model.User;
import njuse.ec.service.UserService;
import njuse.ec.vo.AddressVo;
import njuse.ec.vo.FavouriteVo;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.UserVo;
import static njuse.ec.util.StringUtil.isNull;

/**
 * 用户模块实现.
 * @author 丞
 *
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * 账号已存在.
	 */
	private static final int EXIST_CODE = 1;
	
	/**
	 * 密码长度小于6.
	 */
	private static final int LENGTH_CODE = 2;
	/**
	 * 密码重复不同.
	 */
	private static final int REPEAT_CODE = 3;
	/**
	 * 账号或密码为空.
	 */
	private static final int NULL_CODE = 4;
	
	/**
	 * 密码最短长度.
	 */
	private static final int MIN_PASSWORD_LENGTH = 6;
	
	/**
	 * see here
	 * <a href="http://stackoverflow.com/questions/41107/">
	 * How to generate a random alpha-numeric string?
	 * </a>
	 */
	private static final int MD5_OPTION = 130;
	
	/**
	 * user dao.
	 */
	@Autowired
	private BaseDao<User> userDao;
	
	/**
	 * role dao.
	 */
	@Autowired
	private BaseDao<Role> roleDao;
	
	/**
	 * address dao.
	 */
	@Autowired
	private BaseDao<Address> addressDao;
	
	/**
	 * good dao.
	 */
	@Autowired
	private BaseDao<Good> goodDao;

	@Override
	public final ResultVo register(final UserVo userVo,
			final String password1, final String password2) {
		ResultVo result = new ResultVo();
		
		if (isNull(password1) || isNull(password2) 
				|| isNull(userVo.getAccount())) {
			result.setResultCode(NULL_CODE);
			result.setResultMessage("账号或密码为空");
			return result;
		}
		
		if (!password1.equals(password2)) {
			result.setResultCode(REPEAT_CODE);
			result.setResultMessage("密码重复不同");
			return result;
		}
		
		if (password1.length() < MIN_PASSWORD_LENGTH) {
			result.setResultCode(LENGTH_CODE);
			result.setResultMessage("密码长度小于" + MIN_PASSWORD_LENGTH);
			return result;
		}
		
		if (userDao.find(User.class, "account", userVo.getAccount()) != null) {
			result.setResultCode(EXIST_CODE);
			result.setResultMessage("账号已存在");
			return result;
		}
		
		SecureRandom random = new SecureRandom();
		String salt = (new BigInteger(MD5_OPTION, random)).toString();
		String password = DigestUtils.md5Hex(password1);
		password = password + salt;
		password = DigestUtils.md5Hex(password);
		
		User user = new User();
		user.setAccount(userVo.getAccount());
		user.setSalt(salt);
		user.setPassword(password);
		user.setName(userVo.getName());
		user.setEmail(userVo.getEmail());
		user.setBirthday(userVo.getBirthday());
		user.setIcon(userVo.getIconPath());
		user.setScore(0);
		user.setMale(userVo.getMale());
		
		Role role = roleDao.load(Role.class, userVo.getRole());
		System.out.println(role.getName());
		userDao.save(user);
		
		user = userDao.find(User.class, "account", userVo.getAccount());
		user.getRoles().add(role);
		userDao.update(user);
		
		result.setResultCode(0);
		result.setResultMessage("注册成功");
		
		return result;
	}

	@Override
	public final ResultVo login(final String account, final String password) {
		ResultVo result = new ResultVo();
		if (isNull(account)) {
			result.setResultCode(1);
			result.setResultMessage("用户名不存在");
			return result;
		}
		
		if (isNull(password)) {
			result.setResultCode(2);
			result.setResultMessage("密码不正确");
			return result;
		}
		
		User user = userDao.find(User.class, "account", account);
		
		if (user == null) {
			result.setResultCode(1);
			result.setResultMessage("用户名不存在");
			return result;
		}
		
		String salt = user.getSalt();
		String pw = DigestUtils.md5Hex(password);
		pw = pw + salt;
		pw = DigestUtils.md5Hex(pw);
		
		if (pw.equals(user.getPassword())) {
			result.setResultCode(0);
			result.setResultMessage(String.valueOf(user.getId()));
		} else {
			result.setResultCode(2);
			result.setResultMessage("密码不正确");
		}
		
		return result;
	}

	@Override
	public final ResultVo modifyPassword(final UserVo userVo,
			final String oldPassword,
			final String password1,
			final String password2) {
		ResultVo loginResult = login(userVo.getAccount(), oldPassword);
		ResultVo result = new ResultVo();
		if (loginResult.getResultCode() != 0) {
			result.setResultCode(1);
			result.setResultMessage("旧密码不正确");
			return result;
		}
		
		if (isNull(password1) || isNull(password2)
				|| !password1.equals(password2)) {
			result.setResultCode(REPEAT_CODE);
			result.setResultMessage("密码重复不同");
			return result;
		}
		
		if (password1.length() < MIN_PASSWORD_LENGTH) {
			result.setResultCode(LENGTH_CODE);
			result.setResultMessage("密码长度小于" + MIN_PASSWORD_LENGTH);
			return result;
		}

		SecureRandom random = new SecureRandom();
		String salt = (new BigInteger(MD5_OPTION, random)).toString();
		String password = DigestUtils.md5Hex(password1);
		password = password + salt;
		password = DigestUtils.md5Hex(password);
		
		User user = userDao.load(User.class, userVo.getId());
		user.setSalt(salt);
		user.setPassword(password);
		userDao.save(user);
		
		result.setResultCode(0);
		result.setResultMessage("修改成功");
		return result;
	}

	@Override
	public final ResultVo modify(final UserVo userVo) {
		User user = userDao.load(User.class, userVo.getId());
		ResultVo result = new ResultVo();
		
		if (user == null) {
			result.setResultCode(1);
			result.setResultMessage("修改失败");
			return result;
		}
		
		user.setBirthday(userVo.getBirthday());
		user.setEmail(userVo.getEmail());
		user.setIcon(userVo.getIconPath());
		user.setMale(userVo.getMale());
		user.setName(userVo.getName());
		user.setScore(userVo.getScore());
		
		user.getRoles().clear();
		Role role = roleDao.load(Role.class, userVo.getRole());
		user.getRoles().add(role);
		
		Iterator<AddressVo> iAddressVo = userVo.getAddressVoList().iterator();
		while (iAddressVo.hasNext()) {
			AddressVo addressVo = iAddressVo.next();
			if (addressVo.getId() == 0) {
				Address address = new Address();
				address.setPeople(addressVo.getPeople());
				address.setPhone(addressVo.getPhone());
				address.setPlaceCode(addressVo.getPlaceCode());
				address.setPlaceName(addressVo.getPlaceName());
				address.setUser(user);
				addressDao.save(address);
			} else {
				Address address =
						addressDao.load(Address.class, addressVo.getId());
				address.setPeople(addressVo.getPeople());
				address.setPhone(addressVo.getPhone());
				address.setPlaceCode(addressVo.getPlaceCode());
				address.setPlaceName(addressVo.getPlaceName());
				addressDao.update(address);
			}
		}
		
		result.setResultCode(0);
		result.setResultMessage("修改成功");
		return result;
	}

	@Override
	public final UserVo userInfo(final int userId) {
		User user = userDao.load(User.class, userId);
		
		if (user == null) {
			return null;
		}
		
		UserVo userVo = new UserVo();
		userVo.setAccount(user.getAccount());
		userVo.setBirthday(user.getBirthday());
		userVo.setEmail(user.getEmail());
		userVo.setIconPath(user.getIcon());
		userVo.setId(user.getId());
		userVo.setMale(user.getMale());
		userVo.setName(user.getName());
		Iterator<Role> iRole = user.getRoles().iterator();
		while (iRole.hasNext()) {
			Role role = iRole.next();
			userVo.setRole(role.getId());
		}
		userVo.setScore(user.getScore());
		
		Iterator<Address> iAddress = user.getAddressSet().iterator();
		List<AddressVo> addressVoList = new ArrayList<AddressVo>();
		while (iAddress.hasNext()) {
			Address address = iAddress.next();
			AddressVo addressVo = new AddressVo();
			addressVo.setId(address.getId());
			addressVo.setPeople(address.getPeople());
			addressVo.setPhone(address.getPhone());
			addressVo.setPlaceCode(address.getPlaceCode());
			addressVo.setPlaceName(address.getPlaceName());
			addressVoList.add(addressVo);
		}
		userVo.setAddressVoList(addressVoList);
		
		return userVo;
	}

	@Override
	public final ResultVo favour(final int userId, final int goodId) {
		ResultVo result = new ResultVo();
		
		ResultVo collect = isFavour(userId, goodId);
		if (collect.getResultCode() == 0) {
			result.setResultCode(1);
			result.setResultMessage("收藏失败");
		} else {
			User user = userDao.load(User.class, userId);
			Good good = goodDao.load(Good.class, goodId);
			user.getCollections().add(good);
			userDao.update(user);
			result.setResultCode(0);
			result.setResultMessage("收藏成功");
		}

		return result;
	}

	@Override
	public final List<FavouriteVo> favourites(final int userId) {
		List<FavouriteVo> favouriteVoList = new ArrayList<FavouriteVo>();
		
		User user = userDao.load(User.class, userId);
		if (user != null) {
			Set<Good> collections = user.getCollections();
			Iterator<Good> i = collections.iterator();
			while (i.hasNext()) {
				Good good = i.next();
				FavouriteVo vo = new FavouriteVo();
				vo.setGoodId(good.getId());
				vo.setUserId(user.getId());
				favouriteVoList.add(vo);
			}
		}
		
		return favouriteVoList;
	}

	@Override
	public final ResultVo isFavour(final int userId, final int goodId) {
		ResultVo result = new ResultVo();
		
		List<FavouriteVo> favouriteVoList = favourites(userId);
		Iterator<FavouriteVo> i = favouriteVoList.iterator();
		while (i.hasNext()) {
			FavouriteVo vo = i.next();
			if (vo.getGoodId() == goodId) {
				result.setResultCode(0);
				result.setResultMessage("已收藏");
				return result;
			}
		}

		result.setResultCode(1);
		result.setResultMessage("未收藏");
		return result;
	}

	@Override
	public final ResultVo unFavour(final int userId, final int goodId) {
		ResultVo result = new ResultVo();
		if (isFavour(userId, goodId).getResultCode() == 0) {
			User user = userDao.load(User.class, userId);
			Iterator<Good> i = user.getCollections().iterator();
			while (i.hasNext()) {
				Good good = i.next();
				if (good.getId() == goodId) {
					i.remove();
				}
			}
			result.setResultCode(0);
			result.setResultMessage("取消成功");
		} else {
			result.setResultCode(1);
			result.setResultMessage("取消失败");
		}
		return result;
	}

}
