package com.example.demo;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.WeatherEntity;
import com.example.demo.service.impl.TestServiceImpl;
import com.google.gson.Gson;

@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
	@Autowired
	TestServiceImpl testServiceImpl;

	@Test
	public void contextLoads() throws IOException, ParseException {
		String cityValue = "Sydney";
		WeatherEntity entity = testServiceImpl.getWeather(cityValue);
		Gson gson = new Gson();
		String toPrintStr = gson.toJson(entity);
		System.out.println(toPrintStr);
	    System.out.println("TEST SUCCESSFULLY");
	}

}
