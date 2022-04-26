package com.paf.electricity.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.paf.electricity.model.coustomer;

public class coustomerDAO {
	
	public static int insertCoustomerInfo(coustomer cous) {
		 int i = 0;
		 
		//create a connection with database
			Connection con = DataAccess.connect();
			//insert query
			String sql = "INSERT INTO `coustomer` (`name`, `address`, `contact_num`, `accout_num`, `con_get_date`, `area`,`mail`) VALUES (?, ?, ?, ?, ?, ?, ?);";
			
			try {
				
				//idcoustomer, name, address, contact_num, accout_num, con_get_date, area, mail, status
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, cous.getName()); 
				ps.setString(2, cous.getAddress());
				ps.setString(3, cous.getContact_num());
				ps.setString(4, cous.getAccout_num());
				ps.setString(5, cous.getCon_get_date());
				ps.setString(6, cous.getArea());
				ps.setString(7, cous.getMai());
				
				
				i = ps.executeUpdate();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return i;
	}
	
	public static boolean updateCoustomerInfo(coustomer cous) {
		 
		 Connection connection = DataAccess.connect();
			//sql
			String sqlUpdate = "UPDATE `coustomer` SET `name` = ?, `address` = ?, `contact_num` = ?, `accout_num` = ?, `con_get_date` = ?, `area` = ?, `mail` = ?, `status` = ?   WHERE `idcoustomer` = ?;";
			
			//execute
			try {
				//idcoustomer, name, address, contact_num, accout_num, con_get_date, area, mail, status
				PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
				psUpdate.setString(1, cous.getName() );
				psUpdate.setString(2, cous.getAddress() );
				psUpdate.setString(3, cous.getContact_num() );
				psUpdate.setString(4, cous.getAccout_num() );
				psUpdate.setString(5, cous.getCon_get_date() );
				psUpdate.setString(6,  cous.getArea());
				psUpdate.setString(7,  cous.getMai());
				psUpdate.setInt(8,  cous.getStatus());
				psUpdate.setInt(9, cous.getIdcoustomer());
				psUpdate.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return true;
	}
	
	public static ArrayList<coustomer> getAllCoustomerInfo() {
		 ArrayList<coustomer> cusList = new ArrayList();
		 
		 	coustomer cous1 = null;
		 
			
			Connection con = DataAccess.connect();
			
			String sql = "select * from coustomer where status = '1';";
			
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet resultset = ps.executeQuery();
				
				//while theres data remaining
				while(resultset.next()) {
					cous1 = new coustomer();
					//idcoustomer, name, address, contact_num, accout_num, con_get_date, area, mail, status
					cous1.setIdcoustomer(resultset.getInt("idcoustomer"));
					cous1.setName(resultset.getString("name"));
					cous1.setAddress(resultset.getString("address"));
					cous1.setContact_num((resultset.getString("contact_num")));
					cous1.setAccout_num(resultset.getString("accout_num"));
					cous1.setCon_get_date(resultset.getString("con_get_date"));
					cous1.setArea(resultset.getString("area"));
					cous1.setMai(resultset.getString("mail"));
					cous1.setStatus(resultset.getInt("status"));
					
					cusList.add(cous1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
			//return arraylist
			return cusList;
	}
	
	public static boolean removeCoustomerInfo(coustomer cous) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "delete from coustomer where idcoustomer =?;";
		
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			
			psUpdate.setInt(1, cous.getIdcoustomer());
			
			psUpdate.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
}
