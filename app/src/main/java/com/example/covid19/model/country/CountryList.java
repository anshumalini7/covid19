package com.example.covid19.model.country;

import com.google.gson.annotations.SerializedName;

public class CountryList {

	@SerializedName("Country")
	private String country;

	@SerializedName("Slug")
	private String slug;

	@SerializedName("ISO2")
	private String iSO2;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setISO2(String iSO2){
		this.iSO2 = iSO2;
	}

	public String getISO2(){
		return iSO2;
	}

	@Override
 	public String toString(){
		return country;
//			"MainCounrtyResponse{" +
//			"country = '" + country + '\'' +
//			",slug = '" + slug + '\'' +
//			",iSO2 = '" + iSO2 + '\'' +
//			"}";
		}
}