package com.demo.WeatherApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.WeatherApi.client.WeatherClient;

@Service
public class WeatherService {

	@Autowired
	WeatherClient weatherClient;
	
	public String getWeatherDetailsByCityName(String city) {
		return weatherClient.getWeatherDetailsByCityName(city); 
	}

	public Object getWeatherDetailsByCoordinates(String coordinates) {
		return weatherClient.getWeatherDetailsByCoordinates(coordinates); 
	}

}
