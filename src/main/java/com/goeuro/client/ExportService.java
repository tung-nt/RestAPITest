package com.goeuro.client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.goeuro.common.model.City;

public class ExportService {
	public void generateCsvFile(String fileName, List<City> cities)
    {
		try{
			FileWriter writer = new FileWriter(fileName, true);
			
			if(!new File(fileName).exists()){
				writer.append("ID");
				writer.append(',');
				writer.append("Name");
				writer.append(',');
				writer.append("Type");
				writer.append(',');
				writer.append("Latitude");
				writer.append(',');
				writer.append("Longitude");
				writer.append('\n');
			}
			
			for (City city : cities) {
				writer.append(city.getId() != null ? city.getId().toString() : "");
				writer.append(',');
				writer.append(city.getName());
				writer.append(',');
				writer.append(city.getType());
				writer.append(',');
				if(city.getGeoPosition() != null){
					writer.append(city.getGeoPosition().getLatitude() != null ? city.getGeoPosition().getLatitude().toString() : "");
					writer.append(',');
					writer.append(city.getGeoPosition().getLongitude() != null ? city.getGeoPosition().getLongitude().toString() : "");
					writer.append('\n');
				}
				else {
					writer.append(',');
					writer.append('\n');
				}
			}
			
			writer.flush();
			writer.close();
		} catch (IOException e){
			System.out.println("Can't write to file: "+e.getMessage());
		}
    }
}
