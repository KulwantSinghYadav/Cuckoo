package io.city.core.api.client.reward;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.city.core.api.auth.url.BuildRequestHeader;
import io.city.core.api.auth.url.HeaderProvider;
import io.city.core.api.auth.url.SendCityRequest;
import io.city.core.api.configuration.ConfigurationKeys;
import io.city.core.api.configuration.ConfigurationProvider;
import io.city.core.api.configuration.PropertyConfiguration;

@Component
public class CallCitiRewardBalance extends SendCityRequest {

	public String callCityReward() throws IOException {

		HeaderProvider headerProvider = new BuildRequestHeader();
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration(); 
		ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();

		String url = headerProvider.setUrlPattern(configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_URL), configurationProvider.getValue(ConfigurationKeys.VI),
				configurationProvider.getValue(ConfigurationKeys.API_PRODUCT), configurationProvider.getValue(ConfigurationKeys.ENDPOINT));

		// call the city reward api by passing requied parameters.
		String response = sendApiRequest(url, headerProvider.buildRewardHearder(),
				setQueryParameter(configurationProvider), "get", "");

		System.out.println("Client Reward Balance :" + response);

		return response;

	}

	//This function is to set query parameter
	private Map<String, String> setQueryParameter(ConfigurationProvider configurationProvider) {

		// Set the query parameter for city reward api.
		Map<String, String> queryParameters = new LinkedHashMap<>();
		queryParameters.put("cloakedCreditCardNumber", configurationProvider.getValue(ConfigurationKeys.CLOAKED_CREDIT_CARD_NUMBERS));
		queryParameters.put("merchantCode", configurationProvider.getValue(ConfigurationKeys.MERCHANT_CODE));
		queryParameters.put("rewardProgram", configurationProvider.getValue(ConfigurationKeys.REWARD_PROGRAM));
		queryParameters.put("rewardLinkCode", configurationProvider.getValue(ConfigurationKeys.REWARD_LINK_CODE));

		return queryParameters;
	}

}