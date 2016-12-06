package com.homedepot.pip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.homedepot.pip.cache.store.StoreCache;
import com.homedepot.pip.util.constant.Constants;
import com.homedepot.pip.util.http.Connection;

@SpringBootApplication
@ComponentScan(basePackages = "com.homedepot.pip")
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		String response = null;
		if (Constants.IS_SIMULATOR_ENABLED) {
			response = readStoresFromFile();
		} else {
			response = Connection.INSTANCE.makeRequest(
					"http://origin.api.homedepot.com/wcs/resources/LoadStoreInfo/StoreInfoService/loadStoreInfo");
		}
		StoreCache.populateStores(response);
	}

	private static String readStoresFromFile() throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/sample/Stores.xml")));
		String line;
		StringBuilder storesBuilder = new StringBuilder();

		while ((line = br.readLine()) != null) {
			storesBuilder.append(line.trim());
		}
		br.close();
		System.out.println("Total time taken to read Stores xml file: " + (System.currentTimeMillis() - start));
		return storesBuilder.toString();
	}
}