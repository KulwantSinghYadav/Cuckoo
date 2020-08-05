package com.cuckoo.config.api.ReqRes.model;

import java.util.List;
import java.util.Map;

public class RewardRedemptionReqResModel {
	
	String rewardProgram;
	String cloakedCreditCardNumber;
	String rewardLinkCode;
	String merchantCode;
	int transactionReferenceNumber;
	int transactionAmount;
	int pointsToRedeem;
	String transactionDescription;
	
	long orderId;
	long availablePointBalance;
	
	String error;
	String errorResponse;

	public RewardRedemptionReqResModel() {
		super();
	}

	public RewardRedemptionReqResModel(String rewardProgram, String cloakedCreditCardNumber, String rewardLinkCode,
			String merchantCode, int transactionReferenceNumber, int transactionAmount, int pointsToRedeem,
			String transactionDescription, String error, String errorResponse,long orderId,long availablePointBalance) {
		super();
		this.rewardProgram = rewardProgram;
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
		this.orderId = orderId;
		this.rewardLinkCode = rewardLinkCode;
		this.merchantCode = merchantCode;
		this.transactionReferenceNumber = transactionReferenceNumber;
		this.transactionAmount = transactionAmount;
		this.pointsToRedeem = pointsToRedeem;
		this.transactionDescription = transactionDescription;
		this.error = error;
		this.errorResponse = errorResponse;
		this.availablePointBalance = availablePointBalance;
	}

	public String getRewardProgram() {
		return rewardProgram;
	}

	public void setRewardProgram(String rewardProgram) {
		this.rewardProgram = rewardProgram;
	}

	public String getCloakedCreditCardNumber() {
		return cloakedCreditCardNumber;
	}

	public void setCloakedCreditCardNumber(String cloakedCreditCardNumber) {
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
	}

	public String getRewardLinkCode() {
		return rewardLinkCode;
	}

	public void setRewardLinkCode(String rewardLinkCode) {
		this.rewardLinkCode = rewardLinkCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public int getTransactionReferenceNumber() {
		return transactionReferenceNumber;
	}

	public void setTransactionReferenceNumber(int transactionReferenceNumber) {
		this.transactionReferenceNumber = transactionReferenceNumber;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(String errorResponse) {
		this.errorResponse = errorResponse;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getPointsToRedeem() {
		return pointsToRedeem;
	}

	public void setPointsToRedeem(int pointsToRedeem) {
		this.pointsToRedeem = pointsToRedeem;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getAvailablePointBalance() {
		return availablePointBalance;
	}

	public void setAvailablePointBalance(long availablePointBalance) {
		this.availablePointBalance = availablePointBalance;
	}
	
}
