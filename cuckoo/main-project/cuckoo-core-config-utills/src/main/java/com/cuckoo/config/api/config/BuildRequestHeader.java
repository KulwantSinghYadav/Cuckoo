package com.cuckoo.config.api.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cuckoo.config.property.config.ConfigurationKeys;
import com.cuckoo.config.property.config.ConfigurationProvider;
import com.cuckoo.config.property.config.PropertyConfiguration;
import com.model.core.constant.ApplicationConstant;


@Component
@ComponentScan(basePackages = { "com.cuckoo.config.client.auth" })
public class BuildRequestHeader implements HeaderBuilder {
	
	/*
	 *  Build dynamic request header for Reward related API'S.
	 */
	@Override
	public Map<String, String> buildRewardHearder(String authToken, String contentType,String countryCode, String businessCode, String acceptLanguage, String accept) throws IOException {

		Map<String, String> requestHeaderValue = new LinkedHashMap<>();
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
		ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();

		requestHeaderValue.put(ApplicationConstant.Client_Id, configurationProvider.getValue(ConfigurationKeys.CLIENT_ID));
		requestHeaderValue.put(ApplicationConstant.UUID, UUID.randomUUID().toString());
		requestHeaderValue.put(ApplicationConstant.Country_Code, countryCode);
		requestHeaderValue.put(ApplicationConstant.Business_Code, businessCode);
		requestHeaderValue.put(ApplicationConstant.Authorization, authToken);
		requestHeaderValue.put(ApplicationConstant.Accept_Language, acceptLanguage);
		requestHeaderValue.put(ApplicationConstant.Content_Type, contentType);
		requestHeaderValue.put(ApplicationConstant.Accept, accept);

		return requestHeaderValue;
	}

	/*
	 *  Build request header of Authorization API
	 */
	@Override
	public Map<String, String> buildAuthorization(ConfigurationProvider configurationProvider, String encodedAuth) {
		Map<String, String> requestHeaderValue = new HashMap<>();

		System.out.println("Encoded Auth :" + encodedAuth);

		requestHeaderValue.put("authorization", encodedAuth);
		requestHeaderValue.put("content-type", configurationProvider.getValue(ConfigurationKeys.AUTHCONTENT_TYPE));
		requestHeaderValue.put("accept", configurationProvider.getValue(ConfigurationKeys.ACCEPT));

		return requestHeaderValue;
	}

	/*
	 *  Build query parameter request for eligibility
	 */
	@Override
	public String setEligibilityQueryParameter(String url, String vi, String apiProduct,
			String cityRewardEligibilityPath, String endpoint) {

			return url.concat("/").concat(vi.concat("/")).concat(apiProduct.concat("/"))
					.concat(cityRewardEligibilityPath.concat("/")).concat(endpoint);
	}

	/*
	 *  Build query parameter request for citi reward api's
	 */
	@Override
	public String setUrlPattern(String url, String vi, String apiProduct, String endpoint) {
		return url.concat("/").concat(vi.concat("/")).concat(apiProduct.concat("/")).concat(endpoint);
	}

}
