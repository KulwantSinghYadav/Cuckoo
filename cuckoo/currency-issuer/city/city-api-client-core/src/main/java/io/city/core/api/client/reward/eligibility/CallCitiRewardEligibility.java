package io.city.core.api.client.reward.eligibility;

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
public class CallCitiRewardEligibility extends BuildRequestApi  {

	public String callCityRewardEligibility(String authToken) throws IOException {
		
		HeaderBuilder headerProvider = new BuildRequestHeader();
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration(); 
		CallCitiRewardLinkage callCitiRewardLinkage = new CallCitiRewardLinkage();
		ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
		RequestBuilder requestBuilder = new BuildRequestApi();
		String requestMethod = "get";
		String requestBody = "";

		String rewardLinkCode = callCitiRewardLinkage.callCityRewardLinkage(authToken);
		String url = headerProvider.setEligibilityQueryParameter(configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_URL), configurationProvider.getValue(ConfigurationKeys.VI),
				configurationProvider.getValue(ConfigurationKeys.API_PRODUCT), configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_ELIGIBILITY_PATH), configurationProvider.getValue(ConfigurationKeys.ELIGIBILITY_END_POINT));
		 Map<String, String> buildRequestHearder = headerProvider.buildRewardHearder(authToken);
		 Map<String, String> setQueryParameter = requestBuilder.setQueryParameter(configurationProvider,rewardLinkCode);
		 
		String response = sendApiRequest(url, buildRequestHearder, setQueryParameter,requestMethod,requestBody);

		System.out.println("Client Reward Eligibility :"+ response);
		
		return response;

	}

}