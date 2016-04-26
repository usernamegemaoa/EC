package njuse.ec.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.model.Stock;
import njuse.ec.service.CastService;
import njuse.ec.service.GoodService;
import njuse.ec.service.UserService;
import njuse.ec.vo.CastVo;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.SimpleGoodVo;
import njuse.ec.vo.StockVo;
import njuse.ec.vo.UserVo;

@Repository
public class GoodInfoAction extends BaseAction {

	private static final long serialVersionUID = -9164312800576735203L;

	@Autowired
	private GoodService goodService;
	@Autowired
	private UserService userService;
	@Autowired
	private CastService castService;
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
	private int id;
	private String img;
	private String stockIdList;
	private String numList;


	private Map<String,Object> jsonResult;

	public final String execute() {
		return SUCCESS;
	}

	public final String getGoodInfo() {
		goodVo = goodService.getDetailGood(goodId);
		List<SimpleGoodVo> allHotGood = goodService.getHotGood(goodId);
		hotGood = new ArrayList<SimpleGoodVo>();
		for (int i = 0; i < allHotGood.size(); i++) {
			hotGood.add(allHotGood.get(i));
			if (hotGood.size() >= 3) {
				break;
			}
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
	
	public final String favourite(){
		int userId=0;
		goodId=this.goodId;
		jsonResult=new HashMap<String,Object>();
		if (getSession().containsKey("userId")) {
		userId = (int) getSession().get("userId");}
		ResultVo resultVo=userService.favour(userId, goodId);
		jsonResult.put("resultMessage", resultVo.getResultMessage());
		System.out.println(resultVo.getResultMessage());
		return SUCCESS;
	}

	public final String addPlan(){
		int userId=0;
		jsonResult=new HashMap<String,Object>();
		ArrayList<ResultVo> resultList=new ArrayList<ResultVo>();
		if (getSession().containsKey("userId")) {
		userId = (int) getSession().get("userId");}
		//System.out.println(stockIdList);
		//System.out.println(numList);
		String[] stockId=stockIdList.split(",");
		String[] numListSplit=numList.split(",");
		ArrayList<Integer> allStock=new ArrayList<Integer>();
		ArrayList<Integer> allNum=new ArrayList<Integer>();
		//System.out.println(stockId.length);
		//System.out.println(numList.length);
		for(int i=0;i<stockId.length-1;i++){
			int thisStockId=Integer.parseInt(stockId[i]);
			allStock.add(thisStockId);
			int thisNum=Integer.parseInt(numListSplit[i]);
			allNum.add(thisNum);
		}
		for(int k=0;k<allStock.size();k++){
			CastVo cast=new CastVo();
			cast.setStockId(allStock.get(k));
			cast.setNum(allNum.get(k));
			cast.setUserId(userId);
			resultList.add(castService.addCast(userId, cast));
		}
		jsonResult.put("resultMessage", resultList.get(0));
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



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getStockIdList() {
		return stockIdList;
	}

	public void setStockIdList(String stockIdList) {
		this.stockIdList = stockIdList;
	}

	public String getNumList() {
		return numList;
	}

	public void setNumList(String numList) {
		this.numList = numList;
	}



}
