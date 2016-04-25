package njuse.ec.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.GoodService;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.SimpleGoodVo;

@Repository
public class CategoryAction extends BaseAction {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 6675731613068356497L;

	@Autowired
	private GoodService goodService;
	
	private int kindId = 1;
	
	private int page = 0;
	
	private List<KindVo> fatherKinds;
	
	private List<KindVo> sonKinds;
	
	private List<SimpleGoodVo> goodsList;
	
	private KindVo fatherKind;
	
	private KindVo sonKind;
	
	private int fatherId;
	
	private int totalPage;

	public String execute(){	
		fatherKind = goodService.getKind(kindId);
		if(fatherKind.getFatherKind() == 0) {
			sonKind = goodService.getSonKind(fatherKind).get(0);
		} else {
			sonKind = fatherKind;
			fatherKind = goodService.getKind(sonKind.getFatherKind());
		}
		fatherKinds = goodService.getFatherKind();
		sonKinds = goodService.getSonKind(fatherKind);
		goodsList = goodService.getKindGood(sonKind, page);
//		System.out.print(goodsList.get(0).getMainPic());
		fatherId = fatherKind.getKindId();
		totalPage = goodService.getKindGoodPages(sonKind);
		return "success";
	}
	
	public final int getKindId() {
		return kindId;
	}

	public final void setKindId(int kindId) {
		this.kindId = kindId;
	}

	public final int getPage() {
		return page;
	}

	public final void setPage(int page) {
		this.page = page;
	}
	
	public final List<KindVo> getFatherKinds() {
		return this.fatherKinds;
	}

	public final void setFatherKinds(List<KindVo> fatherKinds) {
		this.fatherKinds = fatherKinds;
	}

	public final List<KindVo> getSonKinds() {
		return sonKinds;
	}

	public final void setSonKinds(List<KindVo> sonKinds) {
		this.sonKinds = sonKinds;
	}

	public final List<SimpleGoodVo> getGoodsList() {
		return goodsList;
	}

	public final void setGoodsList(List<SimpleGoodVo> goodsList) {
		this.goodsList = goodsList;
	}

	public final KindVo getFatherKind() {
		return fatherKind;
	}

	public final void setFatherKind(KindVo fatherKind) {
		this.fatherKind = fatherKind;
	}

	public final KindVo getSonKind() {
		return sonKind;
	}

	public final void setSonKind(KindVo sonKind) {
		this.sonKind = sonKind;
	}

	public final int getFatherId() {
		return fatherId;
	}

	public final void setFatherId(int fatherId) {
		this.fatherId = fatherId;
	}

	public final int getTotalPage() {
		return totalPage;
	}

	public final void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
