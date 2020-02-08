package com.flights;

public class UserStory {
	
	public void UserStory1() {
		FlightInfo fi = new FlightInfo();
		
		fi.setInfo();
		fi.getInfo();
	}
	
	public void UserStory2() {
		ReadJson rj = new ReadJson();
		
		rj.createBatches();
		rj.readOrders();
		rj.printSchedule();
	}

}
