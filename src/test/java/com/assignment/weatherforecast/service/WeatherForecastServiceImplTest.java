package com.assignment.weatherforecast.service;

import com.assignment.weatherforecast.exception.ServiceException;
import com.assignment.weatherforecast.model.WeatherForecastResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class WeatherForecastServiceImplTest {

    @Mock
    private RestTemplate restTemplate;


    @InjectMocks
    WeatherForecastServiceImpl weatherForecastService;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(weatherForecastService,"endPointUrl","https://weather.cit.api.here.com/weather/1.0/report.json");
        ReflectionTestUtils.setField(weatherForecastService,"accessId","MS4giXoZF2F5US8oEYnD");
        ReflectionTestUtils.setField(weatherForecastService,"accessCode","f0NpJSGSpoo2Dj-6UkMvYA");
    }

    @Test
    public void testGetHourlyForecasts() throws ServiceException {

        ResponseEntity<WeatherForecastResponse> responseEntity = new ResponseEntity<WeatherForecastResponse>(new WeatherForecastResponse(),HttpStatus.OK);

        when(restTemplate.exchange(any(),any(ParameterizedTypeReference.class))).thenReturn(responseEntity);
        WeatherForecastResponse response =  weatherForecastService.getHourlyForecasts("85027");
        Assert.assertNotNull(response);
    }

    @Test(expected = ServiceException.class)
    public void testGetHourlyForecastsException() throws ServiceException {
        when(restTemplate.exchange(any(),any(ParameterizedTypeReference.class))).thenThrow(Exception.class);
        WeatherForecastResponse response =  weatherForecastService.getHourlyForecasts("85027");

    }

}
