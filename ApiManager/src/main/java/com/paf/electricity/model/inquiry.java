package com.paf.electricity.model;


public class inquiry {

	int idinquiry;
	String accout_num;
	String contact_num;
	String descrption;
	String action;
	int status;
	
	public inquiry() {
		super();		
	}
	
	public inquiry(int idinquiry, String accout_num, String contact_num, String descrption, String action, int status) {
		super();
		this.idinquiry = idinquiry;
		this.accout_num = accout_num;
		this.contact_num = contact_num;
		this.descrption = descrption;
		this.action = action;
		this.status = status;
	}
	
	public inquiry( String accout_num, String contact_num, String descrption, String action, int status) {
		super();
		this.accout_num = accout_num;
		this.contact_num = contact_num;
		this.descrption = descrption;
		this.action = action;
		this.status = status;
	}

	public int getIdinquiry() {
		return idinquiry;
	}

	public void setIdinquiry(int idinquiry) {
		this.idinquiry = idinquiry;
	}

	public String getAccout_num() {
		return accout_num;
	}

	public void setAccout_num(String accout_num) {
		this.accout_num = accout_num;
	}

	public String getContact_num() {
		return contact_num;
	}

	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
