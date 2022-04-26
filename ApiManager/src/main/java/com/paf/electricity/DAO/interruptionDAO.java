package com.paf.electricity.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.paf.electricity.model.interruption;

public class interruptionDAO {
	
	public static int insertInterruptionInfo(interruption intur) {
		 int i = 0;
		 
		//create a connection with database
			Connection con = DataAccess.connect();
			//insert query
			String sql = "INSERT INTO `interruption` (`area_code`, `area`, `dates`, `time`) VALUES (?, ?, ?, ?);";
			
			try {
				
				//idinterruption, area_code, area, dates, time, status
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, intur.getArea_code()); 
				ps.setString(2, intur.getArea());
				ps.setString(3, intur.getDates());
				ps.setString(4, intur.getTime());
				//ps.setInt(5, intur.getStatus());
				
				
				i = ps.executeUpdate();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return i;
	}
	
	public static boolean updateInterruptionInfo(interruption intur) {
		 
		 Connection connection = DataAccess.connect();
			//sql
			String sqlUpdate = "UPDATE `interruption` SET `area_code` = ?, `area` = ?, `dates` = ?, `time` = ?, `status` = ? WHERE `idinterruption` = ?;";
			
			//execute
			try {
				//idinterruption, area_code, area, dates, time, status
				PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
				psUpdate.setString(1, intur.getArea_code() );
				psUpdate.setString(2, intur.getArea() );
				psUpdate.setString(3, intur.getDates() );
				psUpdate.setString(4, intur.getTime());
				psUpdate.setInt(5, intur.getStatus() );
				psUpdate.setInt(6, intur.getIdinterruption() );
				psUpdate.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return true;
	}
	
	public static ArrayList<interruption> getAllInterruptionInfo() {
		 ArrayList<interruption> inturList = new ArrayList();
		 
		 interruption interruption1 = null;
		 
			
			Connection con = DataAccess.connect();
			
			String sql = "select * from interruption where status = '1';";
			
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet resultset = ps.executeQuery();
				
				//while theres data remaining
				while(resultset.next()) {
					interruption1 = new interruption();
					//idinterruption, area_code, area, dates, time, status
					interruption1.setIdinterruption(resultset.getInt("idinterruption"));
					interruption1.setArea_code(resultset.getString("area_code"));
					interruption1.setArea(resultset.getString("area"));
					interruption1.setDates(resultset.getString("dates"));
					interruption1.setTime(resultset.getString("time"));
					interruption1.setStatus(resultset.getInt("status"));
					
					inturList.add(interruption1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
			//return arraylist
			return inturList;
	}
	
	public static boolean removeInterruptionInfo(interruption intur) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "delete from interruption where idinterruption =?;";
		
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			
			psUpdate.setInt(1, intur.getIdinterruption());
			
			psUpdate.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
}
