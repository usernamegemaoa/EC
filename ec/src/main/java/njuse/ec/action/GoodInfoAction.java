package njuse.ec.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.GoodService;
import njuse.ec.vo.GoodVo;

@Repository
public class GoodInfoAction extends BaseAction{

	private static final long serialVersionUID = -9164312800576735203L;
	
	@Autowired
	private GoodService goodService;
	
	private GoodVo goodVo;
	private String[] imgs;
 
	private final String getGoodInfo(int goodId){
		goodVo=goodService.getDetailGood(goodId);
		return "GetGoodInfoSuccess";
	}
	
	private final String getGoodImgs(){
		imgs=goodVo.getImgs();
		return "GetGoodImgsSuccess";
	}

	public GoodVo getGoodVo() {
		return goodVo;
	}

	public void setGoodVo(GoodVo goodVo) {
		this.goodVo = goodVo;
	}

	public String[] getImgs() {
		return imgs;
	}
	public void setImgs(String[] imgs) {
		this.imgs = imgs;
	}
}
