package njuse.ec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.ProductDAO;
import njuse.ec.model.Product;
import njuse.ec.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;

	@Override
	public List<Product> getAllProduct() {
		return productDao.getList();
	}

}
