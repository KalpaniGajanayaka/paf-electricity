package com.paf.electricity.model;

public class bills {

	int idbills;
	String account_num;
	String name;
	String dates;
	String unit;
	String amount;
	int status;
	
	public bills() {
		super();
	}
	
	public bills(int idbills, String account_num, String name, String dates, String unit, String amount,
			int status) {
		super();
		this.idbills = idbills;
		this.account_num = account_num;
		this.name = name;
		this.dates = dates;
		this.unit = unit;
		this.amount = amount;
		this.status = status;
	}
	
	public bills( String account_num, String name, String dates, String unit, String amount,
			int status) {
		super();
		this.account_num = account_num;
		this.name = name;
		this.dates = dates;
		this.unit = unit;
		this.amount = amount;
		this.status = status;
	}

	public int getIdbills() {
		return idbills;
	}

	public void setIdbills(int idbills) {
		this.idbills = idbills;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
