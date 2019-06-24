package com.assignment.Automation;

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@CucumberOptions(features = {"classpath:com/assignment/Automation/abc.feature"})
public class WeatherForecastServiceTestRunner {

}
