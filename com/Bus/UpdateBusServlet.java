package com.Bus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateBusServlet")
public class UpdateBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busid=request.getParameter("busid")	;
		int seatno=Integer.parseInt(request.getParameter("seatno"));
		String owner=request.getParameter("owner");
		String driverid=request.getParameter("driverid");
		
		boolean value;
		value=busDBUtil.updateBus(busid, seatno, owner, driverid);
		
		if(value==true) {
			RequestDispatcher re=request.getRequestDispatcher("success.jsp");
			re.forward(request, response);
			}
		else {
			RequestDispatcher re=request.getRequestDispatcher("unsuccess.jsp");
			re.forward(request, response);
		}
	}

}
