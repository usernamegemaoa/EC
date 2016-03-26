package njuse.ec.action;

import java.util.List;

import njuse.ec.model.Product;
import njuse.ec.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IndexAction extends BaseAction {

	private static final long serialVersionUID = -9159953317772348733L;

	@Autowired
	private ProductService productService;
	public List<Product> products;
	
	public String execute() {
		products = productService.getAllProduct();
		return SUCCESS;
	}
	
}
