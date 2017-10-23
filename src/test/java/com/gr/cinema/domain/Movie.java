package com.gr.cinema.domain;

public class Movie {

	String movieId;
	String name;
	String rating;
	String duration;
	String mainCast;
	
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getMainCast() {
		return mainCast;
	}
	public void setMainCast(String mainCast) {
		this.mainCast = mainCast;
	}
	
	public void reset() {
		movieId = null;
		name = null;
		rating = null;
		duration = null;
		mainCast = null;
	}
	
}
