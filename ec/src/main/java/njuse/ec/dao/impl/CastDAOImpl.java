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
public class CastDAOImpl implements CastDAO {

	@Autowired
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public final int getShopId(final Cast cast) {
		int goodId = cast.getGood_id();
		String hql = "select shop_id from good where id=" + goodId + "";
		Session session = getSession();
		List result = session.createSQLQuery(hql).list();
		int shopId = (int) result.get(0);

		return shopId;
	}

	@Override
	public final int getPrice(final Cast cast) {
		int good_id = cast.getGood_id();
		String hql = "select price from good where id=" + good_id + "";
		Session session = getSession();
		List result = session.createSQLQuery(hql).list();
		int price = (int) result.get(0);
		return price;
	}

}
