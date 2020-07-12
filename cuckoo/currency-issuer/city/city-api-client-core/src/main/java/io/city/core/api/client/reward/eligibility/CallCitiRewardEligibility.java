package io.city.core.api.client.reward.eligibility;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.city.core.api.auth.url.BuildRequestHeader;
import io.city.core.api.auth.url.HeaderProvider;
import io.city.core.api.auth.url.SendCityRequest;
import okhttp3.RequestBody;

@Component
public class CallCitiRewardEligibility extends SendCityRequest  {

	public String callCityRewardEligibility() throws IOException {
		HeaderProvider headerProvider = new BuildRequestHeader();

		Map<String, String> headerValues = getHeaderProerties();

		String url = setUrlPattern(headerValues);
		Map<String, String> queryParameters = setQueryParameter(headerValues);

		String response = sendApiRequest(url, headerProvider.buildRewardHearder(headerValues), queryParameters,"get","");

		System.out.println("Client Reward Eligibility :"+ response);
		
		return response;

	}

	private String setUrlPattern(Map<String, String> headerValues) {

		return headerValues.get("cityRewardUrl").concat("/").concat(headerValues.get("vi").concat("/"))
				.concat(headerValues.get("apiProduct").concat("/")).concat(headerValues.get("cityRewardEligibilityPath").concat("/")).concat(headerValues.get("endpoint"));
	}

	private Map<String, String> setQueryParameter(Map<String, String> headerValues) {

		Map<String, String> queryParameters = new LinkedHashMap<>();
		queryParameters.put("merchantCode", headerValues.get("merchantCode"));
		queryParameters.put("rewardProgram", headerValues.get("rewardProgram"));

		return queryParameters;
	}

}