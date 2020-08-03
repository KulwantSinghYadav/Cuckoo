package com.cuckoo.config.api.utills;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.cuckoo.config.datetime.utill.DateTimeUtill;
import com.model.core.model.api.RewardLinkage;

public class RewardLinkageUtills {

	public static List<String> getRewardLinkCode(String rewardLinkCodeResponse) {
		
		List<String> rewardLinkresponse = new ArrayList<String>();
		
		JSONObject obj = new JSONObject(rewardLinkCodeResponse);

		if (rewardLinkCodeResponse.contains("error")) {
			rewardLinkresponse.add("errors");
			rewardLinkresponse.add(rewardLinkCodeResponse);
		} else if (!rewardLinkCodeResponse.contains("error")) {
			
			rewardLinkresponse.add(obj.getString("rewardLinkCode"));
		} 
		
		return rewardLinkresponse;
	}
	
	public static RewardLinkage setRewardLinkageRequest(String cloakedCreditCardNumbers, String merchantCode,
			String rewardProgram, String billingZipCode, String pending, String bankName) {
		RewardLinkage rewardLinkage = new RewardLinkage();

		rewardLinkage.setCloakedCreditCardNumber(cloakedCreditCardNumbers);
		rewardLinkage.setMerchantCode(merchantCode);
		rewardLinkage.setBillingZipCode(billingZipCode);
		rewardLinkage.setStatus(pending);
		rewardLinkage.setRewardProgram(rewardProgram);
		rewardLinkage.setBankName(bankName);
		rewardLinkage.setCreationTime(DateTimeUtill.getCurrentSqlTimeStamp("CET"));
		return rewardLinkage;
	}

	public static RewardLinkage setRewardLinkageResponse(RewardLinkage rewardLinkage, String status,
			String getRewardLinkCode) {

		rewardLinkage.setRewardLinkCode(getRewardLinkCode);
		rewardLinkage.setStatus(status);
		rewardLinkage.setCreationTime(DateTimeUtill.getCurrentSqlTimeStamp("CET"));
		return rewardLinkage;
	}


}
