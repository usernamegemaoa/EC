package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.PlaceDao;
import njuse.ec.model.Place;

/**
 * place dao.
 * @author 丞
 *
 */
@Repository
public class PlaceDaoImpl implements PlaceDao {

	/**
	 * hibernate session factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public final List<Place> getProvince() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Place WHERE placeCode % 10000 = 0";
		Query query = session.createQuery(hql);
		List<Place> places = query.list();
		return places;
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Place> getCity(final int provinceId) {
		int id = provinceId / 10000;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Place where placeCode LIKE '";
		hql += id;
		hql += "%' AND MOD(placeCode,10000) <> 0 and MOD(placeCode,100) = 0";
		Query query = session.createQuery(hql);
		List<Place> places = query.list();
		return places;
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Place> getDistrict(final int cityId) {
		int id = cityId / 100;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Place where placeCode LIKE '";
		hql += id + "%' and MOD(placeCode,";
		hql += cityId + ") < 100 and MOD(placeCode,";
		hql += cityId + ") > 0";
		Query query = session.createQuery(hql);
		List<Place> places = query.list();
		return places;
	}

}
