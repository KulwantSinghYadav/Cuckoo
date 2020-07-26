package io.city.core.api.client.reward.redemption;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cuckoo.config.api.config.BuildRequestApi;
import com.cuckoo.config.api.config.BuildRequestHeader;
import com.cuckoo.config.api.config.HeaderBuilder;
import com.cuckoo.config.property.config.ConfigurationKeys;
import com.cuckoo.config.property.config.ConfigurationProvider;
import com.cuckoo.config.property.config.PropertyConfiguration;
import com.model.core.constant.ApplicationConstant;

import okhttp3.RequestBody;

@Component
public class CallCitiRewardRedemption extends BuildRequestApi {

	/*
	 * This function is used to get the city reward redemption with the dynamic request.
	 * The dynamic request is made from by getting the request arguments from the external user end.
	 */
	public String callCityRewardRedemption(String apiProduct, String endpoint, String authToken, String contentType,
			String countryCode, String businessCode, String acceptLanguage, String accept, String redemptionRequestBody)
			throws IOException {

		String response = null;

		try {
			HeaderBuilder headerProvider = new BuildRequestHeader();
			PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
			ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();

			RequestBody redemptionBody = RequestBody.create(ApplicationConstant.JSON_MEDIA_TYPE, redemptionRequestBody);

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

			// call the city reward redemption api by passing requied parameters.
			response = sendApiRequest(url, buildRequestHearder, redemptionBody);

			System.out.println("Client Reward Redemption :" + response);

		} catch (Exception e) {
			System.out.println("Someting went wrong  in reward redemption API" + e);
		}

		if (!StringUtils.isEmpty(response)) {
			return response;
		} else {
			return "Someting went wrong in reward redemption API";
		}

	}

}