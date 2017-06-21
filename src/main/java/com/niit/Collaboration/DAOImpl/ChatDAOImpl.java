package com.niit.Collaboration.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.ChatDAO;
import com.niit.Collaboration.model.Chat;

@Transactional
@Repository("chatDAO")
public class ChatDAOImpl implements ChatDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ChatDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Chat> list(String id) {
		return sessionFactory.getCurrentSession().createQuery("from Chat where user_id= '"+id+"' ").list(); 
	}

	public boolean save(Chat chat) {
		try {
			chat.setId(getMaxId() + 1);
			sessionFactory.getCurrentSession().save(chat);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Chat chat) {
		try {
			sessionFactory.getCurrentSession().delete(chat);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<Chat> getChatByFriend(String user_id,String friend_id) {
		
		String hql1 = "select user_id,friend_id,date_time,message from Chat where user_id='" + user_id + "' and friend_id = '"+friend_id+"'  ";

		/* + " union  " + */

		String hql2 = "select user_id,friend_id,date_time,message from Chat where user_id='" + friend_id + "' and friend_id = '"+user_id+"'  ";
		
		List<Chat> list1 = sessionFactory.openSession().createQuery(hql1).list();
		List<Chat> list2 = sessionFactory.openSession().createQuery(hql2).list();

		list1.addAll(list2);
       
		return list1;
		
	
	}
	

	private Integer getMaxId() {

		String hql = "select max(id) from Chat";
		Query query = sessionFactory.openSession().createQuery(hql);
		Integer maxID;
		try {
			
			maxID = (Integer) query.uniqueResult();
			if (maxID == null) {
				maxID = 100;
			}
		} catch (NullPointerException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}

		return maxID;

	}

	

}


/*package com.niit.Collaboration.DAOImpl;


import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Collaboration.DAO.ChatDAO;
import com.niit.Collaboration.model.Blog;
import com.niit.Collaboration.model.Chat;
import com.niit.Collaboration.model.User;

@Repository("chatDAO")
public class ChatDAOimpl implements ChatDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Chat> list(){
		String hql="from Chat c";
				Query query=sessionFactory.openSession().createQuery(hql);
		return query.list();
		
	}
	
	@Transactional
	public Chat get(String userID, Integer chatforumID) {
		String hql="select c from Chat c where c.userID="+"'"+userID+"'and c.id='"+chatforumID+"'";
		Query query=sessionFactory.openSession().createQuery(hql);
		
		return (Chat)query.list().get(0);
	}
	
	@Transactional
	public boolean update(Chat chat) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(chat);
			session.flush();
			return true;
		}catch(Exception e){
		e.printStackTrace();	
		return false;
		}
	}
	
	@Transactional	
	public boolean delete(int userID,BigDecimal chatforumID) {
		Chat chat=new Chat();
		chat.setId(userID);
		chat.setUserID(userID);
		Session session=sessionFactory.openSession();
		session.delete(chat);
		session.flush();
		return true;
	}
	
	@Transactional
	public boolean save(Chat chat){
		try{
			String hql="select chat_seq.nextval from dual";
			Query query=sessionFactory.getCurrentSession().createSQLQuery(hql);
	BigDecimal		maxID=(BigDecimal) query.uniqueResult();
			chat.setUserID(maxID.toString());
			Session session=sessionFactory.getCurrentSession();
			session.save(chat);
			session.flush();
		    return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean save(Chat chat) {
		try {
			sessionFactory.getCurrentSession().save(chat);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	public List<Chat> getChatByFriend(String userID,String friendID) {
		
		String hql1 = "select userID,friendID,dateTime,message from Chat where userID='" + userID + "' and friendID = '"+friendID+"'  ";

		 + " union  " + 

		String hql2 = "select userID,friendID,dateTime,message from Chat where userID='" + friendID + "' and friendID = '"+userID+"'  ";
		
		List<Chat> list1 = sessionFactory.openSession().createQuery(hql1).list();
		List<Chat> list2 = sessionFactory.openSession().createQuery(hql2).list();

		list1.addAll(list2);
       
		return list1;
		
	
	}
	public boolean save(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Chat get(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	private Integer getMaxId() {

		String hql = "select max(id) from Chat";
		Query query = sessionFactory.openSession().createQuery(hql);
		Integer maxID;
		try {
			
			maxID = (Integer) query.uniqueResult();
			if (maxID == null) {
				maxID = 100;
			}
		} catch (NullPointerException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}

		return maxID;

	}
}

*/