package io.city.core.api.auth.url;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BuildRequestHeader implements HeaderProvider {

	String rewardUrl;

	@Override
	public Map<String, String> buildRewardHearder(Map<String, String> headerValues) {

		Map<String, String> requestHeaderValue = new HashMap<>();
		
		requestHeaderValue.put("clientId", UUID.randomUUID().toString());
		requestHeaderValue.put("uuid", headerValues.get("merchantCode"));
		requestHeaderValue.put("contentType", headerValues.get("contentType"));
		requestHeaderValue.put("countryCode", headerValues.get("countryCode"));
		requestHeaderValue.put("businessCode", headerValues.get("businessCode"));
		requestHeaderValue.put("authorization", headerValues.get("authorization"));
		requestHeaderValue.put("acceptLanguage", headerValues.get("acceptLanguage"));
		requestHeaderValue.put("accept", headerValues.get("accept"));

		return requestHeaderValue;
	}

}
