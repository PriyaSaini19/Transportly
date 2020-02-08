package com.flights;

public class FlightInfo {
		FlightsBean[] ft = new FlightsBean[6];
		
		//set flight information
		public void setInfo() {
				//day 1
				ft[0] = new FlightsBean("YUL", "YYZ", 1, 1);
				ft[1] = new FlightsBean("YUL", "YYC", 2, 1);
				ft[2] = new FlightsBean("YUL", "YYR", 3, 1);
				
				//day 2
				ft[3] = new FlightsBean("YUL", "YYZ", 4, 2);
				ft[4] = new FlightsBean("YUL", "YYC", 5, 2);
				ft[5] = new FlightsBean("YUL", "YYR", 6, 2);	
		}
		
		//get fligh information
		public void getInfo() {
			
			for(int i = 0; i<ft.length ; i++) {
				System.out.println("Flight: "+ft[i].getFlight_no()+", departure: "+ft[i].getDeparture()+", arrival: "+ft[i].getDestination()+", day: "+ft[i].getDay());
			}
		}
		
}
