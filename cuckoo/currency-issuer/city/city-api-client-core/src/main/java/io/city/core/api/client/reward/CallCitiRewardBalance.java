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

	/*
	 * ApplicationRunner is used when you want to execute some piece of code exactly
	 * before the application startup completes, you can use it then. In one of our
	 * projects, we used these to source data from other microservices via service
	 * discovery.
	 */

	public String callCityReward() throws IOException {
		HeaderProvider headerProvider = new BuildRequestHeader();

		Map<String, String> headerValues = getHeaderProerties();

		String url = setUrlPattern(headerValues);
		Map<String, String> queryParameters = setQueryParameter(headerValues);
		
		//call the city reward api by passing requied parameters.
		String response = sendApiRequest(url, headerProvider.buildRewardHearder(headerValues), queryParameters, "get", "");
		
		System.out.println("Client Reward Balance :"+ response);
		
		return response;

	}

	private String setUrlPattern(Map<String, String> headerValues) {

		//create dynamic url for city reward api.
		return headerValues.get("cityRewardUrl").concat("/").concat(headerValues.get("vi").concat("/"))
				.concat(headerValues.get("apiProduct").concat("/")).concat(headerValues.get("endpoint"));
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