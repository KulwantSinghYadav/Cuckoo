package io.city.core.api.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class CitiRewardBalanceConfiguration {
	
	Map<String,String> configMap = new HashMap<>();
	InputStream inputStream;
 
	public Map<String,String> getPropValues() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "application.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			configMap.put("cityRewardUrl", prop.getProperty("city.reward.url"));
			configMap.put("clientId", prop.getProperty("client.id"));
			configMap.put("uuid", prop.getProperty("uuid"));
			configMap.put("contentType",  prop.getProperty("content.type"));
			configMap.put("countryCode", prop.getProperty("countrycode"));
			configMap.put("businessCode", prop.getProperty("businesscode"));
			configMap.put("authorization", prop.getProperty("authorization"));
			configMap.put("acceptLanguage", prop.getProperty("accept.language"));
			configMap.put("accept", prop.getProperty("accept"));
			
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return configMap;
	}

}
