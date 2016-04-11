package njuse.ec.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.UserDao;
import njuse.ec.model.User;

/**
 * userDao实现.
 * @author 丞
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	/**
	 * database session factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public final User find(final int userId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			return (User) session.get(User.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public final User find(final String account) {
		Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
		
		try {			
            StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("FROM ");
			stringBuilder.append(User.class.getName());
			stringBuilder.append(" AS u WHERE u.");
			stringBuilder.append("account");
			stringBuilder.append(" = ?");
			String hql = stringBuilder.toString();
			Query query = session.createQuery(hql);
			query.setString(0, account);
			List<User> user = new ArrayList<User>();
			for (Object o : query.list()) {
				user.add((User) o);
			}
			
			tx.commit();
			if ((user.size()) == 0) {
				return null;
			} else {
				return user.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
            tx.rollback();
            return null;
		} finally {
			session.close();
		}
	}

}
