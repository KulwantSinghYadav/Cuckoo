package cuckoo.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.config.api.ReqRes.model.RewardRedemptionReqResModel;
import com.cuckoo.config.api.utills.RewardRedemptionUtills;
import com.model.core.constant.ApplicationConstant;
import com.model.core.model.api.RewardRedemption;

import cuckoo.web.service.AuthorizationService;
import cuckoo.web.service.RewardLinkageService;
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

	@Autowired
	RewardLinkageService rewardLinkageService;

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

		List<String> rewardLinkMainResponse = new ArrayList<String>();
		String billingZipCode = "12345";
		String response = "";

		RewardRedemptionReqResModel rewardRedemptionRequestModel = RewardRedemptionUtills
				.getRewardRedemptionBody(redemptionRequestBody);
		
		String getRewardLinkCode = rewardRedemptionRequestModel.getRewardLinkCode();

		/*
		 * below code is only for city reward balance api to check successfully
		 * insertion of response data.
		 */
		String accessToken = authorizationService.getAuthorizationToken();

		if (StringUtils.isEmpty(rewardRedemptionRequestModel.getRewardLinkCode())) {
			getRewardLinkCode = rewardLinkageService.getRewardLinkage(rewardRedemptionRequestModel.getCloakedCreditCardNumber());
		}

		if (StringUtils.isEmpty(rewardRedemptionRequestModel.getRewardLinkCode())
				&& StringUtils.isEmpty(getRewardLinkCode)) {

			rewardLinkMainResponse = rewardLinkageService.createRewardLinkageCode(apiProduct, endpoint, accessToken,
					contentType, countryCode, businessCode, acceptLanguage, accept,
					rewardRedemptionRequestModel.getCloakedCreditCardNumber(),
					rewardRedemptionRequestModel.getMerchantCode(), rewardRedemptionRequestModel.getRewardProgram(),
					billingZipCode);
		}

		if (rewardLinkMainResponse.size() > 0 && rewardLinkMainResponse.get(0).equalsIgnoreCase("errors")) {
			
			response = rewardLinkMainResponse.get(1);
			return response;
			
		} else if(StringUtils.isEmpty(rewardRedemptionRequestModel.getRewardLinkCode()) && !rewardLinkMainResponse.get(0).equalsIgnoreCase("errors")){
			
			getRewardLinkCode = rewardLinkMainResponse.get(0);
			rewardRedemptionRequestModel.setRewardLinkCode(getRewardLinkCode);
		}
			RewardRedemption rewardRedemptionRequestBody = RewardRedemptionUtills.setRewardRedemptionRequest(rewardRedemptionRequestModel, ApplicationConstant.Pending, ApplicationConstant.City);

			rewardRedemptionService.addRewardRedemption(rewardRedemptionRequestBody);

			response = callCitiRewardRedemption.callCityRewardRedemption(apiProduct, endpoint, accessToken, contentType,countryCode, businessCode, acceptLanguage, accept, redemptionRequestBody);
			
			RewardRedemptionReqResModel rewardRedemptionResponseModel = RewardRedemptionUtills
					.getRewardRedemptionResponse(response);
			
			if (!StringUtils.isEmpty(rewardRedemptionResponseModel.getError())) {

				RewardRedemption rewardRedemption = rewardRedemptionService.getRewardRedemption(rewardRedemptionRequestBody.getTransId());
				RewardRedemption rewardRedemptionResponse = RewardRedemptionUtills.setRewardRedemptionResponse(rewardRedemption, ApplicationConstant.Error, rewardRedemptionResponseModel);

				rewardRedemptionService.updateRewardRedemption(rewardRedemptionResponse);
			} else if (StringUtils.isEmpty(rewardRedemptionResponseModel.getError())) {

				RewardRedemption rewardRedemption = rewardRedemptionService.getRewardRedemption(rewardRedemptionRequestBody.getTransId());
				RewardRedemption rewardRedemptionResponse = RewardRedemptionUtills.setRewardRedemptionResponse(rewardRedemption, ApplicationConstant.Completed, rewardRedemptionResponseModel);

				rewardRedemptionService.updateRewardRedemption(rewardRedemptionResponse);
			}
		return response;
	}

}
