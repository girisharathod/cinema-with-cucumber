@TicketBookingTest
Feature: Ticket Booking Tests 

  Scenario Outline: Ticket Booking Test
  	Given I setup a new movie
		| name 			| rating | duration 		| mainCast 					|
		| Star Wars		| PG-13	 | 2hrs 20 min	| Daisy Ridley, John Boyega 	|
  	And I setup the movie shows 
  		| movieName | theaterName	|	showStartTimes 				|
  		| Star Wars	| Frank Theater	|	11.30, 14.00, 19.00, 22.00	|
  	
  	When I search the shows for the movie '<movieName>' at '<theaterName>'
  	And I select the show starting around '<showTime>'
  	And I add my credit card info
  		| fullName 			| ccNumber	 			| expDt	| cvv 	|
		| Thomas The Train	| 3333-4444-5555-7777	| 08/27	| 123 	|
  	And I add my membership id 'm987654321'
  	And I select '2' 'adult' tickets 
  	And I submit the transaction
  	
  	Then I get a valid confirmation number
  	And I validate that I was charged a correct amount
  	And I validate that '2' seats was reserved for me
  	And I validate the show timings on my tickets
  	And I cleanup all the data after the test
  	
  	Examples:
  	| movieName	|	theaterName		| showTime	|
  	| Star Wars	|	Frank Theater	|	14.00	|
  	