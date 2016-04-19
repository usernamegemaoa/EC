package njuse.ec.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.GoodService;
import njuse.ec.vo.SimpleGoodVo;

@Repository
public class SearchAction extends BaseAction {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 7322433416953858271L;

	@Autowired
	private GoodService goodService;
	
	private String search;
	
	private List<SimpleGoodVo> goodList;
	
}
