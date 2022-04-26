package com.paf.electricity.model;

public class coustomer {
	
	int idcoustomer;
	String name;
	String address; 
	String contact_num;
	String accout_num;
	String con_get_date;
	String area;
	String mai;
	int status;
	
	public coustomer() {
		super();
	}
	
	public coustomer(int idcoustomer, String name, String address, String contact_num, String accout_num,
			String con_get_date, String area, String mai, int status) {
		super();
		this.idcoustomer = idcoustomer;
		this.name = name;
		this.address = address;
		this.contact_num = contact_num;
		this.accout_num = accout_num;
		this.con_get_date = con_get_date;
		this.area = area;
		this.mai = mai;
		this.status = status;
	}
	
	public coustomer(String name, String address, String contact_num, String accout_num,
			String con_get_date, String area, String mai, int status) {
		super();
		this.name = name;
		this.address = address;
		this.contact_num = contact_num;
		this.accout_num = accout_num;
		this.con_get_date = con_get_date;
		this.area = area;
		this.mai = mai;
		this.status = status;
	}

	public int getIdcoustomer() {
		return idcoustomer;
	}

	public void setIdcoustomer(int idcoustomer) {
		this.idcoustomer = idcoustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_num() {
		return contact_num;
	}

	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}

	public String getAccout_num() {
		return accout_num;
	}

	public void setAccout_num(String accout_num) {
		this.accout_num = accout_num;
	}

	public String getCon_get_date() {
		return con_get_date;
	}

	public void setCon_get_date(String con_get_date) {
		this.con_get_date = con_get_date;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMai() {
		return mai;
	}

	public void setMai(String mai) {
		this.mai = mai;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
