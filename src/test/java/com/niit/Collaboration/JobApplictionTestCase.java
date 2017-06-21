package com.niit.Collaboration;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Collaboration.DAO.JobApplicationDAO;
import com.niit.Collaboration.model.JobApplication;

import junit.framework.Assert;

public class JobApplictionTestCase {

	@Autowired
	private static JobApplication jobApplication;
	
	@Autowired
	private static JobApplicationDAO jobApplicationDAO;
	
	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobApplication = (JobApplication) context.getBean("jobApplication");
		jobApplicationDAO = (JobApplicationDAO) context.getBean("jobApplicationDAO");
	}
	@Test
	public void saveJob(){
		Long d = System.currentTimeMillis();
		Date today = new Date(d);
		
       // jobApplication.setId(1);
 		jobApplication.setJobID("44");
		jobApplication.setUser_id("Aashi");
		jobApplication.setStatus('A');
		jobApplication.setDate_time(today);
		boolean flag = jobApplicationDAO.save(jobApplication);
		assertEquals("saveJob",true,flag);
		
	}
}
	/*
	public void getAllUserJob(){
	 List<JobApplication> jobs = jobApplicationDAO.list();
	assertEquals("getAllUserJob",2,jobs.size());
	}
	
	public void getUserJob(){
		
		List<JobApplication> userList = jobApplicationDAO.getList("rajeev");
		assertEquals("getUserJob",2,userList.size());
	}
	
	public void getAppById(){
		jobApplication = jobApplicationDAO.getApplicationById(001);
		Assert.assertNotNull("getAppById", jobApplication);
	}
}*/