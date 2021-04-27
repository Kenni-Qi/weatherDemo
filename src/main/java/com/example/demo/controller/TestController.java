package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.WeatherEntity;
import com.example.demo.service.impl.TestServiceImpl;
import com.google.gson.Gson;


@Controller
@Scope("prototype")
public class TestController {
	
	@Autowired
	TestServiceImpl testServiceImpl;
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "Welcome Sales Springboot World！！";
	}
	
	/**
	 * cityValue、AJAX Request
	 *
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @param String cityValue
	 * @return
	 * @throws IOException
	 * @throws ParseException 
	 */
	
	@RequestMapping(value = "/getWeatherInfo", method = RequestMethod.POST)
	public void getWeatherInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam String cityValue)
			throws IOException, ParseException {
		response.setContentType("text/text;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		WeatherEntity weEntity = testServiceImpl.getWeather(cityValue);
		Gson gson = new Gson();
//		String toPrintStr = URLEncoder.encode(gson.toJson(weEntity.getCity()), "utf-8");
		String toPrintStr = gson.toJson(weEntity);
		System.out.println(toPrintStr);
		writer.print(toPrintStr);
		writer.close();
	}
	
	@RequestMapping("/list")
    public ModelAndView List(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mov = new ModelAndView();
		WeatherEntity weEntity = new WeatherEntity();
		mov.addObject("weEntity", weEntity);
		mov.setViewName("/list");

		return mov;
	}
	
}
