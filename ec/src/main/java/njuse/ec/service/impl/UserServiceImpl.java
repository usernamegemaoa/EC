package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import njuse.ec.service.UserService;
import njuse.ec.vo.FavouriteVo;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.UserVo;

/**
 * 用户模块实现.
 * @author 丞
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public final ResultVo register(final UserVo userVo,
			final String password1, final String password2) {
		ResultVo result = new ResultVo();
		if (userVo == null) {
			result.setResultCode(1);
			result.setResultMessage("注册失败");
		} else {
			result.setResultCode(0);
			result.setResultMessage("注册成功");
		}
		return result;
	}

	@Override
	public final ResultVo login(final String account, final String password) {
		ResultVo result = new ResultVo();
		if (account == null) {
			result.setResultCode(1);
			result.setResultMessage("登录失败");
		} else {
			result.setResultCode(0);
			result.setResultMessage("登录成功");
		}
		return result;
	}

	@Override
	public final ResultVo modifyPassword(final UserVo userVo,
			final String oldPassword,
			final String password1,
			final String password2) {
		ResultVo result = new ResultVo();
		if (userVo == null) {
			result.setResultCode(1);
			result.setResultMessage("修改失败");
		} else {
			result.setResultCode(0);
			result.setResultMessage("修改成功");
		}
		return result;
	}

	@Override
	public final ResultVo modify(final UserVo userVo) {
		ResultVo result = new ResultVo();
		if (userVo == null) {
			result.setResultCode(1);
			result.setResultMessage("修改失败");
		} else {
			result.setResultCode(0);
			result.setResultMessage("修改成功");
		}
		return result;
	}

	@Override
	public final UserVo userInfo(final int userId) {
		if (userId < 0) {
			return null;
		} else {
			return new UserVo();
		}
	}

	@Override
	public final ResultVo favour(final FavouriteVo favouriteVo) {
		ResultVo result = new ResultVo();
		if (favouriteVo == null) {
			result.setResultCode(1);
			result.setResultMessage("失败");
		} else {
			result.setResultCode(0);
			result.setResultMessage("成功");
		}
		return result;
	}

	@Override
	public final List<FavouriteVo> favourites(final int userId) {
		List<FavouriteVo> favouriteVoList = new ArrayList<FavouriteVo>();
		if (userId < 0) {
			return favouriteVoList;
		} else {
			favouriteVoList.add(new FavouriteVo());
			return favouriteVoList;
		}
	}

	@Override
	public final ResultVo isFavour(final int userId, final int goodId) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(1);
			result.setResultMessage("失败");
		} else {
			result.setResultCode(0);
			result.setResultMessage("成功");
		}
		return result;
	}

}
