package io.city.core.api.auth.url;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.city.core.api.client.reward.auth.CallAuthorization;

public class BuildRequestHeader implements HeaderProvider {

	//Build request for Reward related api's
	@Override
	public Map<String, String> buildRewardHearder(Map<String, String> headerValues) {

		Map<String, String> requestHeaderValue = new HashMap<>();
		CallAuthorization authToken = new CallAuthorization();
		
		requestHeaderValue.put("client_id", headerValues.get("clientId"));
		requestHeaderValue.put("uuid", UUID.randomUUID().toString());
		requestHeaderValue.put("content-type", headerValues.get("contentType"));
		requestHeaderValue.put("countrycode", headerValues.get("countryCode"));
		requestHeaderValue.put("businesscode", headerValues.get("businessCode"));
		try {
			requestHeaderValue.put("authorization", authToken.callAuthorization());
		} catch (IOException e) {
			System.out.println("Someting went wrong :" +e);
		}
		requestHeaderValue.put("accept-language", headerValues.get("acceptLanguage"));
		requestHeaderValue.put("accept", headerValues.get("accept"));

		return requestHeaderValue;
	}
	
	//Build request of Authorization api
	@Override
	public Map<String, String> buildAuthorization(Map<String, String> headerValues) {
		Map<String, String> requestHeaderValue = new HashMap<>();
		
		requestHeaderValue.put("authorization", headerValues.get("authAuthorization"));
		requestHeaderValue.put("content-type", headerValues.get("authContentType"));
		requestHeaderValue.put("accept", headerValues.get("accept"));
		
		return requestHeaderValue;
	}
	//Create the authorization api calling process in City-reward application with their separate request creation technique.

	@Override
	public String setUrlPattern(String url, String vi, String apiProduct, String endpoint) {
		return url.concat("/").concat(vi.concat("/")).concat(apiProduct.concat("/")).concat(endpoint);
	}
	
}
