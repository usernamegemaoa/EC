package njuse.ec.action;

import java.util.List;

import njuse.ec.model.Product;
import njuse.ec.service.FileService;
import njuse.ec.service.ProductService;
import njuse.ec.service.UserService;
import njuse.ec.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IndexAction extends BaseAction {

	private static final long serialVersionUID = -9159953317772348733L;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	public List<Product> products;
	
	private String path;
	
	/**
	 * @return the path
	 */
	public final String getPath() {
		return path;
	}
	
	@Override
	public final String execute() {
		products = productService.getAllProduct();
		if (getSession().containsKey("userId")) {
			int userId = (int) getSession().get("userId");
			UserVo vo = userService.userInfo(userId);
			path = "user name:" + vo.getAccount();
			path += " user ID:" + vo.getId();
		} else {
			path = "未登录";
		}
		return SUCCESS;
	}
	
	
}
