package com.Bus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BusInsert")
public class BusInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busid= request.getParameter("busid");
		int seatno=Integer.parseInt(request.getParameter("seatno"));
		String owner= request.getParameter("owner");
		String driverid= request.getParameter("driverid");
		
		boolean isTrue;
		
		isTrue=busDBUtil.InsertBus(busid, seatno, owner, driverid);
		
		if(isTrue==true) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher2=request.getRequestDispatcher("unsuccess.jsp");
				dispatcher2.forward(request, response);
			}
	}

}
