package com.gr.cinema.domain;

public class BookingConfirmation {

	String bookingConfNum;
	Double amount;
	String showTime;
	String cinemaHallNumber;
	
	
	public String getBookingConfNum() {
		return bookingConfNum;
	}
	public void setBookingConfNum(String bookingConfNum) {
		this.bookingConfNum = bookingConfNum;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getCinemaHallNumber() {
		return cinemaHallNumber;
	}
	public void setCinemaHallNumber(String cinemaHallNumber) {
		this.cinemaHallNumber = cinemaHallNumber;
	}
	
}
