package com.niit.Collaboration.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "C_JOB_APPLICATION")
@Component
public class JobApplication extends BaseDomain{


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String string) {
		this.jobID = string;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	@Id
	private int id;
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="job_id")
	private String jobID;
	
	@Column(name="date_time")
	private Date date_time;
	private String remarks;
	private char status;//S->Select; R->Reject; C->Call For Inerview
	/*public void setDate_time(Date today) {
	   this.setDate_time(today);*/
		
	
	}