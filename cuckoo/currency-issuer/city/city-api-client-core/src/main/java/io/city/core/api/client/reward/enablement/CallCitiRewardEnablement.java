package io.city.core.api.client.reward.enablement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cuckoo.config.api.config.BuildRequestApi;
import com.cuckoo.config.api.config.BuildRequestHeader;
import com.cuckoo.config.api.config.HeaderBuilder;
import com.cuckoo.config.property.config.ConfigurationKeys;
import com.cuckoo.config.property.config.ConfigurationProvider;
import com.cuckoo.config.property.config.PropertyConfiguration;
import com.model.core.constant.ApplicationConstant;

@Component
public class CallCitiRewardEnablement extends BuildRequestApi {

	public String callCityRewardEnablement(String authToken) throws IOException {

		HeaderBuilder headerProvider = new BuildRequestHeader();
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
		ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
		String requestMethod = "put";
		String requestBody = ApplicationConstant.Get_Citi_Reward_Enablement_Body;


		String url = headerProvider.setUrlPattern(configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_URL),
				configurationProvider.getValue(ConfigurationKeys.VI),
				configurationProvider.getValue(ConfigurationKeys.API_PRODUCT),
				configurationProvider.getValue(ConfigurationKeys.ENABLEMENT_END_POINT));
		Map<String, String> buildRequestHearder = headerProvider.buildRewardHearder(authToken);
		Map<String, String> queryParameters = new HashMap<String, String>();
		

		// call the city reward enablement api by passing requied parameters.
		String response = sendApiRequest(url, buildRequestHearder, queryParameters, requestMethod, requestBody);

		System.out.println("Client Reward Enablement :" + response);

		return response;

	}
}