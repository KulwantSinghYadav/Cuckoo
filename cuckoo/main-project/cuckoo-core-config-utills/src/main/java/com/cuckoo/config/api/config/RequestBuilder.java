package com.cuckoo.config.api.config;

import java.io.IOException;
import java.util.Map;

import com.cuckoo.config.property.config.ConfigurationProvider;

import okhttp3.RequestBody;

public interface RequestBuilder {
	
	String sendApiRequest(String url, Map<String, String> buildRewardHearder,
			Map<String, String> queryParameters, String method, String body)throws IOException;
	
	String sendApiRequest(String authUrl, Map<String, String> buildRewardHearder,
			RequestBody body) throws IOException;

	String getAuthorisationToken(String response);
	
//	Map<String, String> setQueryParameter(ConfigurationProvider configurationProvider);
	Map<String, String> setQueryParameter(ConfigurationProvider configurationProvider,String rewardLinkCode);
	
}
