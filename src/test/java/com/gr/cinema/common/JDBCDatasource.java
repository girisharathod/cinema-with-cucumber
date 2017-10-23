package com.gr.cinema.common;

import java.util.HashMap;
import java.util.Map;

public class JDBCDatasource {

	private Map<String,String> movieMap;
	private Map<String,String> theaterMap;
	
	public JDBCDatasource() {
		movieMap = new HashMap<String,String>();
		movieMap.put("Star Wars", "a6543");
		
		theaterMap = new HashMap<String,String>();
		theaterMap.put("Frank Theater", "t1234");
		theaterMap.put("Bucks Theater", "t2345");
		
	}
	
	public String fetchMovieIdFromName(String movieName) {
		return movieMap.get(movieName);
	}
	
	public String fetchTheaterIdFromName(String theaterName) {
		return theaterMap.get(theaterName);
	}
	
	
	public Double fetchTicketPrice(String showId) {
		return 12.50;
	}
	
	public Integer fetchTicketsReserved(String bookingId) {
		return 2;
	}
	
	public void deleteShowFromDB(String ShowId) {
		System.out.println("Show "+ShowId+"cleaned up from the DB");
	}
	
	public void deleteMovieFromDB(String movieId) {
		System.out.println("Movie "+movieId+"cleaned up from the DB.");
	}
}
