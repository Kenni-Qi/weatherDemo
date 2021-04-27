package com.example.demo.service;

import java.io.IOException;
import java.text.ParseException;

import com.example.demo.entity.WeatherEntity;

public interface TestService {

	abstract public WeatherEntity getWeather(String cityValue) throws IOException, ParseException;

}

