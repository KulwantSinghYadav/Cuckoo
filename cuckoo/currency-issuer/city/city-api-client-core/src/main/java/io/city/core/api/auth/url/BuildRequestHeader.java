package io.city.core.api.auth.url;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.city.core.api.client.reward.auth.CallAuthorization;
import io.city.core.api.configuration.ConfigurationKeys;
import io.city.core.api.configuration.ConfigurationProvider;
import io.city.core.api.configuration.PropertyConfiguration;

public class BuildRequestHeader implements HeaderProvider {

	//Build request headre for Reward related API'S
	@Override
	public Map<String, String> buildRewardHearder() throws IOException {
		
		Map<String, String> requestHeaderValue = new HashMap<>();
		CallAuthorization authToken = new CallAuthorization();
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration(); 
		ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
		
		requestHeaderValue.put("client_id", configurationProvider.getValue(ConfigurationKeys.CLIENT_ID));
		requestHeaderValue.put("uuid", UUID.randomUUID().toString());
		requestHeaderValue.put("content-type", configurationProvider.getValue(ConfigurationKeys.CONTENT_TYPE));
		requestHeaderValue.put("countrycode", configurationProvider.getValue(ConfigurationKeys.COUNTRY_CODE));
		requestHeaderValue.put("businesscode", configurationProvider.getValue(ConfigurationKeys.BUSINESS_CODE));
		requestHeaderValue.put("authorization",  authToken.callAuthorization());
		requestHeaderValue.put("accept-language", configurationProvider.getValue(ConfigurationKeys.ACCEPT_LANGUAGE));
		requestHeaderValue.put("accept", configurationProvider.getValue(ConfigurationKeys.ACCEPT));

		return requestHeaderValue;
	}
	
	//Build request header of Authorization API
	@Override
	public Map<String, String> buildAuthorization(Map<String, String> headerValues) {
		Map<String, String> requestHeaderValue = new HashMap<>();
		
		requestHeaderValue.put("authorization", headerValues.get("authAuthorization"));
		requestHeaderValue.put("content-type", headerValues.get("authContentType"));
		requestHeaderValue.put("accept", headerValues.get("accept"));
		
		return requestHeaderValue;
	}

	//Build URL header of API's calling
	@Override
	public String setUrlPattern(String url, String vi, String apiProduct, String endpoint) {
		return url.concat("/").concat(vi.concat("/")).concat(apiProduct.concat("/")).concat(endpoint);
	}
	
}
