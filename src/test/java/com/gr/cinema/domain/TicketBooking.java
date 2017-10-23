package com.gr.cinema.domain;

public class TicketBooking {
	
	String bookingConfNumber;
	String showId;
	String showStartTime;
	String membershipId;
	Integer tktQty;
	String tktType;
	CreditCard creditCard;
	
	
	public String getBookingConfNumber() {
		return bookingConfNumber;
	}
	public void setBookingConfNumber(String bookingConfNumber) {
		this.bookingConfNumber = bookingConfNumber;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public String getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}
	public Integer getTktQty() {
		return tktQty;
	}
	public void setTktQty(Integer tktQty) {
		this.tktQty = tktQty;
	}
	public String getTktType() {
		return tktType;
	}
	public void setTktType(String tktType) {
		this.tktType = tktType;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	public String getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(String showStartTime) {
		this.showStartTime = showStartTime;
	}
	
}
