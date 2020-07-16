package io.city.core.api.client.reward.linkage;

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
public class CallCitiRewardLinkage extends SendCityRequest {

	public String callCityRewardLinkage() throws IOException {
		HeaderProvider headerProvider = new BuildRequestHeader();

		Map<String, String> headerValues = getHeaderProerties();
		RequestBody body = RequestBody.create(ApplicationConstant.JSON_MEDIA_TYPE, ApplicationConstant.Get_Citi_Reward_Linkage_Body);

		String url = headerProvider.setUrlPattern(headerValues.get("cityRewardUrl"),headerValues.get("vi"),headerValues.get("apiProduct"),headerValues.get("linkageEndpoint"));


		//call the city reward linkage api by passing requied parameters.
		String response = sendApiRequest(url, headerProvider.buildRewardHearder(),body);

		System.out.println("Client Reward Linkage :" + response);

		return response;

	}

}