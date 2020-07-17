package com.cuckoo.core.api.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.cuckoo.core.client.auth.CallAuthorization;
import com.cuckoo.core.property.config.ConfigurationKeys;
import com.cuckoo.core.property.config.ConfigurationProvider;
import com.cuckoo.core.property.config.PropertyConfiguration;

public class BuildRequestHeader implements HeaderBuilder {

	// Build request headre for Reward related API'S
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
		requestHeaderValue.put("authorization", authToken.callAuthorization());
		requestHeaderValue.put("accept-language", configurationProvider.getValue(ConfigurationKeys.ACCEPT_LANGUAGE));
		requestHeaderValue.put("accept", configurationProvider.getValue(ConfigurationKeys.ACCEPT));

		return requestHeaderValue;
	}

	// Build request header of Authorization API
	@Override
	public Map<String, String> buildAuthorization(ConfigurationProvider configurationProvider) {
		Map<String, String> requestHeaderValue = new HashMap<>();

		requestHeaderValue.put("authorization", configurationProvider.getValue(ConfigurationKeys.AUTHAUTHORIZATION));
		requestHeaderValue.put("content-type", configurationProvider.getValue(ConfigurationKeys.AUTHCONTENT_TYPE));
		requestHeaderValue.put("accept", configurationProvider.getValue(ConfigurationKeys.ACCEPT));

		return requestHeaderValue;
	}

	@Override
	public String setEligibilityQueryParameter(String url, String vi, String apiProduct,
			String cityRewardEligibilityPath, String endpoint) {

			return url.concat("/").concat(vi.concat("/")).concat(apiProduct.concat("/"))
					.concat(cityRewardEligibilityPath.concat("/")).concat(endpoint);
	}

	@Override
	public String setUrlPattern(String url, String vi, String apiProduct, String endpoint) {
		return url.concat("/").concat(vi.concat("/")).concat(apiProduct.concat("/")).concat(endpoint);
	}

}
