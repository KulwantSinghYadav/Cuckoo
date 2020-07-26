package cuckoo.web.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.core.model.api.RewardBalance;

import cuckoo.web.service.AuthorizationService;
import cuckoo.web.service.RewardBalanceService;
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
			@RequestHeader(value = "cloakedCreditCardNumbers") String cloakedCreditCardNumbers,
			@RequestHeader(value = "merchantCode") String merchantCode,
			@RequestHeader(value = "rewardProgram") String rewardProgram) throws IOException {

		RewardBalance CitiRewardBalanceRequestResponse = new RewardBalance();
		/*
		 * below code is only for city reward balance api to check successfully
		 * insertion of response data.
		 */
		String accessToken = authorizationService.getAuthorizationToken();
		String response = callCitiRewardBalance.callCityReward(apiProduct, endpoint, accessToken, contentType,
				countryCode, businessCode, acceptLanguage, accept, cloakedCreditCardNumbers, merchantCode,
				rewardProgram);

		CitiRewardBalanceRequestResponse.setApiName("rewardBalance");
		CitiRewardBalanceRequestResponse.setCreationTime(new Timestamp(System.currentTimeMillis()));
		CitiRewardBalanceRequestResponse.setResponseData(response);
		CitiRewardBalanceRequestResponse.setRequestUrl(".");

		rewardBalanceService.addCitiRewardBalance(CitiRewardBalanceRequestResponse);

		return response;
	}

}
