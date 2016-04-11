package njuse.ec.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.StockDAO;
import njuse.ec.model.Stock;

/**
 * 库存DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class StockDAOImpl implements StockDAO {
	
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

	@Override
	public final void addStock(final Stock stock) {
		try {
			Session session = getSession();
			session.save(stock);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void deleteStock(final Stock stock) {
		try {
			Session session = getSession();
			session.delete(stock);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void modifyStock(final Stock stock) {
		try {
			Session session = getSession();
			session.update(stock);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<Stock> getStock(final int stockId) {
		String hql = "select * from stock where id = " + stockId + ";";
		Session session = getSession();
		try {
			return session.createQuery(hql).list();
		} catch (Exception e) {
			return null;
		}
	}

}
