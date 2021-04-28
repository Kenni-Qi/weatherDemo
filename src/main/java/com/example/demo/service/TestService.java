package com.example.demo.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import com.example.demo.entity.WeatherEntity;

public interface TestService {

	abstract public WeatherEntity getWeather(String cityValue) throws IOException, ParseException;
	
	abstract public String getCityListJson() throws IOException, ParseException;
	
	abstract public Connection getConnection() throws URISyntaxException, SQLException;

}

