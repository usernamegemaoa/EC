package njuse.ec.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.model.Stock;
import njuse.ec.service.GoodService;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.SimpleGoodVo;
import njuse.ec.vo.StockVo;

@Repository
public class GoodInfoAction extends BaseAction {

	private static final long serialVersionUID = -9164312800576735203L;

	@Autowired
	private GoodService goodService;
	private GoodVo goodVo;
	private ArrayList<String> imgs;
	private String mainPic;
	private List<StockVo> stocks;
	private List<SimpleGoodVo> hotGood;// 同类热销
	private String hotPic;
	private String hotName;
	private String name;
	private double price;
	private String description;
	private String return_info;
	private String deliver_info;
	private String color;
	private int goodId;

	public final String execute() {
		return SUCCESS;
	}

	public final String getGoodInfo() {

		System.out.print("==========================");
		goodVo = goodService.getDetailGood(goodId);
		List<SimpleGoodVo> allHotGood = goodService.getHotGood(goodId);
		int k = allHotGood.size();
		if (k > 2) {
			k = 2;
		}
		hotGood = new ArrayList<SimpleGoodVo>();
		for (int i = 0; i < k; i++) {
			hotGood.add(allHotGood.get(i));
		}
		stocks = goodVo.getStocks();
		imgs = goodVo.getImgs();
		mainPic = goodVo.getMainPic();
		description = goodVo.getDescription();
		return_info = goodVo.getReturnInfo();
		deliver_info = goodVo.getDeliverInfo();
		price = goodVo.getPrice();
		System.out.print(mainPic);
		return SUCCESS;
	}

	public GoodVo getGoodVo() {
		return goodVo;
	}

	public void setGoodVo(GoodVo goodVo) {
		this.goodVo = goodVo;
	}

	public ArrayList<String> getImgs() {
		return imgs;
	}

	public void setImgs(ArrayList<String> imgs) {
		this.imgs = imgs;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GoodService getGoodService() {
		return goodService;
	}

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReturn_info() {
		return return_info;
	}

	public void setReturn_info(String return_info) {
		this.return_info = return_info;
	}

	public String getDeliver_info() {
		return deliver_info;
	}

	public void setDeliver_info(String deliver_info) {
		this.deliver_info = deliver_info;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public List<StockVo> getStocks() {
		return stocks;
	}

	public void setStocks(List<StockVo> stocks) {
		this.stocks = stocks;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMainPic() {
		return mainPic;
	}

	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}

	public List<SimpleGoodVo> getHotGood() {
		return hotGood;
	}

	public void setHotGood(List<SimpleGoodVo> hotGood) {
		this.hotGood = hotGood;
	}

	public String getHotName() {
		return hotName;
	}

	public void setHotName(String hotName) {
		this.hotName = hotName;
	}

	public String getHotPic() {
		return hotPic;
	}

	public void setHotPic(String hotPic) {
		this.hotPic = hotPic;
	}

}
