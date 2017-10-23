package com.gr.cinema.stepDefs;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com/gr/cinema/features/MovieTest.feature"},
        glue = "com.gr.cinema.stepDefs",
        tags = {"@MovieTest"}
)
public class MovieTest {
}
