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

import com.model.core.model.api.RewardLinkage;

import cuckoo.web.service.AuthorizationService;
import cuckoo.web.service.RewardLinkageService;
import io.city.core.api.client.reward.linkage.CallCitiRewardLinkage;


/*
 * This class is used as controller of reward linkage related api's.
 */

@Controller
public class RewardLinkageController {

	@Autowired
	private RewardLinkageService RewardLinkageService;

	@Autowired
	AuthorizationService authorizationService;

	CallCitiRewardLinkage callCitiRewardLinkage = new CallCitiRewardLinkage();

	@RequestMapping(value = "/getCitiRewardLinkageApiData", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<RewardLinkage> getCitiRewardLinkageApiData() {

		List<RewardLinkage> listOfRewardLinkage = RewardLinkageService.getAllCitiRewardLinkage();
		return listOfRewardLinkage;
	}

	@RequestMapping(value = "/rewardLinkage/{apiProduct}/{endpoint}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String addCitiRewardLinkage(@PathVariable("apiProduct") String apiProduct,
			@PathVariable("endpoint") String endpoint,
			@RequestHeader(value = "content-type") String contentType,
			@RequestHeader(value = "countrycode") String countryCode,
			@RequestHeader(value = "businesscode") String businessCode,
			@RequestHeader(value = "accept-language") String acceptLanguage,
			@RequestHeader(value = "accept") String accept,
			@RequestBody String rewardLinkageBody) throws IOException {

		RewardLinkage CitiRewardLinkageRequestResponse = new RewardLinkage();
		/*
		 * below code is only for city reward balance api to check successfully
		 * insertion of response data.
		 */
		String accessToken = authorizationService.getAuthorizationToken();
		String response = callCitiRewardLinkage.callCityRewardLinkage(apiProduct, endpoint, accessToken,
				contentType, countryCode, businessCode, acceptLanguage, accept,rewardLinkageBody);

		CitiRewardLinkageRequestResponse.setApiName("RewardLinkage");
		CitiRewardLinkageRequestResponse.setCreationTime(new Timestamp(System.currentTimeMillis()));
		CitiRewardLinkageRequestResponse.setResponseData(response);
		CitiRewardLinkageRequestResponse.setRequestUrl(".");

		RewardLinkageService.addRewardLinkage(CitiRewardLinkageRequestResponse);

		return response;

	}
}

