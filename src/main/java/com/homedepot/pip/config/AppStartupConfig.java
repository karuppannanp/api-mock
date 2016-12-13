package com.homedepot.pip.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homedepot.pip.cache.store.StoreCache;
import com.homedepot.pip.util.constant.Constants;
import com.homedepot.pip.util.http.Connection;

@Component
public class AppStartupConfig {
	
	@Autowired
	private Connection connection;
	
	@Autowired
	private StoreCache storeCache;

	@PostConstruct
	public void getStores() {
		String storesResponse = null;
		try {
			if (Constants.IS_SIMULATOR_ENABLED) {
				storesResponse = readStoresFromFile();
			} else {
				storesResponse = connection.makeRequest(
						"http://origin.api.homedepot.com/wcs/resources/LoadStoreInfo/StoreInfoService/loadStoreInfo");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		storeCache.populateStores(storesResponse);
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