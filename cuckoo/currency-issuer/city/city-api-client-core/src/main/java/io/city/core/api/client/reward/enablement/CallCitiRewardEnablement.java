package io.city.core.api.client.reward.enablement;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cuckoo.core.constant.ApplicationConstant;

import io.city.core.api.auth.url.BuildRequestHeader;
import io.city.core.api.auth.url.HeaderProvider;
import io.city.core.api.auth.url.SendCityRequest;
import okhttp3.RequestBody;

@Component
public class CallCitiRewardEnablement extends SendCityRequest {

	public String callCityRewardEnablement() throws IOException {
		HeaderProvider headerProvider = new BuildRequestHeader();

		Map<String, String> headerValues = getHeaderProerties();

		String url = setUrlPattern(headerValues);
		Map<String, String> queryParameters = setQueryParameter(headerValues);
		String body = ApplicationConstant.Get_Citi_Reward_Enablement_Body;

		String response = sendApiRequest(url, headerProvider.buildRewardHearder(headerValues), queryParameters,"put",body);

		System.out.println("Client Reward Enablement :" + response);

		return response;

	}

	private String setUrlPattern(Map<String, String> headerValues) {

		return headerValues.get("cityRewardUrl").concat("/").concat(headerValues.get("vi").concat("/"))
				.concat(headerValues.get("apiProduct").concat("/")).concat(headerValues.get("enablementEndpoint"));
	}

	private Map<String, String> setQueryParameter(Map<String, String> headerValues) {

		Map<String, String> queryParameters = new LinkedHashMap<>();
//		queryParameters.put("merchantCode", headerValues.get("merchantCode"));
//		queryParameters.put("rewardProgram", headerValues.get("rewardProgram"));

		return queryParameters;
	}

}