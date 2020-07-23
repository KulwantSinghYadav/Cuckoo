package io.city.core.api.client.reward.linkage;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cuckoo.config.api.config.BuildRequestApi;
import com.cuckoo.config.api.config.BuildRequestHeader;
import com.cuckoo.config.api.config.HeaderBuilder;
import com.cuckoo.config.property.config.ConfigurationKeys;
import com.cuckoo.config.property.config.ConfigurationProvider;
import com.cuckoo.config.property.config.PropertyConfiguration;
import com.model.core.constant.ApplicationConstant;

import okhttp3.RequestBody;

@Component
public class CallCitiRewardLinkage extends BuildRequestApi {

	public String callCityRewardLinkage(String authToken) throws IOException {

		HeaderBuilder headerProvider = new BuildRequestHeader();
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration(); 
		ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
		
		RequestBody requestBody = RequestBody.create(ApplicationConstant.JSON_MEDIA_TYPE, ApplicationConstant.Get_Citi_Reward_Linkage_Body);

		String url = headerProvider.setUrlPattern(configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_URL),
				configurationProvider.getValue(ConfigurationKeys.VI),
				configurationProvider.getValue(ConfigurationKeys.API_PRODUCT),
				configurationProvider.getValue(ConfigurationKeys.LINKAGEEND_POINT));
		Map<String, String> buildRequestHearder = headerProvider.buildRewardHearder(authToken);

		//call the city reward linkage api by passing requied parameters.
		String response = sendApiRequest(url,buildRequestHearder,requestBody);

		System.out.println("Client Reward Linkage :" + response);

		return response;

	}

}