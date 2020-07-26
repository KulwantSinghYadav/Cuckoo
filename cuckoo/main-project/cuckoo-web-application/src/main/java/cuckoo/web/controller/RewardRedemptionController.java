package cuckoo.web.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.core.model.api.RewardRedemption;

import cuckoo.web.service.AuthorizationService;
import cuckoo.web.service.RewardRedemptionService;
import io.city.core.api.client.reward.redemption.CallCitiRewardRedemption;

/*
 * This class is used as controller of reward redemption related api's.
 */

@Controller
public class RewardRedemptionController {

	@Autowired
	private RewardRedemptionService rewardRedemptionService;

	@Autowired
	AuthorizationService authorizationService;

	CallCitiRewardRedemption callCitiRewardRedemption = new CallCitiRewardRedemption();

	@RequestMapping(value = "/getCitiRewardRedemptionApiData", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<RewardRedemption> getCitiRewardRedemptionApiData() {

		List<RewardRedemption> listOfRewardRedemption = rewardRedemptionService.getAllCitiRewardRedemption();
		return listOfRewardRedemption;
	}

	@RequestMapping(value = "/rewardRedemption/{apiProduct}/{endpoint}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String addCitiRewardRedemption(@PathVariable("apiProduct") String apiProduct,
			@PathVariable("endpoint") String endpoint, @RequestHeader(value = "content-type") String contentType,
			@RequestHeader(value = "countrycode") String countryCode,
			@RequestHeader(value = "businesscode") String businessCode,
			@RequestHeader(value = "accept-language") String acceptLanguage,
			@RequestHeader(value = "accept") String accept, @RequestBody String redemptionRequestBody)
			throws IOException {

		RewardRedemption citiRewardRedemptionRequestResponse = new RewardRedemption();
		/*
		 * below code is only for city reward balance api to check successfully
		 * insertion of response data.
		 */
		String accessToken = authorizationService.getAuthorizationToken();
		String response = callCitiRewardRedemption.callCityRewardRedemption(apiProduct, endpoint, accessToken,
				contentType, countryCode, businessCode, acceptLanguage, accept, redemptionRequestBody);

		citiRewardRedemptionRequestResponse.setApiName("rewardRedemption");
		citiRewardRedemptionRequestResponse.setCreationTime(new Timestamp(System.currentTimeMillis()));
		citiRewardRedemptionRequestResponse.setResponseData(response);
		citiRewardRedemptionRequestResponse.setRequestUrl(".");

		rewardRedemptionService.addRewardRedemption(citiRewardRedemptionRequestResponse);

		return response;
	}

}
