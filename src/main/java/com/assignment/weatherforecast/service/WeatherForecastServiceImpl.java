package com.assignment.weatherforecast.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.assignment.weatherforecast.exception.ServiceException;
import com.assignment.weatherforecast.model.WeatherForecastResponse;
import com.assignment.weatherforecast.util.WeatherForecastUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherForecastServiceImpl implements WeatherForecastService{
	
	@Value("${weatherServiceEndpoint}")
	private String endPointUrl;
	
	@Value("${access_id}")
	private String accessId;
	
	@Value("${access_code}")
	private String accessCode;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public WeatherForecastResponse getHourlyForecasts(String zipCode) throws ServiceException {
	
		log.debug("Entered into "+WeatherForecastUtil.getMethodName(Thread.currentThread().getStackTrace()));
		
		ResponseEntity<WeatherForecastResponse> responseEntity = null;
		
		try
		{
			//Create the requestentity
			URI uri  = UriComponentsBuilder
				    .fromUriString(endPointUrl)
				    // Add query parameter
				    .queryParam("product", "forecast_hourly")
				    .queryParam("zipcode", zipCode)
				    .queryParam("oneobservation", "true")
				    .queryParam("app_id", accessId)
				    .queryParam("app_code", accessCode).build().encode().toUri();
			
			RequestEntity<?> requestEntity = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
			
			ParameterizedTypeReference<WeatherForecastResponse> responseType = new ParameterizedTypeReference<WeatherForecastResponse>() {
			};
			
			responseEntity = restTemplate.exchange(requestEntity, responseType);
			
			
		}
		catch(Exception ex)
		{
			log.error("Weather Service API Failed", ex);
			throw new ServiceException("Weather Service API Failed with error "+ex.getMessage());
		}
		
		log.debug("Exiting from "+WeatherForecastUtil.getMethodName(Thread.currentThread().getStackTrace()));
		
		return responseEntity.getBody();
	}

	@Override
	public WeatherForecastResponse getDailyForecasts(String zipCode) throws ServiceException {
		
		log.debug("Entered into "+WeatherForecastUtil.getMethodName(Thread.currentThread().getStackTrace()));
		
		
		log.debug("Exiting from "+WeatherForecastUtil.getMethodName(Thread.currentThread().getStackTrace()));
	
		
		return null;
	}

}
