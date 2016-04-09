package njuse.ec.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import njuse.ec.dao.CastDAO;
import njuse.ec.dao.OrderDAO;
import njuse.ec.model.OrderInfo;
import njuse.ec.model.Cast;
import njuse.ec.model.Order;
import njuse.ec.vo.CastVo;

public class OrderDAOImpl implements OrderDAO {
	@Autowired
	protected SessionFactory sessionFactory;
	private CastDAO castDao;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean creatOrder(int shop_id, List<Cast> casts,Order order) {//创建订单
		boolean success=true;
		order.setUser_id(casts.get(0).getUser_id());
		Date now=new Date();
		order.setTime(now);
		order.setShop_id(shop_id);
		order.setIs_read(false);
		order.setState(1);
		order.setExpress_number(null);
		Session session=getSession();
		int order_id=0;
		 try{
			   order_id=(int) session.save(order);
		 }catch(Exception e){
			   success=false;//订单创建时出错
		   }
		 if(success){
			 List<OrderInfo> orderInfo=new ArrayList<OrderInfo>();
			 for(int i = 0; i < casts.size(); i++){//将cast转化为orderinfo
				 Cast cast=casts.get(i);
				 OrderInfo singleInfo=new OrderInfo();
				 singleInfo.setColor(cast.getColor());
				 singleInfo.setGood_id(cast.getGood_id());
				 singleInfo.setOrder_id(order_id);
				 singleInfo.setPrice(castDao.getPrice(cast));
				 singleInfo.setQuantity(cast.getQuantity());
				 singleInfo.setSize(cast.getSize());
				 orderInfo.add(singleInfo);
			 }
			 try{
				 for (int i = 0; i < orderInfo.size(); i++) {
						session.save(orderInfo.get(i));
						if (i % 20 == 0) {
							session.flush();
							session.clear();
						}
					}
					session.flush();
					session.clear();
					session.close();
			 }catch(Exception e){
				   success=false;//订单创建时出错
			   }
		 }
		return success;
	}

	@Override
	public boolean cancelOrder(Order order) {
		boolean success=true;
		int id=order.getId();
		String hql="delete from order where id="+id+"";
		Session session=getSession();
		 try{
			   session.createSQLQuery(hql);
		   }catch(Exception e){
			   success=false;//订单删除时出错
		   }
		return success;
	}

	@Override
	public boolean payOrder(Order order) {
		boolean success=true;
		int id=order.getId();
		String hql="update order set state=2 where id="+id+"";
		Session session=getSession();
		 try{
			   session.createSQLQuery(hql);
		   }catch(Exception e){
			   success=false;//修改订单状态时出错
		   }
		return success;
	}

	@Override
	public boolean shipOrder(Order order) {
		boolean success=true;
		int id=order.getId();
		String express_number=order.getExpress_number();
		String hql="update order set express_number="+express_number+",state=3 where id="+id+"";
		Session session=getSession();
		try{
			session.createSQLQuery(hql);
		}catch(Exception e){
			   success=false;//修改订单状态时出错
		   }
		return success;
	}

	@Override
	public boolean receiptOrder(Order order) {
		boolean success=true;
		int id=order.getId();
		String hql="update order set state=4 where id="+id+"";
		Session session=getSession();
		try{
			session.createSQLQuery(hql);
		}catch(Exception e){
			   success=false;//修改订单状态时出错
		   }
		return success;
	}

	@Override
	public boolean refundOrder(Order order) {
		boolean success=true;
		int id=order.getId();
		String hql="update order set state=5 where id="+id+"";
		Session session=getSession();
		try{
			session.createSQLQuery(hql);
		}catch(Exception e){
			   success=false;//修改订单状态时出错
		   }
		return success;
	}

	@Override
	public boolean refundMoney(Order order) {
		boolean success=true;
		int id=order.getId();
		String hql="update order set state=6 where id="+id+"";
		Session session=getSession();
		try{
			session.createSQLQuery(hql);
		}catch(Exception e){
			   success=false;//修改订单状态时出错
		   }
		return success;
	}

	@Override
	public List<Order> viewOrder(int userId) {
		String hql="select * from order where user_id="+userId+"";
		Session session=getSession();
		return session.createSQLQuery(hql).list();
	}

	@Override
	public List<OrderInfo> getOrderInfo(Order order) {
		int id=order.getId();
		String hql="select * from order where order_id="+id+"";
		Session session=getSession();
		return session.createSQLQuery(hql).list();
	}

}
