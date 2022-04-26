package com.paf.electricity.ApiManager;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.ArrayList;

import com.google.gson.*;
import com.paf.electricity.DAO.billsDAO;
import com.paf.electricity.DAO.coustomerDAO;
import com.paf.electricity.DAO.inquiryDAO;
import com.paf.electricity.DAO.interruptionDAO;
import com.paf.electricity.model.bills;
import com.paf.electricity.model.coustomer;
import com.paf.electricity.model.inquiry;
import com.paf.electricity.model.interruption;

@Path("masterAPI")
public class mainApi {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAPIInfo() {
		String msg = "This is masterAPI for paf assingment";
		JsonObject obj = new JsonObject();
		obj.addProperty("status", 1);
		obj.addProperty("message", msg);
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	//coustomer end point
	
	@GET
	@Path("/getAllCoustomer")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllCoustomerInfo() {
		
		ArrayList<coustomer> cousList = coustomerDAO.getAllCoustomerInfo();
		JsonObject obj = new JsonObject();
		JsonArray jsArray = new JsonArray();
		
		obj.addProperty("state","1");
		
		if(cousList.size() != 0) {
			System.out.println("Succesfully get all Coustomer info!");
			
			for (int counter = 0; counter < cousList.size(); counter++) { 
				JsonObject objs = new JsonObject();
				//idcoustomer, name, address, contact_num, accout_num, con_get_date, area, mail, status
				objs.addProperty("idcoustomer", cousList.get(counter).getIdcoustomer());
				objs.addProperty("name", cousList.get(counter).getName());
				objs.addProperty("address", cousList.get(counter).getAddress());
				objs.addProperty("contact_num", cousList.get(counter).getContact_num());
				objs.addProperty("accout_num", cousList.get(counter).getAccout_num());
				objs.addProperty("con_get_date", cousList.get(counter).getCon_get_date());
				objs.addProperty("area", cousList.get(counter).getArea());
				objs.addProperty("mail", cousList.get(counter).getMai());
				objs.addProperty("status", cousList.get(counter).getStatus());
		          //System.out.println(arrlist.get(counter)); 		
				jsArray.add(objs);
		      }  
			
			//obj.addProperty("data", jsArray);
			obj.add("data", jsArray);
			obj.addProperty("message", "Succesfully get all coustomer info !");
			
		}else {
			System.out.println("Error get all coustomer info !");
			obj.add("data", jsArray);
			obj.addProperty("message", "Error get all coustomer info !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	
	@POST
	@Path("/addCoustomer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCoustomerInfo(@FormParam("name") String name, @FormParam("address") String address,@FormParam("contact_num") String contact_num,@FormParam("accout_num") String accout_num,@FormParam("con_get_date") String con_get_date,@FormParam("area") String area,@FormParam("mail") String mail) {
		//idcoustomer, name, address, contact_num, accout_num, con_get_date, area, mail, status
		
		coustomer cus = new coustomer();
		cus.setName(name);
		cus.setAddress(address);
		cus.setContact_num(contact_num);
		cus.setAccout_num(accout_num);
		cus.setCon_get_date(con_get_date);
		cus.setArea(area);
		cus.setMai(mail);
		
		int state = coustomerDAO.insertCoustomerInfo(cus);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state!= 0) {
			System.out.println("Succesfully Inserted Coustomer!");
			
			obj.addProperty("message", "Succesfully Inserted Coustomer !");
			
		}else {
			System.out.println("Error in Insert Coustomer !");
			obj.addProperty("message", "Error in Insert Coustomer !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	@PUT
	@Path("/updateCoustomer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCoustomerInfo(@FormParam("name") String name, @FormParam("address") String address,@FormParam("contact_num") String contact_num,@FormParam("accout_num") String accout_num,@FormParam("con_get_date") String con_get_date,@FormParam("area") String area,@FormParam("mail") String mail,@FormParam("status") String status,@FormParam("idcoustomer") int idcoustomer) {
		////idcoustomer, name, address, contact_num, accout_num, con_get_date, area, mail, status
		
		coustomer cus = new coustomer();
		cus.setIdcoustomer(idcoustomer);
		cus.setName(name);
		cus.setAddress(address);
		cus.setContact_num(contact_num);
		cus.setAccout_num(accout_num);
		cus.setCon_get_date(con_get_date);
		cus.setArea(area);
		cus.setMai(mail);
		
		boolean state = coustomerDAO.updateCoustomerInfo(cus);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state) {
			System.out.println("Succesfully update Coustomer!");
			
			obj.addProperty("message", "Succesfully update Coustomer !");
			
		}else {
			System.out.println("Error in update Coustomer !");
			obj.addProperty("message", "Error in update Coustomer !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	@DELETE
	@Path("/removeCoustomer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeCoustomerInfo(@FormParam("idcoustomer") int idcoustomer) {
		////idcoustomer, name, address, contact_num, accout_num, con_get_date, area, mail, status
		
		coustomer cus = new coustomer();
		cus.setIdcoustomer(idcoustomer);
		
		boolean state = coustomerDAO.removeCoustomerInfo(cus);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state) {
			System.out.println("Succesfully update Coustomer!");
			
			obj.addProperty("message", "Succesfully update Coustomer !");
			
		}else {
			System.out.println("Error in update Coustomer !");
			obj.addProperty("message", "Error in update Coustomer !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	
	//inquery end points
	
	
	@GET
	@Path("/getAllInquriy")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllInquriyInfo() {
		ArrayList<inquiry> inqList = inquiryDAO.getAllInquriyInfo();
		JsonObject obj = new JsonObject();
		JsonArray jsArray = new JsonArray();
		
		obj.addProperty("state","1");
		
		if(inqList.size() != 0) {
			System.out.println("Succesfully get all Inquriy info!");
			
			for (int counter = 0; counter < inqList.size(); counter++) { 
				JsonObject objs = new JsonObject();
				//idinquiry, accout_num, contact_num, descrption, action, status
				objs.addProperty("idinquiry", inqList.get(counter).getIdinquiry());
				objs.addProperty("accout_num", inqList.get(counter).getAccout_num());
				objs.addProperty("contact_num", inqList.get(counter).getContact_num());
				objs.addProperty("descrption", inqList.get(counter).getDescrption());
				objs.addProperty("accout_num", inqList.get(counter).getAccout_num());
				objs.addProperty("action", inqList.get(counter).getAction());
				objs.addProperty("status", inqList.get(counter).getStatus());
		          //System.out.println(arrlist.get(counter)); 		
				jsArray.add(objs);
		      }  
			
			//obj.addProperty("data", jsArray);
			obj.add("data", jsArray);
			obj.addProperty("message", "Succesfully get all Inquriy info !");
			
		}else {
			System.out.println("Error get all Inquriy info !");
			obj.add("data", jsArray);
			obj.addProperty("message", "Error get all Inquriy info !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	
	@POST
	@Path("/addInquriy")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addInquriyInfo(@FormParam("accout_num") String accout_num, @FormParam("contact_num") String contact_num,@FormParam("descrption") String descrption,@FormParam("action") String action) {
		//idinquiry, accout_num, contact_num, descrption, action, status
		
		inquiry inqu = new inquiry();
		inqu.setAccout_num(accout_num);
		inqu.setContact_num(contact_num);
		inqu.setDescrption(descrption);
		inqu.setAction(action);
		
		
		
		int state = inquiryDAO.insertInquriyInfo(inqu);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state!= 0) {
			System.out.println("Succesfully Inserted Inquriy!");
			
			obj.addProperty("message", "Succesfully Inserted Inquriy !");
			
		}else {
			System.out.println("Error in Insert Inquriy !");
			obj.addProperty("message", "Error in Insert Inquriy !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	@PUT
	@Path("/updateInquriy")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateInquriyInfo(@FormParam("accout_num") String accout_num, @FormParam("contact_num") String contact_num,@FormParam("descrption") String descrption,@FormParam("action") String action,@FormParam("status") int status,@FormParam("idinquiry") int idinquiry) {
		//idinquiry, accout_num, contact_num, descrption, action, status
		
		inquiry inqu = new inquiry();
		inqu.setIdinquiry(idinquiry);
		inqu.setAccout_num(accout_num);
		inqu.setContact_num(contact_num);
		inqu.setDescrption(descrption);
		inqu.setAction(action);
		inqu.setStatus(status);
		
		
		
		boolean state = inquiryDAO.updateInquriyInfo(inqu);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state) {
			System.out.println("Succesfully Update Inquriy!");
			
			obj.addProperty("message", "Succesfully Update Inquriy !");
			
		}else {
			System.out.println("Error in Update Inquriy !");
			obj.addProperty("message", "Error in Update Inquriy !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	@DELETE
	@Path("/removeInquriy")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeInquriyInfo(@FormParam("idinquiry") int idinquiry) {
		//idinquiry, accout_num, contact_num, descrption, action, status
		
		inquiry inqu = new inquiry();
		inqu.setIdinquiry(idinquiry);
		
		
		boolean state = inquiryDAO.removeInquriyInfo(inqu);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state) {
			System.out.println("Succesfully remove Inquriy!");
			
			obj.addProperty("message", "Succesfully remove Inquriy !");
			
		}else {
			System.out.println("Error in remove Inquriy !");
			obj.addProperty("message", "Error in remove Inquriy !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	
	//bills end point
	
	
	@GET
	@Path("/getAllBills")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllBillsInfo() {
		
		ArrayList<bills> billList = billsDAO.getAllBillsInfo();
		JsonObject obj = new JsonObject();
		JsonArray jsArray = new JsonArray();
		
		obj.addProperty("state","1");
		
		if(billList.size() != 0) {
			System.out.println("Succesfully get all Bills info!");
			
			for (int counter = 0; counter < billList.size(); counter++) { 
				JsonObject objs = new JsonObject();
				//idbills, account_num, name, dates, unit, amount, status
				objs.addProperty("idbills", billList.get(counter).getIdbills());
				objs.addProperty("account_num", billList.get(counter).getAccount_num());
				objs.addProperty("name", billList.get(counter).getName());
				objs.addProperty("dates", billList.get(counter).getDates());
				objs.addProperty("unit", billList.get(counter).getUnit());
				objs.addProperty("amount", billList.get(counter).getAmount());
				objs.addProperty("status", billList.get(counter).getStatus());
		          //System.out.println(arrlist.get(counter)); 		
				jsArray.add(objs);
		      }  
			
			//obj.addProperty("data", jsArray);
			obj.add("data", jsArray);
			obj.addProperty("message", "Succesfully get all Bills info !");
			
		}else {
			System.out.println("Error get all Bills info !");
			obj.add("data", jsArray);
			obj.addProperty("message", "Error get all Bills info !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
		
	}
	
	
	@POST
	@Path("/addBills")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBillsInfo(@FormParam("account_num") String account_num, @FormParam("name") String name,@FormParam("dates") String dates,@FormParam("unit") String unit,@FormParam("amount") String amount) {
		//idbills, account_num, name, dates, unit, amount, status
		
		bills bill = new bills();
		
		bill.setAccount_num(account_num);
		bill.setName(name);
		bill.setDates(dates);
		bill.setUnit(unit);
		bill.setAmount(amount);
		
		
		int state = billsDAO.insertBillsInfo(bill);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state!= 0) {
			System.out.println("Succesfully Inserted Bills !");
			
			obj.addProperty("message", "Succesfully Inserted Bills !");
			
		}else {
			System.out.println("Error in Insert Bills !");
			obj.addProperty("message", "Error in Insert Bills !");
		}
			
		//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
		
	}
	
	@PUT
	@Path("/updateBills")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBillsInfo(@FormParam("account_num") String account_num, @FormParam("name") String name,@FormParam("dates") String dates,@FormParam("unit") String unit,@FormParam("amount") String amount,@FormParam("status") int status,@FormParam("idbills") int idbills) {
		//idbills, account_num, name, dates, unit, amount, status
		
		bills bill = new bills();
		
		bill.setIdbills(idbills);
		bill.setAccount_num(account_num);
		bill.setName(name);
		bill.setDates(dates);
		bill.setUnit(unit);
		bill.setAmount(amount);
		bill.setStatus(status);
		
		
		boolean state = billsDAO.updateBillsInfo(bill);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state) {
			System.out.println("Succesfully update Bills !");
			
			obj.addProperty("message", "Succesfully update Bills !");
			
		}else {
			System.out.println("Error in update Bills !");
			obj.addProperty("message", "Error in update Bills !");
		}
			
		//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	@DELETE
	@Path("/removeBills")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeBillsInfo(@FormParam("idbills") int idbills) {
		//idbills, account_num, name, dates, unit, amount, status
		
		bills bill = new bills();
		
		bill.setIdbills(idbills);
		
		boolean state = billsDAO.removeBillsInfo(bill);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state) {
			System.out.println("Succesfully remove Bills !");
			
			obj.addProperty("message", "Succesfully remove Bills !");
			
		}else {
			System.out.println("Error in remove Bills !");
			obj.addProperty("message", "Error in remove Bills !");
		}
			
		//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	//interruption end point
	
	@GET
	@Path("/getAllInterruption")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllInterruptionInfo() {
		
		ArrayList<interruption> intruList = interruptionDAO.getAllInterruptionInfo();
		JsonObject obj = new JsonObject();
		JsonArray jsArray = new JsonArray();
		
		obj.addProperty("state","1");
		
		if(intruList.size() != 0) {
			System.out.println("Succesfully get all Interruption info!");
			
			for (int counter = 0; counter < intruList.size(); counter++) { 
				JsonObject objs = new JsonObject();
				//idinterruption, area_code, area, dates, time, status
				objs.addProperty("idinterruption", intruList.get(counter).getIdinterruption());
				objs.addProperty("area_code", intruList.get(counter).getArea_code());
				objs.addProperty("area", intruList.get(counter).getArea());
				objs.addProperty("dates", intruList.get(counter).getDates());
				objs.addProperty("time", intruList.get(counter).getTime());
				objs.addProperty("status", intruList.get(counter).getStatus());
		          //System.out.println(arrlist.get(counter)); 		
				jsArray.add(objs);
		      }  
			//obj.addProperty("data", jsArray);
			obj.add("data", jsArray);
			obj.addProperty("message", "Succesfully get all Interruption info !");
			
		}else {
			System.out.println("Error get all Interruption info !");
			obj.add("data", jsArray);
			obj.addProperty("message", "Error get all Interruption info !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
		
	}
	
	
	@POST
	@Path("/addInterruption")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addInterruptionInfo(@FormParam("area_code") String area_code, @FormParam("area") String area,@FormParam("dates") String dates,@FormParam("time") String time) {
		//idinterruption, area_code, area, dates, time, status
		
		
		interruption inturp = new interruption();
		
		inturp.setArea_code(area_code);
		inturp.setArea(area);
		inturp.setDates(dates);
		inturp.setTime(time);
		
		int state = interruptionDAO.insertInterruptionInfo(inturp);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state!= 0) {
			System.out.println("Succesfully Inserted Interruption !");
			
			obj.addProperty("message", "Succesfully Inserted Interruption !");
			
		}else {
			System.out.println("Error in Insert Interruption !");
			obj.addProperty("message", "Error in Insert Interruption !");
		}
			
		//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	@PUT
	@Path("/updateInterruption")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateInterruptionInfo(@FormParam("area_code") String area_code, @FormParam("area") String area,@FormParam("dates") String dates,@FormParam("time") String time,@FormParam("status") int status,@FormParam("idinterruption") int idinterruption) {
		//idinterruption, area_code, area, dates, time, status
		
		interruption inturp = new interruption();
		
		inturp.setIdinterruption(idinterruption);
		inturp.setArea_code(area_code);
		inturp.setArea(area);
		inturp.setDates(dates);
		inturp.setTime(time);
		inturp.setStatus(status);
		
		boolean state = interruptionDAO.updateInterruptionInfo(inturp);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state) {
			System.out.println("Succesfully update Interruption !");
			
			obj.addProperty("message", "Succesfully update Interruption !");
			
		}else {
			System.out.println("Error in update Interruption !");
			obj.addProperty("message", "Error in update Interruption !");
		}
			
		//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	@DELETE
	@Path("/removeInterruption")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeInterruptionInfo(@FormParam("idinterruption") int idinterruption) {
		//idinterruption, area_code, area, dates, time, status
		
		interruption inturp = new interruption();
		
		inturp.setIdinterruption(idinterruption);
		
		
		boolean state = interruptionDAO.removeInterruptionInfo(inturp);
		
		JsonObject obj = new JsonObject();
		
		
		obj.addProperty("state",state);
		if(state) {
			System.out.println("Succesfully remove Interruption !");
			
			obj.addProperty("message", "Succesfully remove Interruption !");
			
		}else {
			System.out.println("Error in remove Interruption !");
			obj.addProperty("message", "Error in remove Interruption !");
		}
			
		//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
	}
	
	
}
