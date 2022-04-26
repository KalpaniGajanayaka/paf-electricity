package com.paf.electricity.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.paf.electricity.model.inquiry;

public class inquiryDAO {
	public static int insertInquriyInfo(inquiry inq) {
		 int i = 0;
		 
		//create a connection with database
			Connection con = DataAccess.connect();
			//insert query
			String sql = "INSERT INTO `inquiry` (`accout_num`, `contact_num`, `descrption`, `action`) VALUES (?, ?, ?, ?);";
			
			try {
				
				//idinquiry, accout_num, contact_num, descrption, action, status
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, inq.getAccout_num()); 
				ps.setString(2, inq.getContact_num());
				ps.setString(3, inq.getDescrption());
				ps.setString(4, inq.getAction());
				//ps.setInt(5, inq.getStatus());
				
				
				i = ps.executeUpdate();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return i;
	}
	
	public static boolean updateInquriyInfo(inquiry inq) {
		 
		 Connection connection = DataAccess.connect();
			//sql
			String sqlUpdate = "UPDATE `inquiry` SET  `accout_num` = ?, `contact_num` = ?, `descrption` = ?, `action` = ?, `status` = ?,  WHERE  `idinquiry` = ?;";
			
			//execute
			try {
				//idinquiry, accout_num, contact_num, descrption, action, status
				PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
				psUpdate.setString(1, inq.getAccout_num() );
				psUpdate.setString(2, inq.getContact_num() );
				psUpdate.setString(3, inq.getDescrption() );
				psUpdate.setString(4, inq.getAction());
				psUpdate.setInt(5, inq.getStatus() );
				psUpdate.setInt(6, inq.getIdinquiry() );
				psUpdate.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return true;
	}
	
	public static ArrayList<inquiry> getAllInquriyInfo() {
		 ArrayList<inquiry> inquList = new ArrayList();
		 
		 inquiry inquiry1 = null;
		 
			
			Connection con = DataAccess.connect();
			
			String sql = "select * from inquiry where status = '1';";
			
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet resultset = ps.executeQuery();
				
				//while theres data remaining
				while(resultset.next()) {
					inquiry1 = new inquiry();
					//idinquiry, accout_num, contact_num, descrption, action, status
					inquiry1.setIdinquiry(resultset.getInt("idinquiry"));
					inquiry1.setAccout_num(resultset.getString("accout_num"));
					inquiry1.setContact_num(resultset.getString("contact_num"));
					inquiry1.setDescrption(resultset.getString("descrption"));
					inquiry1.setAction(resultset.getString("action"));
					inquiry1.setStatus(resultset.getInt("status"));
					
					inquList.add(inquiry1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
			//return arraylist
			return inquList;
	}
	
	public static boolean removeInquriyInfo(inquiry inq) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "delete from inquiry where idinquiry =?;";
		
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			
			psUpdate.setInt(1, inq.getIdinquiry());
			
			psUpdate.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
}
