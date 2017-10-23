package com.gr.cinema.stepDefs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.gr.cinema.common.JsonUtils;
import com.gr.cinema.domain.Movie;
import com.gr.cinema.domain.Movies;
import com.gr.framework.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MovieStep extends TestBase{

	Movies m_movies;
	
	@Before
	public void setup() {
		loadEnv();
	}
	
	@After
	public void cleanup() {
		session.resetSession();
	}
	
	@Given("^I want to setup a new movie")
	public void startSetupOfNewMovie() {
		if(m_movies == null) {
			m_movies = new Movies();
		}
	}
	
	@When("^I setup a new movie$")
	public void setupNewMovie(DataTable moviesDataTable) {
		if(m_movies == null) {
			m_movies = new Movies();
		}

		Movie movie = null;
		
		List<Map<String, String>> movieMapList = moviesDataTable.asMaps(String.class, String.class);
				
		for(Map<String, String> movieData : movieMapList) {
			movie = new Movie();
			movie.setName(movieData.get("name"));
			movie.setDuration(movieData.get("duration"));
			movie.setRating(movieData.get("rating"));
			movie.setMainCast(movieData.get("mainCast"));
			m_movies.getMovies().add(movie);
		}

		String jsonString = JsonUtils.toJsonString(m_movies);
		
		//System.out.println("Request Payload -\n"+jsonString);
		
		String response = executePOST(envMap.get("url.movies"), jsonString);
		
		Movies moviesObj = JsonUtils.fromJsonStr(response, Movies.class);
		
		List<Movie> movieList = moviesObj.getMovies();
		for(int i = 0 ; i < movieList.size() ; i++) {
			Movie movieObj = movieList.get(i);
			System.out.println("Movie Id -"+movieObj.getMovieId());
			Assert.assertTrue("The Id in the response cannot be null",movieObj.getMovieId() != null);
			m_movies.getMovies().get(i).setMovieId(movieObj.getMovieId());
		}
		
	}
	
	@Then("^I validate that the the new movie is setup correctly.$")
	public void validateNewMovieSetup() {
		
		Map<String,String> paramMap = new HashMap<String,String>();
		
		for(int i = 0 ; i < m_movies.getMovies().size() ; i++) {
			
			String urlGET = envMap.get("url.movies")+"/"+m_movies.getMovies().get(i).getMovieId();
			
			String movieJson = executeGET(urlGET, paramMap);
			
			Movies fetchedMovies = JsonUtils.fromJsonStr(movieJson, Movies.class);
		
			Assert.assertTrue( "Issue with persisting the Movie data.",
					compareMovies(m_movies.getMovies().get(i) , fetchedMovies.getMovies().get(i)));
		}

	}
	
	public boolean compareMovies(Movie m1 , Movie m2) {
		
		boolean moviesMatch = true;
		
		if (m1 == null || m2 == null) {
			return false;
		}
		
		if (m1.getMovieId() != null && m2.getMovieId() != null) {
			if (! m1.getMovieId().equals(m2.getMovieId())) {
				moviesMatch = false;
			}
		}
		
		if (m1.getName() != null && m2.getName() != null) {
			if (! m1.getName().equals(m2.getName())) {
				moviesMatch = false;
			}
		}else {
			moviesMatch = false;
		}
		
		if (m1.getDuration() != null && m2.getDuration() != null) {
			if (! m1.getDuration().equals(m2.getDuration())) {
				moviesMatch = false;
			}
		}else {
			moviesMatch = false;
		}
		
		if (m1.getMainCast() != null && m2.getMainCast() != null) {
			if (! m1.getMainCast().equals(m2.getMainCast())) {
				moviesMatch = false;
			}
		}else {
			moviesMatch = false;
		}
		
		return moviesMatch;
	}
}
