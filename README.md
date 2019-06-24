# Hourly Weather FOrecast for Given Zip code!

This project exposes end point to know the hourly weather forecasts for a given zipcode in United states.


# Project Modules
- *weather-forecast-api*


*weather-forecast-api :*
    This module contains Rest endpoint to consume to get the hourly weather forecasts.

## Pre-requisites

Must have JDK 8, Maven and  installed locally in order to run these modules locally.

Plugins like Cucumber , Gherkin are required to execute automation tests from ide

## Usage

clone repository "https://github.com/ytram99/m3bi_assessment"

Perform mvn clean install


## Test

To Run WeatherForeCastApplication module:

From the IDE go to WeatherForecastApplication.java file located in weather-forecast-api module and right click on the file and click run button

OR

java -jar .jar com.aexp.lending.loan.accounts.LoanAccountApplication.java

## Test Automation

To run/install the automation project, Start the application and Run WeatherForecastServiceTestRunner class.



## API Documentation
http://localhost:8080/swagger-ui.html#/weather-controller