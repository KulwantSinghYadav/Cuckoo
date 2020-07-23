package cuckoo.web.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuckoo.config.client.auth.CallAuthorization;
import com.model.core.model.city.CitiRewardBalanceRequestResponse;

import cuckoo.web.service.AuthorizationService;
import cuckoo.web.service.CitiRewardBalanceReqResService;
import io.city.core.api.client.reward.balance.CallCitiRewardBalance;

@Controller
public class CitiReqResController {

	@Autowired
	private CitiRewardBalanceReqResService citiRewardBalanceReqResService;
	
	@Autowired
	AuthorizationService authorizationService;
	
	CallCitiRewardBalance callCitiRewardBalance = new CallCitiRewardBalance();
	CallAuthorization callAuthorization = new CallAuthorization();

	@RequestMapping(value = "/getCitiApiData", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllReqRes(Model model) {

		List<CitiRewardBalanceRequestResponse> listOfReqRes = citiRewardBalanceReqResService.getAllCitiRBReqRes();
		model.addAttribute("citiReqRes", new CitiRewardBalanceRequestResponse());
		model.addAttribute("listOfReqRes", listOfReqRes);
		return "cityApiPage";
	}

	@RequestMapping(value = "/citiApi", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getCitiApiData";
	}

	@RequestMapping(value = "/addCitiApiReqRes", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCitiApiReqRes(
			@ModelAttribute("citiReqRes") CitiRewardBalanceRequestResponse CitiRewardBalanceRequestResponse)
			throws IOException {

		/*
		 * below code is only for city reward balance api to check successfully
		 * insertion of response data.
		 */
		String accessToken = authorizationService.getAuthorizationToken();
		String response = callCitiRewardBalance.callCityReward(accessToken);

		CitiRewardBalanceRequestResponse.setCreationTime(new Timestamp(System.currentTimeMillis()));
		CitiRewardBalanceRequestResponse.setResponseData(response);
		CitiRewardBalanceRequestResponse.setRequestUrl("Coding Is left");

		citiRewardBalanceReqResService.addCitiRBReqRes(CitiRewardBalanceRequestResponse);

		return "redirect:/getCitiApiData";
	}

	@RequestMapping(value = "/deleteCitiApiReqRes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCitiApiReqRes(@PathVariable("id") int id) {

		/*
		 * below code is only for city reward balance api to check successfully deletion
		 * of response data.
		 */

		citiRewardBalanceReqResService.deleteCitiRBReqRes(id);
		return "redirect:/getCitiApiData";

	}

}
