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

import com.cuckoo.config.api.ReqRes.model.RewardEnablementReqResModel;
import com.cuckoo.config.api.utills.RewardEnablementUtills;
import com.model.core.constant.ApplicationConstant;
import com.model.core.model.api.RewardEnablement;

import cuckoo.web.service.AuthorizationService;
import cuckoo.web.service.RewardEnablementService;
import cuckoo.web.service.RewardLinkageService;
import io.city.core.api.client.reward.enablement.CallCitiRewardEnablement;

/*
 * This class is used as controller of reward enablement related api's.
 */

@Controller
public class RewardEnablementController {

	@Autowired
	private RewardEnablementService rewardEnablementService;

	@Autowired
	AuthorizationService authorizationService;

	@Autowired
	RewardLinkageService rewardLinkageService;

	CallCitiRewardEnablement callCitiRewardEnablement = new CallCitiRewardEnablement();

	@RequestMapping(value = "/getCitiRewardEnablementApiData", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<RewardEnablement> getCitiRewardEnablementApiData() {

		List<RewardEnablement> listOfRewardEnablement = rewardEnablementService.getAllCitiRewardEnablement();
		return listOfRewardEnablement;
	}

	@RequestMapping(value = "/rewardEnablement/{apiProduct}/{endpoint}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String addCitiRewardEnablement(@PathVariable("apiProduct") String apiProduct,
			@PathVariable("endpoint") String endpoint, @RequestHeader(value = "content-type") String contentType,
			@RequestHeader(value = "countrycode") String countryCode,
			@RequestHeader(value = "businesscode") String businessCode,
			@RequestHeader(value = "accept-language") String acceptLanguage,
			@RequestHeader(value = "accept") String accept,
			@RequestBody RewardEnablementReqResModel rewardEnablementBody) throws IOException {

		List<String> rewardLinkMainResponse = new ArrayList<String>();
		String billingZipCode = "12345";
		String response = "";
		String accessToken = authorizationService.getAuthorizationToken();

		String getRewardLinkCode = rewardEnablementBody.getRewardLinkCode();

		if (StringUtils.isEmpty(rewardEnablementBody.getRewardLinkCode())) {
			getRewardLinkCode = rewardLinkageService
					.getRewardLinkage(rewardEnablementBody.getCloakedCreditCardNumber());
		}

		if (StringUtils.isEmpty(rewardEnablementBody.getRewardLinkCode()) && StringUtils.isEmpty(getRewardLinkCode)) {

			rewardLinkMainResponse = rewardLinkageService.createRewardLinkageCode(apiProduct, endpoint, accessToken,
					contentType, countryCode, businessCode, acceptLanguage, accept,
					rewardEnablementBody.getCloakedCreditCardNumber(), rewardEnablementBody.getMerchantCode(),
					rewardEnablementBody.getRewardProgram(), billingZipCode);
		}

		/*
		 * below code is only for city reward balance api to check successfully
		 * insertion of response data.
		 */

		if (rewardLinkMainResponse.size() > 0 && rewardLinkMainResponse.get(0).equalsIgnoreCase("errors")) {

			response = rewardLinkMainResponse.get(1);
			return response;

		} else if (StringUtils.isEmpty(rewardEnablementBody.getRewardLinkCode())
				&& !rewardLinkMainResponse.get(0).equalsIgnoreCase("errors")) {

			getRewardLinkCode = rewardLinkMainResponse.get(0);
			rewardEnablementBody.setRewardLinkCode(getRewardLinkCode);

		}
		
		RewardEnablement rewardEnablementRequestBody = RewardEnablementUtills.setRewardEnablementRequest(rewardEnablementBody, ApplicationConstant.Pending, ApplicationConstant.City);

		rewardEnablementService.addRewardEnablement(rewardEnablementRequestBody);
		
		response = callCitiRewardEnablement.callCityRewardEnablement(apiProduct, endpoint, accessToken, contentType,
				countryCode, businessCode, acceptLanguage, accept, rewardEnablementBody);

		RewardEnablementReqResModel rewardEnablementReqResModel = RewardEnablementUtills
				.getRewardEnablementResponse(response);
		
		if (!StringUtils.isEmpty(rewardEnablementReqResModel.getError())) {

			RewardEnablement rewardEnablement = rewardEnablementService.getRewardEnablement(rewardEnablementRequestBody.getTransId());
			RewardEnablement rewardEnablementResponse = RewardEnablementUtills.setRewardEnablementResponse(rewardEnablement, ApplicationConstant.Error, rewardEnablementReqResModel);

			rewardEnablementService.updateRewardEnablement(rewardEnablementResponse);
		} else if (StringUtils.isEmpty(rewardEnablementReqResModel.getError())) {

			RewardEnablement rewardEnablement = rewardEnablementService.getRewardEnablement(rewardEnablementRequestBody.getTransId());
			RewardEnablement rewardEnablementResponse = RewardEnablementUtills.setRewardEnablementResponse(rewardEnablement, ApplicationConstant.Completed, rewardEnablementReqResModel);

			rewardEnablementService.updateRewardEnablement(rewardEnablementResponse);
		}
		
		return response;
	}

}
