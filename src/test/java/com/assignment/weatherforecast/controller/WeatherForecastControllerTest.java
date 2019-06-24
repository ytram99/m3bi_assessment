package com.assignment.weatherforecast.controller;

import com.assignment.weatherforecast.exception.ServiceException;
import com.assignment.weatherforecast.model.WeatherForecastResponse;
import com.assignment.weatherforecast.service.WeatherForecastService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class WeatherForecastControllerTest {

    @Mock
    WeatherForecastService weatherForeCastService;

    @InjectMocks
    WeatherForecastController weatherForecastController;

    @Before
    public void setUp() throws ServiceException {

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetHourlyWeatherForecast() throws ServiceException {

        when(weatherForeCastService.getHourlyForecasts(anyString())).thenReturn(new WeatherForecastResponse());
        WeatherForecastResponse response =  weatherForecastController.getHourlyWeatherForecast("85027");
        assertNotNull(response);
    }

    @Test(expected = ServiceException.class)
    public void testGetHourlyWeatherForecastException() throws ServiceException {

        when(weatherForeCastService.getHourlyForecasts(anyString())).thenThrow(ServiceException.class);
        WeatherForecastResponse response =  weatherForecastController.getHourlyWeatherForecast("85027");
        assertNull(response);
    }
}
