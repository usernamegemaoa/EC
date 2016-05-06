package njuse.ec.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.CastService;
import njuse.ec.service.OrderService;
import njuse.ec.vo.CastVo;
import njuse.ec.vo.GoodElement;
import njuse.ec.vo.OrderStatus;
import njuse.ec.vo.OrderVo;

@Repository
public class MyCastAction extends BaseAction {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 163048096722316521L;
	
	@Autowired
	private CastService castService;
	
	@Autowired
	private OrderService orderService;
	
	
	private String castStr;
	
	private int orderId;
	
	private Map<String, Object> jsonResult = new HashMap<>();
	
	private int userId;
	
	private List<CastVo> casts;
	
	private List<GoodElement> castElement;

	public final int getUserId() {
		return userId;
	}

	public final void setUserId(int userId) {
		this.userId = userId;
	}

	public final List<CastVo> getCasts() {
		return casts;
	}

	public final void setCasts(List<CastVo> casts) {
		this.casts = casts;
	}
	
	public final List<GoodElement> getCastElement() {
		return castElement;
	}

	public final void setCastElement(List<GoodElement> castElement) {
		this.castElement = castElement;
	}

	public final String getCastStr() {
		return castStr;
	}

	public final void setCastStr(String castStr) {
		this.castStr = castStr;
	}
	
	public String execute() {
		castElement = castService.getCastElement(userId);
		return "success";
	}

	public String createOrder() {
		System.out.println(castStr);
		List<CastVo> cast = convertToCast(castStr);
		if (!cast.isEmpty()) {
			OrderVo order = new OrderVo();
			order.setStatus(OrderStatus.WaitPay);
			orderId = Integer.parseInt((orderService.creatOrder(userId, cast, order)).getResultMessage());
			jsonResult.put("code", 1);
			jsonResult.put("orderId", orderId);
		} else {
			jsonResult.put("code", 0);
			System.out.println("fuck null");
		}
		return SUCCESS;
	}
	
	private List<CastVo> convertToCast(String s){
		List<CastVo> castList = new ArrayList<CastVo>();
		if(!s.equals("")){
			String str[] = s.split(" ");
			for(int i = 0; i < str.length; i++){
				String key[] = str[i].split(":");
				CastVo cast = castService.getById(Integer.parseInt(key[0]));
				cast.setNum(Integer.parseInt(key[1]));
				castList.add(cast);
			}
		}
		return castList;
	}

	public final Map<String, Object> getJsonResult() {
		return jsonResult;
	}

}
