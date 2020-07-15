package io.city.core.api.client.reward;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.city.core.api.auth.url.BuildRequestHeader;
import io.city.core.api.auth.url.HeaderProvider;
import io.city.core.api.auth.url.SendCityRequest;
import okhttp3.RequestBody;

@Component
public class CallCitiRewardBalance extends SendCityRequest {

	public String callCityReward() throws IOException {
		HeaderProvider headerProvider = new BuildRequestHeader();

		Map<String, String> headerValues = getHeaderProerties();

		String url = headerProvider.setUrlPattern(headerValues.get("cityRewardUrl"),headerValues.get("vi"),headerValues.get("apiProduct"),headerValues.get("endpoint"));
		
		//call the city reward api by passing requied parameters.
		String response = sendApiRequest(url, headerProvider.buildRewardHearder(headerValues), setQueryParameter(headerValues), "get", "");
		
		System.out.println("Client Reward Balance :"+ response);
		
		return response;

	}

	private Map<String, String> setQueryParameter(Map<String, String> headerValues) {
		
		//Set the query parameter for city reward api.
		Map<String, String> queryParameters = new LinkedHashMap<>();
		queryParameters.put("cloakedCreditCardNumber", headerValues.get("cloakedCreditCardNumbers"));
		queryParameters.put("merchantCode", headerValues.get("merchantCode"));
		queryParameters.put("rewardProgram", headerValues.get("rewardProgram"));
		queryParameters.put("rewardLinkCode", headerValues.get("rewardLinkCode"));

		return queryParameters;
	}

}