package com.example.demo.entity;

import java.util.Date;

public class WeatherEntity {
	// id,rev
	private String _id;

	private String _rev;
	
	// docType
	private String docType = "weather";
	
	// city,updatetime,weather,temperature,wind
    /**
     * 
     */
    private String city;
    private String updatetime;
    private String weather;
    private String temperature;
    private String wind;
    
	
	public String get_id() {
		return _id;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	
}
