package com.paf.electricity.model;

public class interruption {

	int idinterruption;
	String area_code; 
	String area;
	String dates;
	String time;
	int status;
	
	public interruption() {
		super();
	}
	
	public interruption(int idinterruption, String area_code, String area, String dates, String time, int status) {
		super();
		this.idinterruption = idinterruption;
		this.area_code = area_code;
		this.area = area;
		this.dates = dates;
		this.time = time;
		this.status = status;
	}
	
	public interruption( String area_code, String area, String dates, String time, int status) {
		super();
		this.area_code = area_code;
		this.area = area;
		this.dates = dates;
		this.time = time;
		this.status = status;
	}

	public int getIdinterruption() {
		return idinterruption;
	}

	public void setIdinterruption(int idinterruption) {
		this.idinterruption = idinterruption;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
