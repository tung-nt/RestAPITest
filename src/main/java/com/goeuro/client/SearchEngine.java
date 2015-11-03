package com.goeuro.client;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goeuro.api.services.GoEuroServices;
import com.goeuro.common.model.City;

public class SearchEngine {
	public static final String BASE_URL = "http://api.goeuro.com";
	private GoEuroServices services;

	public SearchEngine(){
		RestAdapter restAdapter = new RestAdapter.Builder()
	    .setEndpoint(BASE_URL)
	    .setConverter(new JacksonConverter(new ObjectMapper()))
	    .build();
		this.services = restAdapter.create(GoEuroServices.class);
	}
	
	public List<City> findCityByName(String name){
		return this.services.findCityByName(name);
	}
}
