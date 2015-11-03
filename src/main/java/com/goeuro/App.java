package com.goeuro;

import java.net.URLEncoder;
import java.util.List;

import com.goeuro.client.ExportService;
import com.goeuro.client.SearchEngine;
import com.goeuro.common.model.City;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try{
    		if(args != null && args.length > 0){
    			System.out.println( ">>>>>>>>>> Searching cities by name ..." );
    			SearchEngine searchEngine = new SearchEngine();
    			ExportService exportService = new ExportService();
    			for(String name : args){
    				List<City> results = searchEngine.findCityByName(URLEncoder.encode(name, "UTF-8"));
    				if(results != null && results.size() > 0){
    					exportService.generateCsvFile("cities.csv", results);
    					System.out.println(">>> "+results.size() + " cities '"+name+"' found. Writen to cities.csv!" );
    				}
    				else {
    					System.out.println(">>> No city '"+name+"' found!" );
    				}
    			}
    		}
    		else {
    			System.out.println(">>> Please enter city name to search!");
    		}
    	}
    	catch(Exception e){
    		System.out.println(">>> Unknow Error occur!" +e.getMessage());
    	}
    }
}
