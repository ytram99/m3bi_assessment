@Regression
Feature: HourlyForecast Weather service API

  Background:
    * def automUtil = 'Initialization'


  Scenario: Hourly Weather Forecast for 85027
    * def weatherServiceUri = 'http://localhost:8080/weatherservices/v1/forecast/hourly?zipcode=85027';
    * print weatherServiceUri
    Given url weatherServiceUri
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And print response
    And match response.hourlyForecasts.forecastLocation.city == 'Phoenix'
    And match response.hourlyForecasts.forecastLocation.state == 'Arizona'

  Scenario: Hourly Weather Forecast for 28105
    * def weatherServiceUri = 'http://localhost:8080/weatherservices/v1/forecast/hourly?zipcode=28105';
    * print weatherServiceUri
    Given url weatherServiceUri
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And print response
    And match response.hourlyForecasts.forecastLocation.city == 'Matthews'
    And match response.hourlyForecasts.forecastLocation.state == 'North Carolina'

  Scenario: Hourly Weather Forecast for Invalid zip code
    * def weatherServiceUri = 'http://localhost:8080/weatherservices/v1/forecast/hourly?zipcode=2810';
    * print weatherServiceUri
    Given url weatherServiceUri
    And header Content-Type = 'application/json'
    When method GET
    Then status 500
    And print response
    And match response == 'getHourlyWeatherForecast.zipCode: size must be between 5 and 5'
