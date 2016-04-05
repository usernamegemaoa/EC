package njuse.ec.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import njuse.ec.dao.MessageDAO;
import njuse.ec.model.Message;
import njuse.ec.vo.MessageVo;

public class MessageDAOImpl implements MessageDAO {

	@Autowired
	protected SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Message> getUnReadMessage(int userId){
		String hql="select * from message where user_id="+userId+" and is_read=false ";
		Session session=getSession();
		return session.createSQLQuery(hql).list();
		
	}

	@Override
	public List<Message> getAllMessage(int userId) {
		String hql="select * from message where user_id="+userId+"";
		Session session=getSession();
		return session.createSQLQuery(hql).list();
	}
	
	@Override
	public boolean addMessage(MessageVo message){
		   boolean result=true;
		   int userId=message.getUserId();              
		   String content=message.getMessage();
		   boolean is_read=message.isRead();
		   Date time=message.getTime();
		   String hql="inesrt into message (uer_id,is_read,content,time) values("+userId+","+content+","+is_read+","+time+")";
		   Session session=getSession();
		   try{
			   session.createSQLQuery(hql);
		   }catch(Exception e){
			   result=false;
		   }
		   return result;
	}
	
	@Override
	public boolean readMessage(MessageVo message){
		   boolean result=true;
		   int id=message.getId();
		   String hql="update message set is_read=true where id="+id+"";
		   Session session=getSession();
		   try{
			   session.createSQLQuery(hql);
		   }catch(Exception e){
			   result=false;
		   }
		   return result;
	}
}
