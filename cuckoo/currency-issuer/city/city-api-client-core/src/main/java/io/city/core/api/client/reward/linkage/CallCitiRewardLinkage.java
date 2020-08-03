package io.city.core.api.client.reward.linkage;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cuckoo.config.api.ReqRes.model.RewardLinkageRequestBody;
import com.cuckoo.config.api.config.BuildRequestApi;
import com.cuckoo.config.api.config.BuildRequestHeader;
import com.cuckoo.config.api.config.HeaderBuilder;
import com.cuckoo.config.property.config.ConfigurationKeys;
import com.cuckoo.config.property.config.ConfigurationProvider;
import com.cuckoo.config.property.config.PropertyConfiguration;
import com.google.gson.Gson;
import com.model.core.constant.ApplicationConstant;

import okhttp3.RequestBody;

@Component
public class CallCitiRewardLinkage extends BuildRequestApi {

	/*
	 * This function is used to get the city reward linkage with the dynamic
	 * request. The dynamic request is made from by getting the request arguments
	 * from the external user end.
	 */
	public String callCityRewardLinkage(String apiProduct, String endpoint, String accessToken, String contentType,
			String countryCode, String businessCode, String acceptLanguage, String accept,
			String cloakedCreditCardNumbers, String merchantCode, String rewardProgram, String billingZipCode) throws IOException {

		String response = null;
		try {
			HeaderBuilder headerProvider = new BuildRequestHeader();
			PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
			ConfigurationProvider configurationProvider = propertyConfiguration.loadProperties();
			

			RewardLinkageRequestBody rewardLinkage = new RewardLinkageRequestBody(rewardProgram,merchantCode,cloakedCreditCardNumbers,billingZipCode);
			
			Gson gson = new Gson();
			String rewardLinkageBody = gson.toJson(rewardLinkage);

//			RequestBody requestBody = RequestBody.create(ApplicationConstant.JSON_MEDIA_TYPE, ApplicationConstant.Get_Citi_Reward_Linkage_Body);
			RequestBody requestBody = RequestBody.create(ApplicationConstant.JSON_MEDIA_TYPE, rewardLinkageBody);
			/*
			 * "setUrlPattern" function is used to build the dynamic URL request.
			 */
			String url = headerProvider.setUrlPattern(configurationProvider.getValue(ConfigurationKeys.CITY_REWARD_URL),
					configurationProvider.getValue(ConfigurationKeys.VI), apiProduct, configurationProvider.getValue(ConfigurationKeys.LINKAGEEND_POINT));

			/*
			 * "buildRewardHearder" function is used to build the dynamic Header.
			 */
			Map<String, String> buildRequestHearder = headerProvider.buildRewardHearder(accessToken, contentType,
					countryCode, businessCode, acceptLanguage, accept);

			// call the city reward linkage api by passing requied parameters.
			response = sendApiRequest(url, buildRequestHearder, requestBody);

			System.out.println("Client Reward Linkage :" + response);
		} catch (Exception e) {
			System.out.println("Someting went wrong in reward linkage API" + e);
		}

		if (!StringUtils.isEmpty(response)) {
			return response;
		} else {
			return "Someting went wrong  in reward linkage API";
		}

	}

}