package io.city.core.api.client.reward.eligibility;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cuckoo.config.api.config.BuildRequestApi;
import com.cuckoo.config.api.config.BuildRequestHeader;
import com.cuckoo.config.api.config.HeaderBuilder;
import com.cuckoo.config.api.config.RequestBuilder;
import com.cuckoo.config.property.config.ConfigurationKeys;
import com.cuckoo.config.property.config.ConfigurationProvider;
import com.cuckoo.config.property.config.PropertyConfiguration;
import com.model.core.constant.ApplicationConstant;

@Component
public class CallCitiRewardEligibility extends BuildRequestApi {
	
	/*
	 * This function is used to get the city reward eligibility with the dynamic request.
	 * The dynamic request is made from by getting the request arguments from the external user end.
	 */
	public String callCityRewardEligibility(String apiProduct, String endpoint, String authToken, String contentType,
			String countryCode, String businessCode, String acceptLanguage, String accept,
			String cloakedCreditCardNumbers, String merchantCode, String rewardProgram) throws IOException {

		String response = null;
		try {

			HeaderBuilder headerProvider = new BuildRequestHeader();
			PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
			ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
			RequestBuilder requestBuilder = new BuildRequestApi();
			String requestMethod = "get";
			String requestBody = "";

			Map<String, String> queryParameter = new LinkedHashMap<String, String>();
			queryParameter.put(ApplicationConstant.Reward_Program, rewardProgram);
			queryParameter.put(ApplicationConstant.Merchant_Code, merchantCode);

			/*
			 * "setUrlPattern" function is used to build the dynamic URL request.
			 */
			String url = headerProvider.setEligibilityQueryParameter(
					configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_URL),
					configurationProvider.getValue(ConfigurationKeys.VI), apiProduct, cloakedCreditCardNumbers,
					endpoint);

			/*
			 * "buildRewardHearder" function is used to build the dynamic Header.
			 */
			Map<String, String> buildRequestHearder = headerProvider.buildRewardHearder(authToken, contentType,
					countryCode, businessCode, acceptLanguage, accept);
			Map<String, String> setQueryParameter = requestBuilder.setQueryParameter(queryParameter);

			response = sendApiRequest(url, buildRequestHearder, setQueryParameter, requestMethod, requestBody);

			System.out.println("Client Reward Eligibility :" + response);

		} catch (Exception e) {
			System.out.println("Someting went wrong in reward eligibility API" + e);
		}

		if (!StringUtils.isEmpty(response)) {
			return response;
		} else {
			return "Someting went wrong in reward eligibility API";
		}

	}

}