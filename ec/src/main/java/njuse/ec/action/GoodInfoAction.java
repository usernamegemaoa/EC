package njuse.ec.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.model.Stock;
import njuse.ec.service.GoodService;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.StockVo;

@Repository
public class GoodInfoAction extends BaseAction{

	private static final long serialVersionUID = -9164312800576735203L;
	
	@Autowired
	private GoodService goodService;
	
	private GoodVo goodVo;
	private ArrayList<String> imgs;
	private String name;
	private double price;
	private String description;
	private String return_info;
	private String deliver_info;
	private Stock stock;
	private String color;
	
 
	private final String getGoodInfo(int goodId){
		goodVo=goodService.getDetailGood(goodId);
		return "GetGoodInfoSuccess";
	}
	
	private final String getGoodImgs(){
		imgs=goodVo.getImgs();
		return "GetGoodImgsSuccess";
	}
	
	private final String getGoodName(){
		name=goodVo.getName();
		return "GetGoodNameSuccess";
	}
	
	private final String getGoodPrice(){
		price=goodVo.getPrice();
		return "GetGoodPriceSuccess";
	}
	
	private final String getGoodDescription(){
		description=goodVo.getDescription();
		return "GetGoodDescriptionSuccess";
	}
	
	private final String getReturnInfo(){
		return_info=goodVo.getReturnInfo();
		return "GetGoodReturnInfoSuccess";
	}
	
	private final String getdeliverInfo(){
		deliver_info=goodVo.getDeliverInfo();
		return "GetGooddeliverInfoSuccess";
	}
	
	private final String getStock(int goodId){
		return "Success1";
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
}
