package com.cuckoo.config.api.utills;

import java.sql.Timestamp;

import org.json.JSONObject;
import org.springframework.util.StringUtils;

import com.cuckoo.config.api.ReqRes.model.RewardEnablementReqResModel;
import com.model.core.model.api.RewardEnablement;

public class RewardEnablementUtills {

	public static RewardEnablement setRewardEnablementRequest(RewardEnablementReqResModel rewardEnablementBody,
			String status, String bankName) {
		
		RewardEnablement rewardEnablementRequestBody = new RewardEnablement();
		
		rewardEnablementRequestBody.setBankName(bankName);
		rewardEnablementRequestBody.setCloakedCreditCardNumber(rewardEnablementBody.getCloakedCreditCardNumber());
		rewardEnablementRequestBody.setEnableProgramIndicator(rewardEnablementBody.getEnableProgramIndicator());
		rewardEnablementRequestBody.setMerchantCode(rewardEnablementBody.getMerchantCode());
		rewardEnablementRequestBody.setRewardLinkCode(rewardEnablementBody.getRewardLinkCode());
		rewardEnablementRequestBody.setRewardProgram(rewardEnablementBody.getRewardProgram());
		rewardEnablementRequestBody.setStatus(status);
		rewardEnablementRequestBody.setCreationTime(new Timestamp(System.currentTimeMillis()));
		
		return rewardEnablementRequestBody;
	}

	public static RewardEnablement setRewardEnablementResponse(RewardEnablement rewardEnablement, String status,
			RewardEnablementReqResModel rewardEnablementReqResModel) {

		rewardEnablement.setStatus(status);
		
		return rewardEnablement;
	}

	public static RewardEnablementReqResModel getRewardEnablementResponse(String rewardEnablementResponse) {
		
		RewardEnablementReqResModel rewardEnablementReqResModel = new RewardEnablementReqResModel();

		if(!StringUtils.isEmpty(rewardEnablementResponse)) {
			JSONObject enablementResponse = new JSONObject(rewardEnablementResponse);
			
			if (rewardEnablementResponse.contains("error")) {
				rewardEnablementReqResModel.setError("error");
				rewardEnablementReqResModel.setError(rewardEnablementResponse);
			} else if (!rewardEnablementResponse.contains("error")) {
			}
		
		}
	return rewardEnablementReqResModel;
	}

}
