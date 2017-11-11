# Introduction
In any applciation that is build on Services Oriented Architecture(SOA), the functional/end-to-end tests can quickly grow out of hand and become unmanagable. This is working sample application example that demonstrates the best practices that you can follow to make your functional end to end tests more solid, reliable and scalable. 

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
