package com.Bus;

public class Booking {
	private int booking;
	private int cusid;
	private String email;
	private String phone;
	private String destination;
	private String departure;
	private String date;
	private double price;
	
	public Booking(int booking, int cusid, String email, String phone, String destination, String departure,
			String date, double price) {
		super();
		this.booking = booking;
		this.cusid = cusid;
		this.email = email;
		this.phone = phone;
		this.destination = destination;
		this.departure = departure;
		this.date = date;
		this.price = price;
	}

	public int getBooking() {
		return booking;
	}

	public int getCusid() {
		return cusid;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}


	public String getDestination() {
		return destination;
	}


	public String getDeparture() {
		return departure;
	}


	public String getDate() {
		return date;
	
	}

	public double getPrice() {
		return price;
	}


	
	
	
}
