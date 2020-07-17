package com.cuckoo.core.api.config;

import java.io.IOException;
import java.util.Map;

import com.cuckoo.core.property.config.ConfigurationProvider;

public interface HeaderBuilder {
	Map<String, String> buildRewardHearder() throws IOException;
	Map<String, String> buildAuthorization(ConfigurationProvider configurationProvider);
	String setUrlPattern(String url, String vi, String apiProduct, String endpoint);
	String setEligibilityQueryParameter(String url, String vi, String apiProduct, String cityRewardEligibilityPath, String endpoint);
}
