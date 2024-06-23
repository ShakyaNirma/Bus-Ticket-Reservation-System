package com.Bus;

public class Bus {
	private String busid;
	private int seatNo;
	private String owner;
	private String driverid;
	
	public Bus(String id, int seatNo, String owner, String driverid) {
		this.busid = id;
		this.seatNo = seatNo;
		this.owner = owner;
		this.driverid = driverid;
	}

	public String getBusid() {
		return busid;
	}


	public int getSeatNo() {
		return seatNo;
	}

	public String getOwner() {
		return owner;
	}


	public String getDriverid() {
		return driverid;
	}

	
	
	
}
