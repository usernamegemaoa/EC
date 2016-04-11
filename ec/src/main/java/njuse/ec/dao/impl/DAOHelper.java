package njuse.ec.dao.impl;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DAOHelper {
	/**
	 * sessionFactory.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 获取一个session.
	 * @return session
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public final List<T> find(Class c, String column, String value) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("FROM ");
			stringBuilder.append(c.getName());
			stringBuilder.append(" AS u WHERE u.");
			stringBuilder.append(column);
			stringBuilder.append(" = ?");
			String hql = stringBuilder.toString();
			Query query = session.createQuery(hql);
			query.setString(0, value);
			List<c> list = query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
