package com.assignment.weatherforecast.model;

import java.util.Date;

import com.assignment.weatherforecast.util.DateFormatSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class WeatherForecastResponse {

	private HourlyForecasts hourlyForecasts;
	
	@JsonSerialize(using = DateFormatSerializer.class)
	private Date feedCreation;
	
	
	
}
