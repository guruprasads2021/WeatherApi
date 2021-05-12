package com.demo.WeatherApi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class WeatherClient {

	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${api.CityUri}") 
	private String cityUri;
	
	@Value("${api.CoordinatesUri}") 
	private String coordinatesUri;
	
	
	@Cacheable(cacheNames = "cityWeather", key = "#city")
	public String getWeatherDetailsByCityName(String city) {
		 final String weatherByCityUri = cityUri+city;
			
		    String result = restTemplate.getForObject(weatherByCityUri, String.class);
		    return result;
	}


	public Object getWeatherDetailsByCoordinates(String lon, String lat) {
		
		 final String weatherByCoordinatesUri = coordinatesUri+"lon="+lon+"&lat="+lat;
		    String result = restTemplate.getForObject(weatherByCoordinatesUri, String.class);
		    return result;
	}
	
}
