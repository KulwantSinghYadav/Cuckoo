package io.city.core.api.client.reward.balance;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
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

import io.city.core.api.client.reward.linkage.CallCitiRewardLinkage;

@Component
public class CallCitiRewardBalance {

	/*
	 * This function is used to get the city reward balance with the dynamic request.
	 * The dynamic request is made from by getting the request arguments from the external user end.
	 */
	public String callCityReward(String apiProduct, String endpoint, String authToken, String contentType,
			String countryCode, String businessCode, String acceptLanguage, String accept,
			String cloakedCreditCardNumbers, String merchantCode, String rewardProgram) throws IOException {

		String response = null;
		try {

			HeaderBuilder headerProvider = new BuildRequestHeader();
			RequestBuilder requestBuilder = new BuildRequestApi();
			CallCitiRewardLinkage callCitiRewardLinkage = new CallCitiRewardLinkage();
			PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
			ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
			String requestMethod = "get";
			String requestBody = "";
			
			/*
			 * "callCityRewardLinkage" function will the  City  Reward Linkage response from the class CallCitiRewardLinkage.
			 */
			String rewardLinkCodeResponse = callCitiRewardLinkage.callCityRewardLinkage(authToken, contentType,
					countryCode, businessCode, acceptLanguage, accept);
			
			/*
			 * "getRewardLinkCode" function get the response form the mapped response of Reward Linkage Api.
			 */
			String rewardLinkCode = getRewardLinkCode(rewardLinkCodeResponse);

			/*
			 * "setUrlPattern" function is used to build the dynamic URL request.
			 */
			String url = headerProvider.setUrlPattern(configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_URL),
					configurationProvider.getValue(ConfigurationKeys.VI), apiProduct, endpoint);

			Map<String, String> queryParameter = new LinkedHashMap<String, String>();
			queryParameter.put(ApplicationConstant.Cloaked_Credit_Card_Numbers, cloakedCreditCardNumbers);
			queryParameter.put(ApplicationConstant.Merchant_Code, merchantCode);
			queryParameter.put(ApplicationConstant.Reward_Program, rewardProgram);
			queryParameter.put(ApplicationConstant.Reward_Link_Code, rewardLinkCode);
			
			/*
			 * "buildRewardHearder" function is used to build the dynamic Header.
			 */
			Map<String, String> buildRequestHearder = headerProvider.buildRewardHearder(authToken, contentType,
					countryCode, businessCode, acceptLanguage, accept);
			Map<String, String> setQueryParameter = requestBuilder.setQueryParameter(queryParameter);

			// call the city reward api by passing required parameters.
			response = requestBuilder.sendApiRequest(url, buildRequestHearder, setQueryParameter, requestMethod,
					requestBody);

			System.out.println("Client Reward Balance :" + response);

		} catch (Exception e) {
			System.out.println("Someting went wrong in reward balance API" + e);
		}

		if (!StringUtils.isEmpty(response)) {
			return response;
		} else {
			return "Someting went wrong in reward balance API";
		}

	}

	private String getRewardLinkCode(String rewardLinkCodeResponse) {
		JSONObject obj = new JSONObject(rewardLinkCodeResponse);
		return obj.getString("rewardLinkCode");
	}
}