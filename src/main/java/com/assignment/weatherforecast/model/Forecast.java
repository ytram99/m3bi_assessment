package com.assignment.weatherforecast.model;

import java.util.Date;

import lombok.Data;

@Data
public class Forecast {
	
	private String temperature;
	
	private Date utcTime;

}
