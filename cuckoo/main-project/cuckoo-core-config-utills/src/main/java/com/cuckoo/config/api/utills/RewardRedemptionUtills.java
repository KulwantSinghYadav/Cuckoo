package com.cuckoo.config.api.utills;

import org.json.JSONObject;

import com.cuckoo.config.api.ReqRes.model.RewardRedemptionReqResModel;
import com.cuckoo.config.datetime.utill.DateTimeUtill;
import com.model.core.model.api.RewardRedemption;

public class RewardRedemptionUtills {

	public static RewardRedemptionReqResModel getRewardRedemptionBody(String rewardRedemptionBody) {

		RewardRedemptionReqResModel rewardRedemptionRequestModel = new RewardRedemptionReqResModel();

		JSONObject obj = new JSONObject(rewardRedemptionBody);

			rewardRedemptionRequestModel.setRewardProgram(obj.getString("rewardProgram"));
			rewardRedemptionRequestModel.setCloakedCreditCardNumber(obj.getString("cloakedCreditCardNumber"));
			
			if(rewardRedemptionBody.contains("rewardLinkCode")) {
				rewardRedemptionRequestModel.setRewardLinkCode(obj.getString("rewardLinkCode"));
			}else {
				rewardRedemptionRequestModel.setRewardLinkCode("");
			}
			rewardRedemptionRequestModel.setMerchantCode(obj.getString("merchantCode"));
			rewardRedemptionRequestModel.setTransactionReferenceNumber(obj.getInt("transactionReferenceNumber"));
			JSONObject redemptionOrder = obj.getJSONObject("redemptionOrder");
			rewardRedemptionRequestModel.setTransactionAmount(redemptionOrder.getInt("transactionAmount"));
			rewardRedemptionRequestModel.setPointsToRedeem(redemptionOrder.getInt("pointsToRedeem"));
			rewardRedemptionRequestModel.setTransactionDescription(redemptionOrder.getString("transactionDescription"));

		return rewardRedemptionRequestModel;
	}

	public static RewardRedemption setRewardRedemptionRequest(RewardRedemptionReqResModel rewardRedemptionRequesyModel, String status, String bankName) {
		
		RewardRedemption rewardRedemption = new RewardRedemption();
		
		rewardRedemption.setBankName(bankName);
		rewardRedemption.setCloakedCreditCardNumber(rewardRedemptionRequesyModel.getCloakedCreditCardNumber());
		rewardRedemption.setCreationTime(DateTimeUtill.getCurrentSqlTimeStamp("CET"));
		rewardRedemption.setMerchantCode(rewardRedemptionRequesyModel.getMerchantCode());
		rewardRedemption.setPointsToRedeem(rewardRedemptionRequesyModel.getPointsToRedeem());
		rewardRedemption.setRewardLinkCode(rewardRedemptionRequesyModel.getRewardLinkCode());
		rewardRedemption.setRewardProgram(rewardRedemptionRequesyModel.getRewardProgram());
		rewardRedemption.setStatus(status);
		rewardRedemption.setTransactionAmount(rewardRedemptionRequesyModel.getTransactionAmount());
		rewardRedemption.setTransactionDescription(rewardRedemptionRequesyModel.getTransactionDescription());
		rewardRedemption.setTransactionReferenceNumber(rewardRedemptionRequesyModel.getTransactionReferenceNumber());
		
		return rewardRedemption;
	}

	public static RewardRedemptionReqResModel getRewardRedemptionResponse(String rewardRedemptionResponse) {
		
		RewardRedemptionReqResModel rewardRedemptionResponseModel = new RewardRedemptionReqResModel();

		JSONObject redemptionresponse = new JSONObject(rewardRedemptionResponse);
		
		if (rewardRedemptionResponse.contains("error")) {
			rewardRedemptionResponseModel.setError("error");
			rewardRedemptionResponseModel.setError(rewardRedemptionResponse);
		} else if (!rewardRedemptionResponse.contains("error")) {
			rewardRedemptionResponseModel.setOrderId(redemptionresponse.getLong("orderID"));
			rewardRedemptionResponseModel.setAvailablePointBalance(redemptionresponse.getLong("availablePointBalance"));
		}
		return rewardRedemptionResponseModel;
	}

	public static RewardRedemption setRewardRedemptionResponse(RewardRedemption rewardRedemption, String status,
			RewardRedemptionReqResModel rewardRedemptionResponseModel) {
		
		rewardRedemption.setOrderId(rewardRedemptionResponseModel.getOrderId());
		rewardRedemption.setAvailablePointBalance(rewardRedemptionResponseModel.getAvailablePointBalance());
		return rewardRedemption;
	}

}
