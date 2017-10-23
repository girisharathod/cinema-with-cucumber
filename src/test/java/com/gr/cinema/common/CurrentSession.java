package com.gr.cinema.common;

import com.gr.cinema.domain.Movie;
import com.gr.cinema.domain.Show;

public class CurrentSession {
	private Show show;
	private Movie movie;
	
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	public void resetSession() {
		if (show != null) show.reset();
		if (movie != null) movie.reset();
	}
	
	
}
