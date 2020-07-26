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

import com.model.core.model.api.RewardEnablement;

import cuckoo.web.service.AuthorizationService;
import cuckoo.web.service.RewardEnablementService;
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
			@RequestBody String rewardEnablementBody) throws IOException {

		RewardEnablement citiRewardEnablementRequestResponse = new RewardEnablement();
		/*
		 * below code is only for city reward balance api to check successfully
		 * insertion of response data.
		 */
		String accessToken = authorizationService.getAuthorizationToken();
		String response = callCitiRewardEnablement.callCityRewardEnablement(apiProduct, endpoint, accessToken,
				contentType, countryCode, businessCode, acceptLanguage, accept,rewardEnablementBody);

		citiRewardEnablementRequestResponse.setApiName("rewardEnablement");
		citiRewardEnablementRequestResponse.setCreationTime(new Timestamp(System.currentTimeMillis()));
		citiRewardEnablementRequestResponse.setResponseData(response);
		citiRewardEnablementRequestResponse.setRequestUrl(".");

		rewardEnablementService.addRewardEnablement(citiRewardEnablementRequestResponse);

		return response;
	}

}
