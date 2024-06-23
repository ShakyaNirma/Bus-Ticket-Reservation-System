package com.Bus;
import com.Bus.Bus; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import java.sql.Statement;


public class busDBUtil {
	private static boolean isSuccess;
	private static Connection con=null;
	private static Statement stat=null;
	private static ResultSet rs=null;
	
	public static List<Bus> validate(String busid){
	
		ArrayList<Bus> bus=new ArrayList<>();
		//create database connection
		

		try {
			con=DBConnect.getConnection();
			stat=con.createStatement();			
			String sql="select * from bus where BusId ='"+busid+"'";
			rs=stat.executeQuery(sql);
			
			if (rs.next()) {
				String id=rs.getString(1);
				int seatno=rs.getInt(2);
				String owner=rs.getString(3);
				String driverid=rs.getString(4);	
				
				Bus b=new Bus(id,seatno,owner,driverid);

				bus.add(b);
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bus;
	}
	
	public static boolean InsertBus(String busid,int seatno,String owner,String driverid) {
		boolean isSuccess =false;
	
		
		try {
			con=DBConnect.getConnection();
			stat=con.createStatement();
			String sql="insert into bus values('"+busid+"','"+seatno+"','"+owner+"','"+driverid+"')";
			int rs=stat.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess=true;
			}else {
				isSuccess=false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean updateBus(String busid,int seatno,String owner,String driverid) {
	
		try {
			con=DBConnect.getConnection();
			stat=con.createStatement();
			String sql="update bus set SeatNo='"+seatno+"',owner='"+owner+"',driverId='"+driverid+"'"+"where BusId='"+busid+"'";

			int rs=stat.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess=true;
			}else {
				isSuccess=false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	public static boolean deleteBus(String busid) {
		
	
	
		try {
			con=DBConnect.getConnection();
			stat=con.createStatement();
			String sql="delete from bus where BusId='"+busid+"'";
			int r=stat.executeUpdate(sql);
			
			if(r>0) {
				isSuccess=true;
			}else {
				isSuccess=false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
}