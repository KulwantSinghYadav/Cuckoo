package cuckoo.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.config.api.ReqRes.model.RewardBalanceResponseModel;
import com.cuckoo.config.api.utills.RewardBalanceUtills;
import com.model.core.constant.ApplicationConstant;
import com.model.core.model.api.RewardBalance;

import cuckoo.web.service.AuthorizationService;
import cuckoo.web.service.RewardBalanceService;
import cuckoo.web.service.RewardLinkageService;
import io.city.core.api.client.reward.balance.CallCitiRewardBalance;

/*
 * This class is used as controller of reward balance related api's.
 */

@Controller
public class RewardBalanceController {

	@Autowired
	private RewardBalanceService rewardBalanceService;

	@Autowired
	AuthorizationService authorizationService;

	@Autowired
	RewardLinkageService rewardLinkageService;

	@Autowired
	RewardLinkageController rewardLinkageController;

	CallCitiRewardBalance callCitiRewardBalance = new CallCitiRewardBalance();

	@RequestMapping(value = "/getCitiRewardBalanceApiData", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<RewardBalance> getCitiRewardBalanceApiData(Model model) {

		List<RewardBalance> listOfReqRes = rewardBalanceService.getAllCitiRewardBalance();
		model.addAttribute("citiReqRes", new RewardBalance());
		model.addAttribute("listOfReqRes", listOfReqRes);
		return listOfReqRes;
	}

	@RequestMapping(value = "/rewardBalance/{apiProduct}/{endpoint}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String addCitiRewardBalance(@PathVariable("apiProduct") String apiProduct,
			@PathVariable("endpoint") String endpoint, @RequestHeader(value = "content-type") String contentType,
			@RequestHeader(value = "countrycode") String countryCode,
			@RequestHeader(value = "businesscode") String businessCode,
			@RequestHeader(value = "accept-language") String acceptLanguage,
			@RequestHeader(value = "accept") String accept,
			@RequestParam("cloakedCreditCardNumbers") String cloakedCreditCardNumbers,
			@RequestParam("merchantCode") String merchantCode,
			@RequestParam(value = "rewardLinkCode", required = false) String rewardLinkCode,
			@RequestParam("rewardProgram") String rewardProgram) throws IOException {

		String getRewardLinkCode = "";
		String response = "";
		List<String> rewardLinkMainResponse = new ArrayList<String>();
		RewardBalanceResponseModel rewardBalanceResponseModel = new RewardBalanceResponseModel();

		String billingZipCode = "12345";

		/*
		 * below code is only for city reward balance api to check successfully
		 * insertion of response data.
		 */
		String accessToken = authorizationService.getAuthorizationToken();

		if (StringUtils.isEmpty(rewardLinkCode)) {
			getRewardLinkCode = rewardLinkageService.getRewardLinkage(cloakedCreditCardNumbers);
		}

		if (StringUtils.isEmpty(rewardLinkCode) && StringUtils.isEmpty(getRewardLinkCode)) {

			rewardLinkMainResponse = rewardLinkageService.createRewardLinkageCode(apiProduct, endpoint, accessToken,
					contentType, countryCode, businessCode, acceptLanguage, accept, cloakedCreditCardNumbers,
					merchantCode, rewardProgram, billingZipCode);
		}

		if (rewardLinkMainResponse.size() > 0 && rewardLinkMainResponse.get(0).equalsIgnoreCase("errors")) {
			response = rewardLinkMainResponse.get(1);
		} else {
			
			RewardBalance rewardBalanceRequest = RewardBalanceUtills.setRewardBalanceRequest(cloakedCreditCardNumbers,
					merchantCode, rewardProgram, billingZipCode, ApplicationConstant.Pending, ApplicationConstant.City);

			rewardBalanceService.addCitiRewardBalance(rewardBalanceRequest);
			
			response = callCitiRewardBalance.callCityReward(apiProduct, endpoint, accessToken, contentType, countryCode,
					businessCode, acceptLanguage, accept, cloakedCreditCardNumbers, merchantCode, rewardProgram,
					getRewardLinkCode);
			
			rewardBalanceResponseModel = RewardBalanceUtills.getRewardBalanceResponse(response);
			
			if(!StringUtils.isEmpty(rewardBalanceResponseModel.getError())) {
				
				RewardBalance rewardBalance = rewardBalanceService.getCitiRewardBalance(rewardBalanceRequest.getTransId());
				RewardBalance rewardBalanceResponse = RewardBalanceUtills.setRewardBalanceResponse(rewardBalance,ApplicationConstant.Error,rewardBalanceResponseModel);
				rewardBalanceService.updateCitiRewardBalance(rewardBalanceResponse);
			} else if(StringUtils.isEmpty(rewardBalanceResponseModel.getError())) {
				
				RewardBalance rewardBalance = rewardBalanceService.getCitiRewardBalance(rewardBalanceRequest.getTransId());
				RewardBalance rewardBalanceResponse = RewardBalanceUtills.setRewardBalanceResponse(rewardBalance,ApplicationConstant.Completed,rewardBalanceResponseModel);
				rewardBalanceService.updateCitiRewardBalance(rewardBalanceResponse);
			}
			
			

			
		}

		return response;
	}

}
