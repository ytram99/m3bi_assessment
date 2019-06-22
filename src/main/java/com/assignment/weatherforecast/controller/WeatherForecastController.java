package com.assignment.weatherforecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.weatherforecast.exception.ServiceException;
import com.assignment.weatherforecast.model.WeatherForecastResponse;
import com.assignment.weatherforecast.service.WeatherForecastService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("weatherservices/v1/forecast")
@Slf4j
public class WeatherForecastController {
	
	@Autowired
	WeatherForecastService weatherForeCastService;
	
	@RequestMapping(value = "hourly", method = RequestMethod.GET)
	public WeatherForecastResponse getHourlyWeatherForecast(@RequestParam("zipcode") String zipCode) throws ServiceException{
		System.out.println("In Logger");
		log.info("Weather forecast request received for -> zipCode="+zipCode);
		
		WeatherForecastResponse weatherForecastDetails = weatherForeCastService.getHourlyForecasts(zipCode);
		
		log.info("Weather forecast request received for -> zipCode="+zipCode);
		
		return weatherForecastDetails;
	}
	

}
