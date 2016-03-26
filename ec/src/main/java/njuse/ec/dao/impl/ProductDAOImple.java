package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.ProductDAO;
import njuse.ec.model.Product;

@Repository
public class ProductDAOImple implements ProductDAO{

	@Autowired
	protected SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Product> getList() {
		String hql = "select * from product";
		Session session = getSession();
		return session.createSQLQuery(hql).list();
	}

}
