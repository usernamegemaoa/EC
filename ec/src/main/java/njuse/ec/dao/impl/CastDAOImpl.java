package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.CastDAO;
import njuse.ec.model.Cast;
import njuse.ec.model.OrderInfo;

@Repository
public class CastDAOImpl implements CastDAO{

	@Autowired
	protected SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int getShopId(Cast cast) {
		int good_id=cast.getGood_id();
		String hql="select shop_id from good where id="+good_id+"";
		Session session=getSession();
		List result= session.createSQLQuery(hql).list();
		int shop_id=(int) result.get(0);

		return shop_id;
	}
	
	@Override
	public int getPrice(Cast cast){
		int good_id=cast.getGood_id();
		String hql="select price from good where id="+good_id+"";
		Session session=getSession();
		List result= session.createSQLQuery(hql).list();
		int price=(int) result.get(0);
		return price;
	}


}
