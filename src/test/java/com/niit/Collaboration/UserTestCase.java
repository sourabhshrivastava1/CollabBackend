package com.niit.Collaboration;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Collaboration.DAO.UserDAO;
import com.niit.Collaboration.model.User;

import junit.framework.Assert;

public class UserTestCase {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static User user;
	
	@Autowired  static UserDAO  userDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		 
	}
	
	
	/*
	@Test
	public void deleteUserTestCase()
	{
		boolean user =  userDAO.delete("sourabh");
		
		assertEquals("getUserTestCase", null, user);
		
	}*/
	/*@Test
	
	public void validateCredentialsTestCase()
	{
		
	boolean flag =	  userDAO.isValidCredentials("sourabh", "sourabh");
	
	Assert.assertEquals("validateCredentialsTestCase", true , flag);;
	;;;;;;;;
	;;;;;;;;;
		
	}*/
	
	


@Test
public void createUserTestCase(){
	
	user.setId("SAI");
	user.setName("SAI");
	user.setAddress("BHOPAL");
	user.setPassword("SAI");
	user.setRole("ADMIN");
	user.setMobile("7389616986");
	
	user.setEmail("SAI.shrivastav@gmail");
   // user.setLastSeenTime(new Date());
    //user.setStatus('Y');
   

	boolean flag = userDAO.saveOrupdate(user);
	
	
	
	assertEquals("createUserTestCase",true,flag);
}
	
	
	@Test
	public void getUserTestCase()
	{
		user =  userDAO.get("sourabh");
		
		assertEquals("getUserTestCase", null, user);
		
		
		
	}
	
	
	@Test
	public void getAllUsersTestCase()
	{
		List<User> users=  userDAO.list();
		
		//select count(*) from c_user_detail
		assertEquals("getAllUsersTestCase", 3, users.size());
		
	}
	
	
	
	
	
	
	
	
@Test	
public void UpdateTestCase(){
	user.setId("niithhhh");
	user.setName("AsP");
	user.setAddress("Bolinj nakad");
	user.setPassword("niit");
	user.setRole("Alumni");
	user.setMobile("444444444");
	
	boolean flag = userDAO.save(user);
	
	
	
	assertEquals("UpdateTestCase",true,flag);
	
	
}

@Test
public void AuthenticateTestcase()
{

	
	User flag = userDAO.authenticate("Aashi", "aashi");
	
	assertEquals("AuthenticateTestcase",null,flag);
	
	
}

@Test
public void ListTestCase(){
	
	int size = userDAO.list().size();
	
	assertEquals("ListTestCase",9,size);
}

@Test
public void getUserTestcase(){
	
	user = userDAO.get("BAHUBALI");
	
	assertEquals("getUserTestcase",null,user);
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
