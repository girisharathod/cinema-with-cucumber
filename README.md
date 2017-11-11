# Introduction
In any applciation that is build on Services Oriented Architecture(SOA), the functional/end-to-end tests can quickly grow out of hand and become unmanagable. This is working sample application example that demonstrates the best practices that you can follow to make your functional end to end tests more solid, reliable and scalable. 

# Functional features of application for which the tests are written - Please read. 
This is an application around Cinema. So in Cinema there are movies, there are theaters when movies run, shows for the movies and user of the application could book a ticket online to reserve a movie ticket. Also, every week, the new movie releases that needs to added into the system and add the show level details . 

So in SOA world, this could be translated into a ticket booking service (API) that ticket booking UI will internally call. And obviously, there will be services (API) to adda nore movie into the system and add shows. 

Pls Note : The APIs that I'm testing here are mock API calls that were build using PostMan. Postman allows only 1000 free mock calls before will ask for an upgrade that I'm not planning to pay for ;) . So please call this tests only on need basis so that others get a chance to use this application. 

# How to Run
- Make sure Maven is installed and in path. 
- clone this project. 
- cd to the root folder
- command to run all tests --> mvn install -Dtest.env=sit
- command to run the specific test(s) --> mvn install -Dcucumber.options="--tags @ws" -Dtest.env=sit


# Features
- Uses Spring Dependency Injection (DI).
- Java + Cucumber + Spring
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
