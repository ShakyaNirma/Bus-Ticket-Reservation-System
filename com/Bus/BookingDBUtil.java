package com.Bus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDBUtil {
	public static List<Booking> showListBooking(String bookingid){
		ArrayList<Booking> booked=new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/busswap";
		String user = "root";
		String pass = "shaki9996";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, pass);
			Statement stat=con.createStatement();		
			String sql="select * from booking where bookingid='"+bookingid+"'";
			ResultSet result=stat.executeQuery(sql);
			
			if (result.next()) {
				int booking=result.getInt(1);
				int id= result.getInt(2);
				String email= result.getString(3);
				String phone =result.getString(4);	
				String destination= result.getString(5);
				String departure =result.getString(6);
				String date= result.getString(7);
				double price= result.getDouble(8);
				
				
				Booking u =new Booking(booking, id, email, phone, destination, departure, date, price);
				booked.add(u);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return booked;
	}
	public static boolean deleteBooking(String bookingid) {
	boolean isSuccess = false;
	int convertId=Integer.parseInt(bookingid);
	
	String url ="jdbc:mysql://localhost:3306/busswap";
	String user ="root";
	String pass ="shaki9996";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, user, pass);
		Statement stat=con.createStatement();		
		String sql="delete from booking where bookingid='"+convertId+"'";
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

