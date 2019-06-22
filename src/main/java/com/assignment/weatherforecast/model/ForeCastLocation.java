package com.assignment.weatherforecast.model;

import java.util.List;


import lombok.Data;

@Data
public class ForeCastLocation {
	
	private String country;
	
	private String city;
	
	private String state;
	
	private List<Forecast> forecast;

}
