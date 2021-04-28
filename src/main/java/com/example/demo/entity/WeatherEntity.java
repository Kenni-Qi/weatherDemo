package com.example.demo.entity;

public class WeatherEntity {
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
    private String cityListJson;
    
	
	public String getCityListJson() {
		return cityListJson;
	}
	public void setCityListJson(String cityListJson) {
		this.cityListJson = cityListJson;
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
	
}
