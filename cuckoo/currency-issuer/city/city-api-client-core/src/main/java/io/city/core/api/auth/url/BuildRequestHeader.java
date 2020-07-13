package io.city.core.api.auth.url;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BuildRequestHeader implements HeaderProvider {

	String rewardUrl;

	@Override
	public Map<String, String> buildRewardHearder(Map<String, String> headerValues) {

		Map<String, String> requestHeaderValue = new HashMap<>();
		
		requestHeaderValue.put("client_id", headerValues.get("clientId"));
		requestHeaderValue.put("uuid", UUID.randomUUID().toString());
		requestHeaderValue.put("content-type", headerValues.get("contentType"));
		requestHeaderValue.put("countrycode", headerValues.get("countryCode"));
		requestHeaderValue.put("businesscode", headerValues.get("businessCode"));
		requestHeaderValue.put("authorization", headerValues.get("authorization"));
		requestHeaderValue.put("accept-language", headerValues.get("acceptLanguage"));
		requestHeaderValue.put("accept", headerValues.get("accept"));

		return requestHeaderValue;
	}

}
