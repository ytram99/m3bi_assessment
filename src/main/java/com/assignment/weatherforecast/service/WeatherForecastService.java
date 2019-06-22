package com.assignment.weatherforecast.service;

import com.assignment.weatherforecast.exception.ServiceException;
import com.assignment.weatherforecast.model.WeatherForecastResponse;

public interface WeatherForecastService {
	
	public WeatherForecastResponse getHourlyForecasts(String zipCode) throws ServiceException;
	
	public WeatherForecastResponse getDailyForecasts(String zipCode) throws ServiceException;
	
	

}
