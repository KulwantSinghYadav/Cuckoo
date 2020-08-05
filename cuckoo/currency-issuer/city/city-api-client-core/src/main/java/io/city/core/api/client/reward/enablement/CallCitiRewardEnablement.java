package io.city.core.api.client.reward.enablement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cuckoo.config.api.ReqRes.model.RewardEnablementReqResModel;
import com.cuckoo.config.api.config.BuildRequestApi;
import com.cuckoo.config.api.config.BuildRequestHeader;
import com.cuckoo.config.api.config.HeaderBuilder;
import com.cuckoo.config.property.config.ConfigurationKeys;
import com.cuckoo.config.property.config.ConfigurationProvider;
import com.cuckoo.config.property.config.PropertyConfiguration;
import com.google.gson.Gson;
import com.model.core.constant.ApplicationConstant;

@Component
public class CallCitiRewardEnablement extends BuildRequestApi {
	
	/*
	 * This function is used to get the city reward enablement with the dynamic request.
	 * The dynamic request is made from by getting the request arguments from the external user end.
	 */
	public String callCityRewardEnablement(String apiProduct, String endpoint, String authToken, String contentType,
			String countryCode, String businessCode, String acceptLanguage, String accept, RewardEnablementReqResModel rewardEnablementBody)
			throws IOException {

		String response = null;
		try {
			HeaderBuilder headerProvider = new BuildRequestHeader();
			PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
			ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
			String requestMethod = "put";
//			String requestBody = ApplicationConstant.Get_Citi_Reward_Enablement_Body;
			
			Gson gson = new Gson();
			String reBody = gson.toJson(rewardEnablementBody);

			/*
			 * "setUrlPattern" function is used to build the dynamic URL request.
			 */
			String url = headerProvider.setUrlPattern(configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_URL),
					configurationProvider.getValue(ConfigurationKeys.VI), apiProduct, endpoint);
			
			/*
			 * "buildRewardHearder" function is used to build the dynamic Header.
			 */
			Map<String, String> buildRequestHearder = headerProvider.buildRewardHearder(authToken, contentType,
					countryCode, businessCode, acceptLanguage, accept);
			Map<String, String> queryParameters = new HashMap<String, String>();

			// call the city reward enablement api by passing requied parameters.
			response = sendApiRequest(url, buildRequestHearder, queryParameters, requestMethod, reBody);

			System.out.println("Client Reward Enablement :" + response);

			return response;
		} catch (Exception e) {
			System.out.println("Someting went wrong in reward enablement API" + e);
		}

		if (!StringUtils.isEmpty(response)) {
			return response;
		} else {
			return "Someting went wrong in reward enablement API";
		}

	}
}