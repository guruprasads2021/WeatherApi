package com.demo.WeatherApi.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.WeatherApi.Service.WeatherService;
import com.demo.WeatherApi.controller.*;;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	
	@GetMapping(path = "/{city}", produces = "application/json")
	public ResponseEntity<String> getWeather(@PathVariable String city) {

		String response = weatherService.getWeatherDetailsByCityName(city);
		return new ResponseEntity<>(response, OK);
	}
	
	@GetMapping(path = "/coordinate/{lon},{lat}", produces = "application/json")
	public ResponseEntity<String> getWeatherByCoordinates(@PathVariable String lon,@PathVariable String lat) {
		
		Object response = weatherService.getWeatherDetailsByCoordinates(lon, lat);
		return new ResponseEntity(response, OK);
	}
}
