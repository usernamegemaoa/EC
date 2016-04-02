package njuse.ec.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import njuse.ec.service.OrderService;
import njuse.ec.vo.CastVo;
import njuse.ec.vo.OrderVo;
import njuse.ec.vo.ResultVo;

/**
 * 订单模块.
 * @author 文
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public final ResultVo creatOrder(final int userId,
			final List<CastVo> casts) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

	@Override
	public final ResultVo cancelOrder(final int userId, final OrderVo order) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

	@Override
	public final ResultVo payOrder(final int userId, final OrderVo order) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

	@Override
	public final ResultVo shipOrder(final int storeId, final OrderVo order) {
		ResultVo result = new ResultVo();
		if (storeId < 0) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

	@Override
	public final ResultVo receiptOrder(final int userId, final OrderVo order) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

	@Override
	public final ResultVo refundOrder(final int userId, final OrderVo order) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

	@Override
	public final ResultVo refundMoney(final int userId, final OrderVo order) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(0);
		} else {
			result.setResultCode(1);
		}
		return result;
	}

}
