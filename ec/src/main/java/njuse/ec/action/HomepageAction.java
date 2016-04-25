package njuse.ec.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.GoodService;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.SimpleGoodVo;

@Repository
public class HomepageAction extends BaseAction {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 392837307842434699L;

	@Autowired
	private GoodService goodService;

	private int page;
	
	private List<SimpleGoodVo> latestGoods;
	
	private List<KindVo> fatherKinds;
	
	private int totalPage;
	
	public final int getPage() {
		return page;
	}

	public final void setPage(int page) {
		this.page = page;
	}

	public final List<SimpleGoodVo> getLatestGoods() {
		return latestGoods;
	}

	public final void setLatestGoods(List<SimpleGoodVo> latestGoods) {
		this.latestGoods = latestGoods;
	}

	public final List<KindVo> getFatherKinds() {
		return fatherKinds;
	}

	public final void setFatherKinds(List<KindVo> fatherKinds) {
		this.fatherKinds = fatherKinds;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String execute(){
		latestGoods = goodService.getLatestGood(page);
		totalPage = goodService.getLatestGoodPages();
		fatherKinds = goodService.getFatherKind();
		return "success";
	}
}
