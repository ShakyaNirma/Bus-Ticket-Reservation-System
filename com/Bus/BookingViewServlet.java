package com.Bus;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookingViewServlet")
public class BookingViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookingid=request.getParameter("bookingid");
		try{
		List<Booking> bookingDetails= BookingDBUtil.showListBooking(bookingid);	
		request.setAttribute("bookingDetails", bookingDetails);
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher patcher=request.getRequestDispatcher("ManageBookingDetails.jsp");
		patcher.forward(request, response);

}
}