package com.cuckoo.core.client.auth;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cuckoo.core.api.config.BuildRequestApi;
import com.cuckoo.core.api.config.BuildRequestHeader;
import com.cuckoo.core.api.config.HeaderBuilder;
import com.cuckoo.core.property.config.ConfigurationKeys;
import com.cuckoo.core.property.config.ConfigurationProvider;
import com.cuckoo.core.property.config.PropertyConfiguration;

import okhttp3.MediaType;
import okhttp3.RequestBody;

@Component
public class CallAuthorization extends BuildRequestApi{

	Map<String, String> headerValues = getHeaderProerties();
	
    public String callAuthorization() throws IOException {
    	
    	HeaderBuilder headerProvider = new BuildRequestHeader();
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration(); 
		ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
		
    	MediaType mediaType = MediaType.parse(configurationProvider.getValue(ConfigurationKeys.AUTH_MEDIA_TYPE));
    	RequestBody body = RequestBody.create(mediaType, getResponseBody(configurationProvider.getValue(ConfigurationKeys.AUTH_SCOPE)));
    	String authUrl = configurationProvider.getValue(ConfigurationKeys.AUTH_URL);
    	Map<String, String> buildRequestHearder = headerProvider.buildAuthorization(configurationProvider);
    	
    	//call the city Authorization api by passing requied parameters.
    	String response = sendApiRequest(authUrl,buildRequestHearder,body);
		return getAuthorisationToken(response);
	}

    /*
     * This function is used to set response body.
     */
	private String getResponseBody(String authScope) {
    	 return "grant_type=".concat("client_credentials").concat("&scope=").concat(authScope);
	}
    
    
    
}
