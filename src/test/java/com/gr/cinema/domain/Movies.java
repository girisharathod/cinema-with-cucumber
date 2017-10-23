package com.gr.cinema.domain;

import java.util.ArrayList;
import java.util.List;

public class Movies {
	
	public List<Movie> movies = new ArrayList<Movie>();

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
