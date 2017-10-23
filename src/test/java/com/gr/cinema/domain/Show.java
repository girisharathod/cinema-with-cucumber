package com.gr.cinema.domain;

public class Show {

	private String showId;
	private String movieId;
	private String theaterId;
	private String showStartTimes;
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}
	public String getShowStartTimes() {
		return showStartTimes;
	}
	public void setShowStartTimes(String showStartTimes) {
		this.showStartTimes = showStartTimes;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}

	public void reset() {
		showId = null;
		movieId = null;
		theaterId = null;
		showStartTimes = null;
	}
	
	
}
