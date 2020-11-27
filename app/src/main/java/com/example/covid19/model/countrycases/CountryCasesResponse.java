package com.example.covid19.model.countrycases;

import com.google.gson.annotations.SerializedName;

public class CountryCasesResponse{

	@SerializedName("CityCode")
	private String cityCode;

	@SerializedName("Recovered")
	private int recovered;

	@SerializedName("Active")
	private int active;

	@SerializedName("Country")
	private String country;

	@SerializedName("Deaths")
	private int deaths;

	@SerializedName("Lon")
	private String lon;

	@SerializedName("City")
	private String city;

	@SerializedName("Confirmed")
	private int confirmed;

	@SerializedName("CountryCode")
	private String countryCode;

	@SerializedName("Province")
	private String province;

	@SerializedName("Lat")
	private String lat;

	@SerializedName("Date")
	private String date;

	public void setCityCode(String cityCode){
		this.cityCode = cityCode;
	}

	public String getCityCode(){
		return cityCode;
	}

	public void setRecovered(int recovered){
		this.recovered = recovered;
	}

	public int getRecovered(){
		return recovered;
	}

	public void setActive(int active){
		this.active = active;
	}

	public int getActive(){
		return active;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setDeaths(int deaths){
		this.deaths = deaths;
	}

	public int getDeaths(){
		return deaths;
	}

	public void setLon(String lon){
		this.lon = lon;
	}

	public String getLon(){
		return lon;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setConfirmed(int confirmed){
		this.confirmed = confirmed;
	}

	public int getConfirmed(){
		return confirmed;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setProvince(String province){
		this.province = province;
	}

	public String getProvince(){
		return province;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	@Override
 	public String toString(){
		return 
			"CountryCasesResponse{" + 
			"cityCode = '" + cityCode + '\'' + 
			",recovered = '" + recovered + '\'' + 
			",active = '" + active + '\'' + 
			",country = '" + country + '\'' + 
			",deaths = '" + deaths + '\'' + 
			",lon = '" + lon + '\'' + 
			",city = '" + city + '\'' + 
			",confirmed = '" + confirmed + '\'' + 
			",countryCode = '" + countryCode + '\'' + 
			",province = '" + province + '\'' + 
			",lat = '" + lat + '\'' + 
			",date = '" + date + '\'' + 
			"}";
		}
}