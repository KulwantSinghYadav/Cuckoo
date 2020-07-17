package io.city.core.api.client.reward;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cuckoo.core.api.config.BuildRequestApi;
import com.cuckoo.core.api.config.BuildRequestHeader;
import com.cuckoo.core.api.config.HeaderBuilder;
import com.cuckoo.core.api.config.RequestBuilder;
import com.cuckoo.core.property.config.ConfigurationKeys;
import com.cuckoo.core.property.config.ConfigurationProvider;
import com.cuckoo.core.property.config.PropertyConfiguration;

import io.city.core.api.client.reward.linkage.CallCitiRewardLinkage;

@Component
public class CallCitiRewardBalance {

	public String callCityReward() throws IOException {

		HeaderBuilder headerProvider = new BuildRequestHeader();
		RequestBuilder requestBuilder = new BuildRequestApi();
		CallCitiRewardLinkage callCitiRewardLinkage = new CallCitiRewardLinkage();
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration(); 
		ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
		String requestMethod = "get";
		String requestBody = "";

		String rewardLinkCode = callCitiRewardLinkage.callCityRewardLinkage();
		String url = headerProvider.setUrlPattern(configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_URL), configurationProvider.getValue(ConfigurationKeys.VI),
				configurationProvider.getValue(ConfigurationKeys.API_PRODUCT), configurationProvider.getValue(ConfigurationKeys.ENDPOINT));
		
		 Map<String, String> buildRequestHearder = headerProvider.buildRewardHearder();
		 Map<String, String> setQueryParameter = requestBuilder.setQueryParameter(configurationProvider,rewardLinkCode);

		// call the city reward api by passing required parameters.
		String response = requestBuilder.sendApiRequest(url,buildRequestHearder, setQueryParameter, requestMethod, requestBody);

		System.out.println("Client Reward Balance :" + response);

		return response;

	}
}