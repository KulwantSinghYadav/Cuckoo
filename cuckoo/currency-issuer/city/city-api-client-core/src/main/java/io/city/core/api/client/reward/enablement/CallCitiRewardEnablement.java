package io.city.core.api.client.reward.enablement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.model.core.constant.ApplicationConstant;

import io.city.core.api.auth.url.BuildRequestHeader;
import io.city.core.api.auth.url.HeaderProvider;
import io.city.core.api.auth.url.SendCityRequest;

@Component
public class CallCitiRewardEnablement extends SendCityRequest {

	public String callCityRewardEnablement() throws IOException {
		HeaderProvider headerProvider = new BuildRequestHeader();

		Map<String, String> headerValues = getHeaderProerties();

		String url = headerProvider.setUrlPattern(headerValues.get("cityRewardUrl"),headerValues.get("vi"),headerValues.get("apiProduct"),headerValues.get("enablementEndpoint"));
		Map<String, String> queryParameters = new HashMap<String, String>();
		String body = ApplicationConstant.Get_Citi_Reward_Enablement_Body;

		//call the city reward enablement api by passing requied parameters.
		String response = sendApiRequest(url, headerProvider.buildRewardHearder(),queryParameters,"put",body);

		System.out.println("Client Reward Enablement :" + response);

		return response;

	}
}