package com.cuckoo.config.api.utills;

import org.json.JSONObject;

import com.cuckoo.config.api.ReqRes.model.RewardBalanceResponseModel;
import com.cuckoo.config.datetime.utill.DateTimeUtill;
import com.model.core.model.api.RewardBalance;

public class RewardBalanceUtills {

	public static RewardBalance setRewardBalanceRequest(String cloakedCreditCardNumbers, String merchantCode,
			String rewardProgram, String billingZipCode, String pending, String bankName) {
		RewardBalance rewardBalance = new RewardBalance();

		rewardBalance.setCloakedCreditCardNumber(cloakedCreditCardNumbers);
		rewardBalance.setMerchantCode(merchantCode);
		rewardBalance.setBillingZipCode(billingZipCode);
		rewardBalance.setStatus(pending);
		rewardBalance.setRewardProgram(rewardProgram);
		rewardBalance.setBankName(bankName);
		rewardBalance.setCreationTime(DateTimeUtill.getCurrentSqlTimeStamp("CET"));
		return rewardBalance;
	}

	public static RewardBalanceResponseModel getRewardBalanceResponse(String response) {
		
		RewardBalanceResponseModel rewardBalanceResponseModel = new RewardBalanceResponseModel();
		
		JSONObject obj = new JSONObject(response);
		if (response.contains("error")) {
			rewardBalanceResponseModel.setError("error");
			rewardBalanceResponseModel.setError(response);
		}else if (!response.contains("error")) {
			
			rewardBalanceResponseModel.setIsRedemptionEligible(obj.getBoolean("isRedemptionEligible"));
			
			
			if(rewardBalanceResponseModel.getIsRedemptionEligible().equals(Boolean.TRUE)) {
				rewardBalanceResponseModel.setAvailablePointBalance(obj.getInt("availablePointBalance"));
				rewardBalanceResponseModel.setProgramConversionRate(obj.getDouble("programConversionRate"));
				rewardBalanceResponseModel.setLocalCurrencyCode(obj.getString("localCurrencyCode"));
				rewardBalanceResponseModel.setRedemptionPointIncrement(obj.getInt("redemptionPointIncrement"));
				rewardBalanceResponseModel.setMaximumPointsToRedeem(obj.getInt("maximumPointsToRedeem"));
				rewardBalanceResponseModel.setMinimumPointsToRedeem(obj.getInt("minimumPointsToRedeem"));
				
			}
		
		}  
		return rewardBalanceResponseModel;
	}

	public static RewardBalance setRewardBalanceResponse(RewardBalance rewardBalance, String status,
			RewardBalanceResponseModel rewardBalanceResponse) {
		
		rewardBalance.setIsRedemptionEligible(rewardBalanceResponse.getIsRedemptionEligible());
		rewardBalance.setAvailablePointBalance(rewardBalanceResponse.getAvailablePointBalance());
		rewardBalance.setProgramConversionRate(rewardBalanceResponse.getProgramConversionRate());
		rewardBalance.setLocalCurrencyCode(rewardBalanceResponse.getLocalCurrencyCode());
		rewardBalance.setRedemptionPointIncrement(rewardBalanceResponse.getRedemptionPointIncrement());
		rewardBalance.setMaximumPointsToRedeem(rewardBalanceResponse.getMaximumPointsToRedeem());
		rewardBalance.setMinimumPointsToRedeem(rewardBalanceResponse.getMinimumPointsToRedeem());
		rewardBalance.setStatus(status);
		return rewardBalance;
	}

}
