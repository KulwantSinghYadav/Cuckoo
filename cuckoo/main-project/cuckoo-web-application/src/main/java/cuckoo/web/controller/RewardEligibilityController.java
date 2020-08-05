package cuckoo.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.config.api.ReqRes.model.RewardEligibilityResponseModel;
import com.cuckoo.config.api.utills.RewardEligibilityUtills;
import com.model.core.constant.ApplicationConstant;
import com.model.core.model.api.RewardEligibility;

import cuckoo.web.service.AuthorizationService;
import cuckoo.web.service.RewardEligibilityService;
import io.city.core.api.client.reward.eligibility.CallCitiRewardEligibility;


/*
 * This class is used as controller of reward eligibility related api's.
 */

@Controller
public class RewardEligibilityController {

	@Autowired
	private RewardEligibilityService rewardEligibilityService;

	@Autowired
	AuthorizationService authorizationService;

	CallCitiRewardEligibility callCitiRewardEligibility = new CallCitiRewardEligibility();

	@RequestMapping(value = "/getCitiRewardEligibilityApiData", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<RewardEligibility> getCitiRewardEligibilityApiData() {

		List<RewardEligibility> listOfRewardEligibility = rewardEligibilityService.getAllCitiRewardEligibility();
		return listOfRewardEligibility;
	}

	@RequestMapping(value = "/rewardEligibility/{apiProduct}/{cloakedCreditCardNumbers}/{endpoint}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String addCitiRewardEligibility(@PathVariable("apiProduct") String apiProduct,
			@PathVariable("endpoint") String endpoint,
			@PathVariable("cloakedCreditCardNumbers") String cloakedCreditCardNumbers,
			@RequestHeader(value = "content-type") String contentType,
			@RequestHeader(value = "countrycode") String countryCode,
			@RequestHeader(value = "businesscode") String businessCode,
			@RequestHeader(value = "accept-language") String acceptLanguage,
			@RequestHeader(value = "accept") String accept, @RequestParam("merchantCode") String merchantCode,
			@RequestParam("rewardProgram") String rewardProgram) throws IOException {

		RewardEligibilityResponseModel rewardEligibilityResponseModel = new RewardEligibilityResponseModel();
		
		/*
		 * below code is only for city reward balance api to check successfully
		 * insertion of response data.
		 */
		String accessToken = authorizationService.getAuthorizationToken();
		
		RewardEligibility rewardEligibilityRequest = RewardEligibilityUtills.setRewardEligibilityRequest(cloakedCreditCardNumbers,
				merchantCode, rewardProgram, ApplicationConstant.Pending, ApplicationConstant.City);

		rewardEligibilityService.addRewardEligibility(rewardEligibilityRequest);
		
		String response = callCitiRewardEligibility.callCityRewardEligibility(apiProduct, endpoint, accessToken,
				contentType, countryCode, businessCode, acceptLanguage, accept, cloakedCreditCardNumbers, merchantCode,
				rewardProgram);
		
		rewardEligibilityResponseModel = RewardEligibilityUtills.getRewardEligibilityResponse(response);
		
		if(!StringUtils.isEmpty(rewardEligibilityResponseModel.getError())) {
			
			RewardEligibility rewardEligibility = rewardEligibilityService.getRewardEligibility(rewardEligibilityRequest.getTransId());
			RewardEligibility rewardEligibilityResponse = RewardEligibilityUtills.setRewardEligibilityResponse(rewardEligibility,ApplicationConstant.Error,rewardEligibilityResponseModel);
			
			rewardEligibilityService.updateCitiRewardEligibility(rewardEligibilityResponse);
		} else if(StringUtils.isEmpty(rewardEligibilityResponseModel.getError())) {
			
			RewardEligibility rewardEligibility = rewardEligibilityService.getRewardEligibility(rewardEligibilityRequest.getTransId());
			RewardEligibility rewardEligibilityResponse = RewardEligibilityUtills.setRewardEligibilityResponse(rewardEligibility,ApplicationConstant.Completed,rewardEligibilityResponseModel);
			
			rewardEligibilityService.updateCitiRewardEligibility(rewardEligibilityResponse);
		}
		return response;

	}
}
