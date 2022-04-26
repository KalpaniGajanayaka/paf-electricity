package com.paf.electricity.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.paf.electricity.model.bills;

public class billsDAO {
	
	public static int insertBillsInfo(bills bill) {
		 int i = 0;
		 
		//create a connection with database
			Connection con = DataAccess.connect();
			//insert query
			String sql = "INSERT INTO `bills` (`account_num`, `name`, `dates`, `unit`, `amount`) VALUES (?, ?, ?, ?, ?);";
			
			try {
				
				//idbills, account_num, name, dates, unit, amount, status
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, bill.getAccount_num()); 
				ps.setString(2, bill.getName());
				ps.setString(3, bill.getDates());
				ps.setString(4, bill.getUnit());
				ps.setString(5, bill.getAmount());
				//ps.setInt(6, bill.getStatus());
				
				
				i = ps.executeUpdate();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return i;
	}
	
	public static boolean updateBillsInfo(bills bill) {
		 
		 Connection connection = DataAccess.connect();
			//sql
			String sqlUpdate = "UPDATE `bills` SET  `account_num` = ?, `name` = ?, `dates` = ?, `unit` = ?, `amount` = ?, `status` = ? WHERE `idbills` = ?;";
			
			//execute
			try {
				//idbills, account_num, name, dates, unit, amount, status
				PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
				psUpdate.setString(1, bill.getAccount_num() );
				psUpdate.setString(2, bill.getName() );
				psUpdate.setString(3, bill.getDates() );
				psUpdate.setString(4, bill.getUnit() );
				psUpdate.setString(5, bill.getAmount() );
				psUpdate.setInt(6,  bill.getStatus());
				psUpdate.setInt(7,  bill.getIdbills());
				psUpdate.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return true;
	}
	
	public static ArrayList<bills> getAllBillsInfo() {
		 ArrayList<bills> billList = new ArrayList();
		 
		 bills bills1 = null;
		 
			
			Connection con = DataAccess.connect();
			
			String sql = "select * from bills where status = '1';";
			
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet resultset = ps.executeQuery();
				
				//while theres data remaining
				while(resultset.next()) {
					bills1 = new bills();
					//idbills, account_num, name, dates, unit, amount, status
					bills1.setIdbills(resultset.getInt("idbills"));;
					bills1.setAccount_num(resultset.getString("account_num"));
					bills1.setName(resultset.getString("name"));
					bills1.setDates(resultset.getString("dates"));
					bills1.setUnit(resultset.getString("unit"));
					bills1.setAmount(resultset.getString("amount"));
					bills1.setStatus(resultset.getInt("status"));
					
					billList.add(bills1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
			//return arraylist
			return billList;
	}
	
	public static boolean removeBillsInfo(bills bill) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "delete from bills where idbills =?;";
		
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			
			psUpdate.setInt(1, bill.getIdbills());
			
			psUpdate.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
	
}
