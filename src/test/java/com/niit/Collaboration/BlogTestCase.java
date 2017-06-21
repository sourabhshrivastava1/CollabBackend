package com.niit.Collaboration;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Collaboration.DAO.BlogDAO;
import com.niit.Collaboration.DAO.UserDAO;
import com.niit.Collaboration.model.Blog;
import com.niit.Collaboration.model.User;

import junit.framework.Assert;

public class BlogTestCase {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static Blog blog;
	
	@Autowired  static BlogDAO  blogDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		blog = (Blog) context.getBean("blog");
		
		blogDAO = (BlogDAO) context.getBean("blogDAO");
		 
	}
	
	/*@Test
	
	public void validateCredentialsTestCase()
	{
		
	boolean flag =	  blogDAO.isValidCredentials("manish", "manish");
	
	Assert.assertEquals("validateCredentialsTestCase", true , flag);;
	;;;;;;;;
	;;;;;;;;;
		
	}
	*/
	
	@Test
	public void createBlogTestCase()
	{
		blog.setId(4);
		blog.setUserid("Akshat");
		blog.setTitle("C++");
		blog.setDatetime(new Date());
	    blog.setStatus('Y');
	    blog.setReason("this is for Tutorial");
	    blog.setDescription("C++ (pronounced cee plus plus /ˈsiː plʌs plʌs/) is a general-purpose programming language. It has imperative, object-oriented and generic programming features, while also providing facilities for low-level memory manipulation.");
		boolean flag =	blogDAO.saveOrupdate(blog);
	       
	       assertEquals("createBlogTestCase ",true, flag);
	}
	
	/*public void createBlog() {
		blog.setId("b005");
		
		blog.setTitle("Test");
		blog.setUserid("u001");
		boolean flag = blogDAO.save(blog);
		Assert.assertEquals("createBlog", true, flag);

	}

	public void updateBlog() {
		String var = "Hello world";
		// java.sql.Blob blob =
		// org.hibernate.Hibernate.createBlob(var.getBytes());
		blog.setId("b001");
		blog.setTitle("Testss");
		blog.setUserid("u001");
		blog.setReason("abcdefg");
		blog.setStatus("Y");
		blog.setDescription("Testvxcvxcvcvxcv");

		boolean flags = blogDAO.update(blog);
		Assert.assertEquals("updateBlog", true, flags);
	}

	@Test
	public void listBlogs() {
		blog = blogDAO.getBlogById("b0041");
		Assert.assertEquals("listBlogs", null, blog);
	}

	@Test
	public void deleteBlog() {
		blog = blogDAO.getBlogById("b004");
		boolean blogs = blogDAO.delete(blog);
		Assert.assertEquals("deleteBlog", true, blogs);
	}*/
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


