package io.city.core.api.configuration;

import java.io.IOException;
import java.io.InputStream;

public class PropertyConfiguration{
	
	public ConfigurationProvider loadProperties() throws IOException{
		String propertiesFileName = "application.properties";
		PropertiesConfigurationProvider provider = new PropertiesConfigurationProvider();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
        provider.loadProperties(inputStream);
    	ConfigurationProvider configurationProvider = provider;
        return configurationProvider;
	}

}
