package com.goeuro.common.model;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter @Setter
public class City {
	@JsonProperty("_id")
	private Long id;
	private String key;
	private String name;
	private String fullName;
	@JsonProperty("iata_airport_code")
	private String airportCode;
	private String type;
	private String country;
	@JsonProperty("geo_position")
	private GeoPosition geoPosition;
	private Long locationId;
	private Boolean inEurope;
	private String countryCode;
	private Boolean coreCountry;
	private Double distance;
}
