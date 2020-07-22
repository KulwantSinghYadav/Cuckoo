package io.city.core.api.client.reward.balance;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cuckoo.config.api.config.BuildRequestApi;
import com.cuckoo.config.api.config.BuildRequestHeader;
import com.cuckoo.config.api.config.HeaderBuilder;
import com.cuckoo.config.api.config.RequestBuilder;
import com.cuckoo.config.property.config.ConfigurationKeys;
import com.cuckoo.config.property.config.ConfigurationProvider;
import com.cuckoo.config.property.config.PropertyConfiguration;

import io.city.core.api.client.reward.linkage.CallCitiRewardLinkage;

@Component
public class CallCitiRewardBalance {

	public String callCityReward(String authToken) throws IOException {

		HeaderBuilder headerProvider = new BuildRequestHeader();
		RequestBuilder requestBuilder = new BuildRequestApi();
		CallCitiRewardLinkage callCitiRewardLinkage = new CallCitiRewardLinkage();
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration(); 
		ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
		String requestMethod = "get";
		String requestBody = "";

		String rewardLinkCode = callCitiRewardLinkage.callCityRewardLinkage(authToken);
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