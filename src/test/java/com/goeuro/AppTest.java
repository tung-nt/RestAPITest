package com.goeuro;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import junit.framework.TestCase;

import com.goeuro.client.ExportService;
import com.goeuro.client.SearchEngine;
import com.goeuro.common.model.City;

public class AppTest extends TestCase {
	public void testApp() {
		try {
			long start = System.currentTimeMillis();
			System.setProperty("http.proxyHost", "proxy.starhubsg.sh.inc");
            System.setProperty("http.proxyPort", "80");
            
            File result = new File("cities.csv");
            if(result.exists()) result.delete();
            
			File testFile = new File("resources/test-cities.csv");
			assertTrue(testFile.exists());
			
			SearchEngine searchEngine = new SearchEngine();
			ExportService exportService = new ExportService();

			List<String> lines = Files.readAllLines(testFile.toPath(), StandardCharsets.UTF_8);
		    for (String line : lines) {
		        String[] array = line.split(",");
		        if(array!= null && array.length == 3){
		        	List<City> results = searchEngine.findCityByName(URLEncoder.encode(array[2], "UTF-8"));
					if(results != null && results.size() > 0){
						exportService.generateCsvFile("cities.csv", results);
						System.out.println(">>> "+results.size() + " cities '"+String.format("%1$-" + 20 + "s", array[2])+"' found. Writen to cities.csv!" );
					}
					else {
						System.out.println(">>>> No city '"+String.format("%1$-" + 20 + "s", array[2])+"' found!" );
					}
		        }
		    }
		    long end = System.currentTimeMillis();
		    System.out.println("Testing time: "+ ((end-start)/1000) + "s");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
