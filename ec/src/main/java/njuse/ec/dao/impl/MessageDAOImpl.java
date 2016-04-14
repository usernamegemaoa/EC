package njuse.ec.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.MessageDAO;
import njuse.ec.model.Message;

@Repository
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
	public boolean addMessage(Message message){
		   boolean result=true;
		   Session session=getSession();
		   try{
			   session.save(message);
			   session.flush();
		   }catch(Exception e){
			   result=false;
		   }
		   return result;
	}
	
	@Override
	public boolean readMessage(Message message){
		   boolean result=true;
		   message.setIs_read(true);
		   Session session=getSession();
		   try{
			   session.update(message);
			   session.flush();
		   }catch(Exception e){
			   result=false;
		   }
		   return result;
	}
}
