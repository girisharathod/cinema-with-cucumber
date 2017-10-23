@ShowsTest
Feature: Shows Setup tests

  Scenario: Show time setup
  	Given I setup a new movie
		| name 			| rating | duration 		| mainCast 					|
		| Star Wars		| PG-13	 | 2hrs 20 min	| Daisy Ridley, John Boyega 	|
  	When I setup the movie shows 
  		| movieName | theaterName	|	showStartTimes 				|
  		| Star Wars	| Frank Theater	|	11.30, 14.00, 19.00, 22.00	|
  	Then I validate that the new show times are setup correctly
  	