package com.cuckoo.config.api.config;

import java.io.IOException;
import java.util.Map;

import com.cuckoo.config.property.config.ConfigurationProvider;

public interface HeaderBuilder {
	Map<String, String> buildRewardHearder(String authToken, String contentType,String countryCode, String businessCode, String acceptLanguage, String accept) throws IOException;
	Map<String, String> buildAuthorization(ConfigurationProvider configurationProvider,String encodedAuth);
	String setUrlPattern(String url, String vi, String apiProduct, String endpoint);
	String setEligibilityQueryParameter(String url, String vi, String apiProduct, String cityRewardEligibilityPath, String endpoint);
}
