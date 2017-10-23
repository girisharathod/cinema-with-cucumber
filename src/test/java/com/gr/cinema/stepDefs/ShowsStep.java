package com.gr.cinema.stepDefs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.gr.cinema.common.JsonUtils;
import com.gr.cinema.domain.Show;
import com.gr.framework.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ShowsStep extends TestBase{

	Show show;
	
	@Before
	public void setup() {
		loadEnv();
	}
	
	@After
	public void cleanup() {
		session.resetSession();
	}
	
	
	@Given("^I setup the movie shows$")
	public void setupshows(DataTable showData) {
		
		if ( show == null) {
			show = new Show();
		}
		
		List<Map<String, String>> showDataList = showData.asMaps(String.class, String.class);
		
		for(Map<String,String> showDataMap : showDataList) {
			show.setMovieId(jdbcDatasource.fetchMovieIdFromName(showDataMap.get("movieName")));
			show.setTheaterId(jdbcDatasource.fetchTheaterIdFromName(showDataMap.get("theaterName")));
			show.setShowStartTimes(showDataMap.get("showStartTimes"));
			
			String jsonString = JsonUtils.toJsonString(show);
			
			String responseStr;
			
			responseStr = executePOST(envMap.get("url.show"), jsonString);
						
			Show showResp = JsonUtils.fromJsonStr(responseStr, Show.class);
			
			System.out.println("Show Id -"+showResp.getShowId());
			
			Assert.assertTrue("The Id in the response cannot be null",showResp.getShowId() != null);
			
			show.setShowId(showResp.getShowId());
			
		}
	}
	
	@Then("^I validate that the new show times are setup correctly$")
	public void validateNewShowSetup() {

		Map<String,String> paramMap = new HashMap<String,String>();
				
		String urlGET = envMap.get("url.show")+"/"+show.getShowId();
		
		String showJson = executeGET(urlGET, paramMap);
		
		Show fetchedShows = JsonUtils.fromJsonStr(showJson, Show.class);
	
		Assert.assertTrue( "Issue with persisting the Show data.",compareShows(show , fetchedShows));
	}

	
	@And("^I search the shows for the movie '(.+)' at '(.+)'$")
	public void searchShowTimes(String movieName , String theaterName) {
		
		Map<String,String> paramMap = new HashMap<String,String>();
		
		paramMap.put("movieId", jdbcDatasource.fetchMovieIdFromName(movieName));
		paramMap.put("theaterId", jdbcDatasource.fetchTheaterIdFromName(theaterName));
		
		String showJson = executeGET(envMap.get("url.show"), paramMap);
		
		if(showJson == null) {
			Assert.fail("Received null response from the show time service. ");
		}
		
		Show fetchedShows = JsonUtils.fromJsonStr(showJson, Show.class);
	
		Assert.assertTrue("The Movie times cannot be null.",fetchedShows.getShowStartTimes() != null);
		
		session.setShow(fetchedShows);
		
	}
	
	
	public boolean compareShows(Show s1 , Show s2) {
		
		boolean showMatch = true;
		
		if (s1 == null || s2 == null) {
			return false;
		}
		
		if (s1.getShowId() != null && s2.getShowId() != null) {
			if (! s1.getShowId().equals(s2.getShowId())) {
				showMatch = false;
			}
		}
		
		if (s1.getMovieId()!= null && s2.getMovieId() != null) {
			if (! s1.getMovieId().equals(s2.getMovieId())) {
				showMatch = false;
			}
		}else {
			showMatch = false;
		}
		
		if (s1.getTheaterId() != null && s2.getTheaterId() != null) {
			if (! s1.getTheaterId().equals(s2.getTheaterId())) {
				showMatch = false;
			}
		}else {
			showMatch = false;
		}
		
		if (s1.getShowStartTimes() != null && s2.getShowStartTimes() != null) {
			if (! s1.getShowStartTimes().equals(s2.getShowStartTimes())) {
				showMatch = false;
			}
		}else {
			showMatch = false;
		}
		
		return showMatch;
	}
}
