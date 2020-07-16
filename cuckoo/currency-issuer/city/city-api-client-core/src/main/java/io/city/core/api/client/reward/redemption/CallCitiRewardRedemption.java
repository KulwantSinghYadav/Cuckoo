package io.city.core.api.client.reward.redemption;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.model.core.constant.ApplicationConstant;

import io.city.core.api.auth.url.BuildRequestHeader;
import io.city.core.api.auth.url.HeaderProvider;
import io.city.core.api.auth.url.SendCityRequest;
import okhttp3.RequestBody;

@Component
public class CallCitiRewardRedemption extends SendCityRequest {

	public String callCityRewardRedemption() throws IOException {
		HeaderProvider headerProvider = new BuildRequestHeader();

		Map<String, String> headerValues = getHeaderProerties();
		RequestBody body = RequestBody.create(ApplicationConstant.JSON_MEDIA_TYPE, ApplicationConstant.Get_Citi_Reward_Redemption_Body);

		String url = headerProvider.setUrlPattern(headerValues.get("cityRewardUrl"),headerValues.get("vi"),headerValues.get("apiProduct"),headerValues.get("redemptionEndpoint"));

		//call the city reward redemption api by passing requied parameters.
		String response = sendApiRequest(url , headerProvider.buildRewardHearder(),body);

		System.out.println("Client Reward Redemption :" + response);

		return response;

	}

}