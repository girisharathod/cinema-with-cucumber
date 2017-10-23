@MovieTest
Feature: Ticket Booking Tests 

  Scenario: Setup Movie
	Given I want to setup a new movie 
	When I setup a new movie
		| name 			| rating | duration 		| mainCast 					|
		| Star Wars		| PG-13	 | 2hrs 20 min	| Daisy Ridley, John Boyega 	|
	Then I validate that the the new movie is setup correctly.	
	
  	