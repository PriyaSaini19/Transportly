package com.flights;

public class FlightsBean {
		private String destination;
		private String departure;
		private int flight_no;
		private int day;
		private int capacity;
		
		//getter & setters
		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public String getDeparture() {
			return departure;
		}

		public void setDeparture(String departure) {
			this.departure = departure;
		}

		public int getFlight_no() {
			return flight_no;
		}

		public void setFlight_no(int flight_no) {
			this.flight_no = flight_no;
		}
		
		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public FlightsBean(String departure, String destination, int flight_no, int day, int capacity){
			this.destination = destination;
			this.departure = departure;
			this.flight_no = flight_no;
			this.day = day;
			this.capacity = capacity;
		}
		
		public FlightsBean(String departure, String destination, int flight_no, int day){
			this.destination = destination;
			this.departure = departure;
			this.flight_no = flight_no;
			this.day = day;
			this.capacity = 20;
		}
		
}
