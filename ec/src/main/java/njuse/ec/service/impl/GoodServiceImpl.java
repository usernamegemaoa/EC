package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import njuse.ec.service.GoodService;
import njuse.ec.vo.CommentVo;
import njuse.ec.vo.ConsultVo;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.SimpleGoodVo;
import njuse.ec.vo.StockVo;

/**
 * 商品服务实现.
 * @author 阳
 *
 */
@Service
public class GoodServiceImpl implements GoodService {

	@Override
	public final List<KindVo> getFatherKind() {
		List<KindVo> fatherKind = new ArrayList<KindVo>();
		return fatherKind;
	}

	@Override
	public final List<KindVo> getSonKind(final KindVo kind) {
		List<KindVo> sonKind = new ArrayList<KindVo>();
		if (kind != null) {
			return sonKind;
		} else {
			return null;
		}
	}

	@Override
	public final int getLatestGoodPages() {
		return 0;
	}

	@Override
	public final List<SimpleGoodVo> getLatestGood(final int page) {
		List<SimpleGoodVo> latestGood = new ArrayList<SimpleGoodVo>();
		if (page >= 0) {
			return latestGood;
		} else {
			return null;
		}
	}

	@Override
	public final int getKindGoodPages(final KindVo kind) {
		if (kind != null) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public final List<SimpleGoodVo> 
	getKindGood(final KindVo kind, final int page) {
		List<SimpleGoodVo> kindGood = new ArrayList<SimpleGoodVo>();
		if ((kind != null) && (page >= 0)) {
			return kindGood;
		} else {
			return null;
		}
	}

	@Override
	public final int getSearchGoodPages(final String search) {
		return 0;
	}

	@Override
	public final List<SimpleGoodVo> 
	getSearchGood(final String search, final int page) {
		List<SimpleGoodVo> searchGood = new ArrayList<SimpleGoodVo>();
		if (page >= 0) {
			return searchGood;
		} else {
			return null;
		}
	}

	@Override
	public final GoodVo getDetailGood(final int goodId) {
		GoodVo detailGood = new GoodVo();
		return detailGood;
	}

	@Override
	public final List<SimpleGoodVo> getHotGood(final int goodId) {
		List<SimpleGoodVo> hotGood = new ArrayList<SimpleGoodVo>();
		return hotGood;
	}

	@Override
	public final ResultVo 
	addGood(final GoodVo goodVo, final List<StockVo> stockVos) {
		ResultVo addGoodResult = new ResultVo();
		if ((goodVo != null) && (stockVos != null)) {
			addGoodResult.setResultCode(0);
			addGoodResult.setResultMessage("商品添加成功！");
		} else {
			addGoodResult.setResultCode(1);
			addGoodResult.setResultMessage("商品添加失败！");
		}
		return addGoodResult;
	}

	@Override
	public final ResultVo 
	addGoodConsult(final int goodId, final ConsultVo consult) {
		ResultVo addGoodConsultResult = new ResultVo();
		if (consult != null) {
			addGoodConsultResult.setResultCode(0);
			addGoodConsultResult.setResultMessage("咨询添加成功！");
		} else {
			addGoodConsultResult.setResultCode(1);
			addGoodConsultResult.setResultMessage("咨询添加失败！");
		}
		return addGoodConsultResult;
	}

	@Override
	public final ResultVo 
	addGoodComment(final int goodId, final CommentVo comment) {
		ResultVo addGoodCommentResult = new ResultVo();
		if (comment != null) {
			addGoodCommentResult.setResultCode(0);
			addGoodCommentResult.setResultMessage("评论添加成功！");
		} else {
			addGoodCommentResult.setResultCode(1);
			addGoodCommentResult.setResultMessage("评论添加失败！");
		}
		return addGoodCommentResult;
	}

	@Override
	public final int getConsultPages(final int goodId) {
		return 0;
	}

	@Override
	public final int getCommentPages(final int goodId) {
		return 0;
	}

	@Override
	public final List<ConsultVo> 
	getConsults(final int goodId, final int pages) {
		List<ConsultVo> consults = new ArrayList<ConsultVo>();
		if (pages >= 0) {
			return consults;
		} else {
			return null;
		}
	}

	@Override
	public final List<CommentVo> 
	getComments(final int goodId, final int pages) {
		List<CommentVo> comments = new ArrayList<CommentVo>();
		if (pages >= 0) {
			return comments;
		} else {
			return null;
		}
	}

}
