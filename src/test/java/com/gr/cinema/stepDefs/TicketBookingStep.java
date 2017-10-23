package com.gr.cinema.stepDefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.gr.cinema.common.CurrentSession;
import com.gr.cinema.common.JDBCDatasource;
import com.gr.cinema.common.JsonUtils;
import com.gr.cinema.domain.BookingConfirmation;
import com.gr.cinema.domain.CreditCard;
import com.gr.cinema.domain.Show;
import com.gr.cinema.domain.TicketBooking;
import com.gr.framework.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class TicketBookingStep extends TestBase{

	@Autowired
	JDBCDatasource jdbcDatasource;
	
	@Autowired
	CurrentSession session;
	
	TicketBooking tb ;
	BookingConfirmation bookingConf;
	
	Show show;
		
	@Before
	public void setup() {
		loadEnv();
	}
	
	@After
	public void cleanup() {
		session.resetSession();
	}
	
	
	@And("^I select the show starting around '(.+)'$")
	public void selectTheShow(String timing) {
		show = session.getShow();
		
		if (tb == null) {
			tb = new TicketBooking();
		}
		
		tb.setShowId(show.getShowId());
		tb.setShowStartTime(timing);
	}
	
	@And("^I add my credit card info$")
	public void updateCreditCardDetails(DataTable ccDetailsTable) {
		
		List<Map<String,String>> ccList = ccDetailsTable.asMaps(String.class, String.class);
		
		CreditCard cc = new CreditCard(); 
		
		for(Map<String,String> ccMap : ccList) {
			cc.setFullName(ccMap.get("fullName"));
			cc.setCardNumber(ccMap.get("ccNumber"));
			cc.setExpiry(ccMap.get("expDt"));
			cc.setCvv(new Integer(ccMap.get("cvv")));
		}
		
		tb.setCreditCard(cc);
	}

	
	@And("^I add my membership id '(.+)'$")
	public void setMembership(String membershipId) {
		tb.setMembershipId(membershipId);
	}
	
	
	@And("^I select '(.+)' '(.+)' tickets$")
	public void setTicketNumAndType(Integer tktNum , String tktType) {
		tb.setTktQty(tktNum);
		tb.setTktType(tktType);
	}
	
	@And("^I submit the transaction$")
	public void submitTransaction() {
		
		String tktBookingJsonStr = JsonUtils.toJsonString(tb);
		
		String respStr = executePOST(envMap.get("url.ticketBooking"), tktBookingJsonStr);
		
		bookingConf = JsonUtils.fromJsonStr(respStr, BookingConfirmation.class);
				
	}
	
	@When("^I get a valid confirmation number$")
	public void confirmBookingConfNumber() {
		
		Assert.assertTrue("The booking confirmation cannot be null",bookingConf.getBookingConfNum() != null);
	}
	
	@And("I validate that I was charged a correct amount")
	public void validationOfTicketAmount() {
		
		Double totalTktAMount = tb.getTktQty() * jdbcDatasource.fetchTicketPrice(tb.getShowId());
		Assert.assertTrue("The total amount charged for the ticket is not accurate. ",totalTktAMount.equals(bookingConf.getAmount()));
		
	}
	
	@And("^I validate that '(.+)' seats was reserved for me$")
	public void validateSeats(Integer noOfSeats) {
		
		Integer numberOfReservedSeats = jdbcDatasource.fetchTicketsReserved(tb.getBookingConfNumber());
		
		Assert.assertTrue("The seats are not reserved for the current booking.",numberOfReservedSeats.equals(noOfSeats));
		
	}
	
	@And("^I validate the show timings on my tickets$")
	public void validationOfShowTimings() {
		
		Assert.assertTrue("The show timings doesn't match",tb.getShowStartTime().equals(bookingConf.getShowTime()));
		
	}
	
	@And("^I cleanup all the data after the test$")
	public void cleanupTestData() {
		jdbcDatasource.deleteMovieFromDB(show.getMovieId());
		jdbcDatasource.deleteShowFromDB(show.getShowId());
	}
	
}
