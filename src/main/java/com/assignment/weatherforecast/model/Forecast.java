package com.assignment.weatherforecast.model;

import java.util.Date;

import com.assignment.weatherforecast.util.DateFormatSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class Forecast {
	
	private String temperature;
	@JsonSerialize(using = DateFormatSerializer.class)
	private Date utcTime;

}
