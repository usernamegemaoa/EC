package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import njuse.ec.service.CastService;
import njuse.ec.vo.CastVo;
import njuse.ec.vo.ResultVo;

/**
 * 进货单服务实现.
 * @author 阳
 *
 */
@Service
public class CastServiceImpl implements CastService {

	@Override
	public final List<CastVo> getMyCast(final int userId) {
		List<CastVo> myCast = new ArrayList<CastVo>();
		return myCast;
	}

	@Override
	public final ResultVo addCast(final int userId, final CastVo cast) {
		ResultVo addCastResult = new ResultVo();
		if (cast != null) {
			addCastResult.setResultCode(0);
			addCastResult.setResultMessage("进货单添加成功！");
		} else {
			addCastResult.setResultCode(1);
			addCastResult.setResultMessage("进货单添加失败！");
		}
		return addCastResult;
	}

	@Override
	public final ResultVo deleteCast(final int userId, final CastVo cast) {
		ResultVo deleteCastResult = new ResultVo();
		if (cast != null) {
			deleteCastResult.setResultCode(0);
			deleteCastResult.setResultMessage("进货单删除成功！");
		} else {
			deleteCastResult.setResultCode(1);
			deleteCastResult.setResultMessage("进货单删除失败！");
		}
		return deleteCastResult;
	}

	@Override
	public final ResultVo modifyCast(final int userId, final CastVo cast) {
		ResultVo modifyCastResult = new ResultVo();
		if (cast != null) {
			modifyCastResult.setResultCode(0);
			modifyCastResult.setResultMessage("进货单修改成功！");
		} else {
			modifyCastResult.setResultCode(1);
			modifyCastResult.setResultMessage("进货单修改失败！");
		}
		return modifyCastResult;
	}

}
