package com.Bus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDBUtil {
	public static List<User> showList (String cusid){
	
			ArrayList<User> cus=new ArrayList<>();
			
			String url = "jdbc:mysql://localhost:3306/busswap";
			String user = "root";
			String pass = "shaki9996";
		

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url, user, pass);
				Statement stat=con.createStatement();		
				String sql="select * from customer where IdCustomer='"+cusid+"'";
				ResultSet result=stat.executeQuery(sql);
				
				if (result.next()) {
					int cid=result.getInt(1);
					String fname= result.getString(2);
					String lname= result.getString(3);
					String email =result.getString(4);	
					String address= result.getString(5);
					String phone =result.getString(6);
					String usern= result.getString(7);
					String password= result.getString(8);
					
					User u =new User(cid,fname,lname,email,address,phone,usern,password);
					cus.add(u);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return cus;
		}
	public static boolean deleteCustomer(String cusid) {
		boolean isSuccess = false;
		int convertId=Integer.parseInt(cusid);
		
		String url = "jdbc:mysql://localhost:3306/busswap";
		String user = "root";
		String pass = "shaki9996";
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, pass);
			Statement stat=con.createStatement();		
			String sql="delete from customer where IdCustomer='"+convertId+"'";
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

	
		
	

