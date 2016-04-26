package njuse.ec.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.FileService;
import njuse.ec.service.GoodService;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.StockVo;

/**
 * 添加商品页面.
 * 
 * @author 丞
 *
 */
@Repository
public class AddGoodAction extends BaseAction {

	/**
	 * 序列化id.
	 */
	private static final long serialVersionUID = -3227341563805849003L;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private GoodService goodService;

	//接收数据
	private String name;
	private String number;
	private double price;
	private int father;
	private int son;
	private List<File> uploads = new ArrayList<File>();
	private List<String> uploadFileNames = new ArrayList<String>();
	private List<String> uploadContentTypes = new ArrayList<String>();
	private File mainpic;
	private String mainpicFileName;
	private String mainpicContentType;
	private String description;
	private String deliverInfo;
	private String returnInfo;
	private List<String> size;
	private List<String> color;
	private List<Integer> quantity;
	
	//jsp传出数据
	private List<KindVo> fatherKind;
	private List<KindVo> sonKind;
	
	private Map<String, Object> jsonResult;

	@Override
	public final String execute() {
		fatherKind = goodService.getFatherKind();
		sonKind = goodService.getSonKind(fatherKind.get(0));
		return SUCCESS;
	}

	/**
	 * 添加新商品.
	 * 
	 * @return 页面
	 */
	public final String addInfo() {
		GoodVo goodVo = new GoodVo();
		goodVo.setName(name);
		goodVo.setPrice(price);
		goodVo.setKindId(son);
		goodVo.setTime(new Date());
		goodVo.setSellerId(123);
		goodVo.setGoodNum(number);
		goodVo.setDescription(description);
		goodVo.setDeliverInfo(deliverInfo);
		goodVo.setReturnInfo(returnInfo);
		ArrayList<String> imgs = new ArrayList<String>();
		for (int i = 0; i < uploads.size(); i++) {
			File file = uploads.get(i);
			String fileName = uploadFileNames.get(i);
			ResultVo result = fileService.upload(file, fileName);
			if (result.getResultCode() == 0) {
				imgs.add(result.getResultMessage());
			} else {
				System.out.println("AddGoodAction");
				System.out.println(result.getResultMessage());
			}
		}
		goodVo.setImgs(imgs);
		ResultVo mainResult = fileService.upload(mainpic, mainpicFileName); 
		String mainPath = mainResult.getResultMessage();
		goodVo.setMainPic(mainPath);
		
		List<StockVo> stocks = new ArrayList<StockVo>();
		for (int i = 0; i < size.size(); i++) {
			StockVo stock = new StockVo();
			stock.setSize(size.get(i));
			stock.setColor(color.get(i));
			stock.setQuantity(quantity.get(i));
			stocks.add(stock);
		}
		
		goodService.addGood(goodVo, stocks);
		
		return SUCCESS;
	}
	
	public final String getSon() {
		jsonResult = new HashMap<String, Object>();
		KindVo fatherVo = new KindVo();
		fatherVo.setKindId(father);
		List<KindVo> sons = goodService.getSonKind(fatherVo);
		jsonResult.put("sonList", sons);
		return SUCCESS;
	}

	
	//get set
	public List<File> getUpload() {
		return this.uploads;
	}

	public void setUpload(List<File> uploads) {
		this.uploads = uploads;
	}

	public List<String> getUploadFileName() {
		return this.uploadFileNames;
	}

	public void setUploadFileName(List<String> uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

	public List<String> getUploadContentType() {
		return this.uploadContentTypes;
	}

	public void setUploadContentType(List<String> contentTypes) {
		this.uploadContentTypes = contentTypes;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public final void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public final void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @param father
	 *            the father to set
	 */
	public final void setFather(int father) {
		this.father = father;
	}

	/**
	 * @param son
	 *            the son to set
	 */
	public final void setSon(int son) {
		this.son = son;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param deliverInfo
	 *            the deliverInfo to set
	 */
	public final void setDeliverInfo(String deliverInfo) {
		this.deliverInfo = deliverInfo;
	}

	/**
	 * @param returnInfo
	 *            the returnInfo to set
	 */
	public final void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public final void setSize(List<String> size) {
		this.size = size;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public final void setColor(List<String> color) {
		this.color = color;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public final void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the fatherKind
	 */
	public final List<KindVo> getFatherKind() {
		return fatherKind;
	}

	/**
	 * @return the jsonResult
	 */
	public final Map<String, Object> getJsonResult() {
		return jsonResult;
	}

	/**
	 * @return the sonKind
	 */
	public final List<KindVo> getSonKind() {
		return sonKind;
	}

	/**
	 * @param mainpic the mainpic to set
	 */
	public final void setMainpic(File mainpic) {
		this.mainpic = mainpic;
	}

	/**
	 * @param mainpicFileName the mainpicFileName to set
	 */
	public final void setMainpicFileName(String mainpicFileName) {
		this.mainpicFileName = mainpicFileName;
	}

	/**
	 * @param mainpicContentType the mainpicContentType to set
	 */
	public final void setMainpicContentType(String mainpicContentType) {
		this.mainpicContentType = mainpicContentType;
	}

}
