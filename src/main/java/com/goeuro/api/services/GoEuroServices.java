package com.goeuro.api.services;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

import com.goeuro.common.model.City;

public interface GoEuroServices {
	@GET("/api/v2/position/suggest/en/{name}")
	public List<City> findCityByName(@Path("name") String name);
}
