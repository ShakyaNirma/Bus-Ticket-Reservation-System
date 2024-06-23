package com.Bus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteBusServlet")
public class DeleteBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busid= request.getParameter("busid");
		boolean result;
		
		result= busDBUtil.deleteBus(busid);
		if(result==true) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			}else {
			RequestDispatcher dispatcher2=request.getRequestDispatcher("unsuccess.jsp");
				dispatcher2.forward(request, response);
			}
		
	}

}
