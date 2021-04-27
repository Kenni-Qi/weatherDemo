package com.example.demo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.impl.TestDaoImpl;
import com.example.demo.entity.WeatherEntity;
import com.example.demo.service.TestService;




@Service("testServiceImpl")
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDaoImpl testDaoImpl;
	
	
	@Override
	public WeatherEntity getWeather(String cityValue) throws IOException, ParseException {
		
		WeatherEntity wentity = new WeatherEntity();
        String location = "";
        if(cityValue.equals("Sydney")) {
        	wentity.setCity("Sydney");
        	location = "151.23,-33.85";
        }
        else if(cityValue.equals("Melbourne")) {
        	 wentity.setCity("Melbourne");
	         location = "144.87,-37.87";
        }
        else if(cityValue.equals("Wollongong")) {
        	 wentity.setCity("Wollongong");
	         location = "150.88,-34.43";
        }
        else {
        	wentity.setUpdatetime("");
        	wentity.setTemperature("");
        	wentity.setWeather("");
        	wentity.setWind("");
            return wentity;
        }
		
		StringBuilder sb=new StringBuilder();
		String key = "6741966bb4cf4896844d423847c2bad1";
		try {
		URL url = new URL("https://devapi.qweather.com/v7/weather/now?location="+ location +"&key="+ key +"");
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		GZIPInputStream gzin = new GZIPInputStream(is);
		InputStreamReader isr = new InputStreamReader(gzin, "utf-8");
		BufferedReader reader = new BufferedReader(isr);
		String line = null;
		while((line=reader.readLine())!=null)
			sb.append(line+" ");
		reader.close();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
    	JSONObject obj = JSON.parseObject(sb.toString());
    	String updateTime = obj.getString("updateTime").replaceAll("T"," ");
    	wentity.setUpdatetime(updateTime);
    	JSONObject jsonObj = JSON.parseObject(obj.getString("now"));
    	wentity.setTemperature(jsonObj.getString("temp")+"℃");
    	wentity.setWeather(jsonObj.getString("text"));
    	wentity.setWind(jsonObj.getString("windSpeed")+"km/h");
	
        return wentity;
	}
	
}
