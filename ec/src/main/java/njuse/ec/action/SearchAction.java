package njuse.ec.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.GoodService;
import njuse.ec.service.UserService;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.SimpleGoodVo;
import njuse.ec.vo.UserVo;

@Repository
public class SearchAction extends BaseAction {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 7322433416953858271L;

	@Autowired
	private GoodService goodService;
	
	@Autowired
	private UserService userService;
	
	private String userName;
	
	private int userId;
	
	private String search;
	
	private int page;
	
	private List<SimpleGoodVo> goodList;
	
	private List<KindVo> fatherKinds;
	
	private int totalPage;

	public final String getSearch() {
		return search;
	}

	public final void setSearch(String search) {
		this.search = search;
	}

	public final int getPage() {
		return page;
	}

	public final void setPage(int page) {
		this.page = page;
	}

	public final List<SimpleGoodVo> getGoodList() {
		return goodList;
	}

	public final void setGoodList(List<SimpleGoodVo> goodList) {
		this.goodList = goodList;
	}
	
	public final List<KindVo> getFatherKinds() {
		return fatherKinds;
	}

	public final void setFatherKinds(List<KindVo> fatherKinds) {
		this.fatherKinds = fatherKinds;
	}

	public final String getUserName() {
		return userName;
	}

	public final int getUserId() {
		return userId;
	}

	public final int getTotalPage() {
		return totalPage;
	}

	public final void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String execute(){
		if((search != null)&&(search.length() > 0)){
			if (getSession().containsKey("userId")) {
				int id = (int) getSession().get("userId");
				UserVo vo = userService.userInfo(id);
				userName = vo.getName();
				userId = vo.getId();
			} else {
				userId = 0;
				userName = "";
			}
			totalPage = goodService.getSearchGoodPages(search);
			goodList = goodService.getSearchGood(search, page);
			fatherKinds = goodService.getFatherKind();
			return "success";
		}
		else return "homepage";
		
	}
}
