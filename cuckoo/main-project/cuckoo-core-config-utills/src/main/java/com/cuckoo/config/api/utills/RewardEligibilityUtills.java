package com.cuckoo.config.api.utills;

import org.json.JSONObject;

import com.cuckoo.config.api.ReqRes.model.RewardEligibilityResponseModel;
import com.cuckoo.config.datetime.utill.DateTimeUtill;
import com.model.core.model.api.RewardEligibility;

public class RewardEligibilityUtills {

	public static RewardEligibility setRewardEligibilityRequest(String cloakedCreditCardNumbers, String merchantCode,
			String rewardProgram, String status, String city) {
		RewardEligibility rewardEligibility = new RewardEligibility();

		rewardEligibility.setCloakedCreditCardNumber(cloakedCreditCardNumbers);
		rewardEligibility.setMerchantCode(merchantCode);
		rewardEligibility.setStatus(status);
		rewardEligibility.setRewardProgram(rewardProgram);
		rewardEligibility.setBankName(city);
		rewardEligibility.setCreationTime(DateTimeUtill.getCurrentSqlTimeStamp("CET"));
		return rewardEligibility;
	}

	public static RewardEligibilityResponseModel getRewardEligibilityResponse(String response) {

		RewardEligibilityResponseModel rewardEligibilityResponseModel = new RewardEligibilityResponseModel();

		JSONObject obj = new JSONObject(response);
		if (response.contains("error")) {
			rewardEligibilityResponseModel.setError("error");
			rewardEligibilityResponseModel.setError(response);
		} else if (!response.contains("error")) {

			rewardEligibilityResponseModel.setEligibilityIndicator(obj.getString("eligibilityIndicator"));

		}
		return rewardEligibilityResponseModel;
	}

	public static RewardEligibility setRewardEligibilityResponse(RewardEligibility rewardEligibility, String status,
			RewardEligibilityResponseModel rewardEligibilityResponseModel) {

		rewardEligibility.setStatus(status);
		rewardEligibility.setEligibilityIndicator(rewardEligibilityResponseModel.getEligibilityIndicator());
		return rewardEligibility;
	}

}
