# Introduction
In any software applciation that is build on Services Oriented Architecture(SOA) the functional/end-to-end tests can quickly grow out of hand and become unmanagable. This is working example that demonstrates the best practices that you can follow to make your functional end to end tests more solid, reliable and scalable. 

# Functional features of application for which the tests are written - Please read. 
This is an application around Cinema. So in Cinema there are movies, there are theaters where movies run, shows for the movies and user of the application could book a ticket online to reserve a movie ticket. Also, every week, the new movie releases. Those movies and the corresponding shows needs to be added to the system. 

So in SOA world, this could be translated into a ticket booking service (API) that ticket booking UI will internally call. And obviously, there will be services (API) to add a new movie and corresponding shows into the system. 

Pls Note : The APIs that I have build for this porpose are mock API calls using PostMan mock service (https://www.getpostman.com/docs/postman/mock_servers/setting_up_mock). Postman allows only 1000 free mock calls before it will ask for an upgrade that I'm not planning to pay for ;) . So please call this tests only on need basis so that others get a chance to use this as well. 

# How to Run

From Command Line 
- Make sure Maven is installed and in path. 
- clone this project. 
- cd to the root folder
- command to run all tests --> mvn install -Dtest.env=sit
- command to run the specific test(s) --> mvn install -Dcucumber.options="--tags @ws" -Dtest.env=sit

From IDE ( eclipse in this case)
- Import the project as a 'existing project into workspace' 
- To invoke a single test, you will need to pass in the environment where you want to run this test. Follow below steps.
  -- For the first time Run the test (the file that ends with Test) as junit test - it will fail.
  -- Go to 'Run Configurations' for that test, under 'Arguments' tab and under VM Arguments, pass in -Dtest.env=sit
  -- Hit run.  
  

# Features
- Uses Spring Dependency Injection (DI).
- Java + Cucumber + Spring
- This has a build it 'Session' that can be used to share the state between the test steps. 
- Write once and run in any env. - externalized the enviranment veriables. 
- Runnable on a command line - jenkins compatable. 
- Group and execute the tests usint tags. 
- Focusus on WebServices API tests.  


# General Tips to make your Functional End To End tests Scalable
- Ability to execute the tests, as is, in any environment.
- Ability to execute all or selective tests (based on test groups) through the command line. 
- Integration of E2E tests with the CI system. 
- Ability to share the data between the test steps.
- Domain objects for serialization and de-serialization.
- Separation of test steps from the framework code.
