package com.flights;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils;

public class ReadJson {
	
	private Map<String, Integer> batchList = new HashMap<String, Integer>();
	private Map<String, Integer> batchOrder1 = new HashMap<String, Integer>();
	private Map<String, Integer> batchOrder2 = new HashMap<String, Integer>();
	 
	//used to keep track of batches
	public void createBatches() {
		//day 1
		batchOrder1.put("YYZ", new Integer(0));
		batchOrder1.put("YYC", new Integer(0));
		batchOrder1.put("YYR", new Integer(0));
		
		//day 2
		batchOrder2.put("YYZ", new Integer(0));
		batchOrder2.put("YYC", new Integer(0));
		batchOrder2.put("YYR", new Integer(0));
	}
	
	
	@SuppressWarnings("unchecked")
    public void readOrders(){
		
		String orderDest = new String();
		
		try {
			//Read JSON file
			File file = new File("./coding-assigment-orders.json");
		    String content = FileUtils.readFileToString(file, "utf-8");
		    
		    // Convert JSON string to JSON Object
		    JSONObject orderJsonObject = new JSONObject(content);
		    Iterator<String> keys = orderJsonObject.keys();
		    
		    // iterate through JSON Object
		    while(keys.hasNext()) {
		        String key = keys.next();
		        
		        if (orderJsonObject.get(key) instanceof JSONObject) {
		              
		        	orderDest = orderJsonObject.getJSONObject(key).getString("destination");
		        	//schedule order
		        	addOrder(key, orderDest);
		        }
		    }
	    
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void addOrder(String key, String orderDest) {
		
		switch (orderDest) {
		
			case "YYZ":
				if(batchOrder1.get(orderDest)<20) {
					batchOrder1.put(orderDest, batchOrder1.get(orderDest) + 1);
					batchList.put(key, 0);
				}else if(batchOrder2.get(orderDest)<20) {
					batchOrder2.put(orderDest, batchOrder2.get(orderDest) + 1);
					batchList.put(key, 3);
				}else {
					batchList.put(key, -1);
				}
				break;
			
			case "YYC":
				if(batchOrder1.get(orderDest)<20) {
					batchOrder1.put(orderDest, batchOrder1.get(orderDest) + 1);
					batchList.put(key, 1);
				}else if(batchOrder2.get(orderDest)<20) {
					batchOrder2.put(orderDest, batchOrder2.get(orderDest) + 1);
					batchList.put(key, 4);
				}else {
					batchList.put(key, -1);
				}
				
				break;
				
			case "YYR":
				if(batchOrder1.get(orderDest)<20) {
					batchOrder1.put(orderDest, batchOrder1.get(orderDest) + 1);
					batchList.put(key, 2);
				}else if(batchOrder2.get(orderDest)<20) {
					batchOrder2.put(orderDest, batchOrder2.get(orderDest) + 1);
					batchList.put(key, 5);
				}else {
					batchList.put(key, -1);
				}
	
				break;
	
			default:
				break;
		} 
		
	}
	
	public void printSchedule() {
		FlightInfo fi = new FlightInfo();
		
		fi.setInfo();
		
		//print the scheduled orders		
		for (Map.Entry<String,Integer> order : batchList.entrySet()) {
			if(order.getValue() == -1) {
				System.out.println("order: "+order.getKey()+", flightNumber: not scheduled");
			}else {
				int index = order.getValue();
				System.out.println("order: "+order.getKey()+", flightNumber: "+fi.ft[index].getFlight_no()+", departure: "+fi.ft[index].getDeparture()+", arrival: "+fi.ft[index].getDestination()+", day: "+fi.ft[index].getDay());
			}
		}
		
	}
}