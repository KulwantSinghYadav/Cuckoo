package com.cuckoo.config.api.ReqRes.model;

public class RewardBalanceResponseModel {

	Boolean isRedemptionEligible;
	int availablePointBalance;
	float programConversionRate;
	String localCurrencyCode;
	int redemptionPointIncrement;
	int maximumPointsToRedeem;
	int minimumPointsToRedeem;
	String error;
	String errorResponse;
	
	public RewardBalanceResponseModel(Boolean isRedemptionEligible, int availablePointBalance,
			float programConversionRate, String localCurrencyCode, int redemptionPointIncrement,
			int maximumPointsToRedeem, int minimumPointsToRedeem,String error,String errorResponse) {
		super();
		this.isRedemptionEligible = isRedemptionEligible;
		this.availablePointBalance = availablePointBalance;
		this.programConversionRate = programConversionRate;
		this.localCurrencyCode = localCurrencyCode;
		this.redemptionPointIncrement = redemptionPointIncrement;
		this.maximumPointsToRedeem = maximumPointsToRedeem;
		this.minimumPointsToRedeem = minimumPointsToRedeem;
		this.error = error;
		this.errorResponse = errorResponse;
	}
	
	public RewardBalanceResponseModel() {
	}
	
	public Boolean getIsRedemptionEligible() {
		return isRedemptionEligible;
	}
	public void setIsRedemptionEligible(Boolean isRedemptionEligible) {
		this.isRedemptionEligible = isRedemptionEligible;
	}
	public int getAvailablePointBalance() {
		return availablePointBalance;
	}
	public void setAvailablePointBalance(int availablePointBalance) {
		this.availablePointBalance = availablePointBalance;
	}
	public float getProgramConversionRate() {
		return programConversionRate;
	}
	public void setProgramConversionRate(float programConversionRate) {
		this.programConversionRate = programConversionRate;
	}
	public String getLocalCurrencyCode() {
		return localCurrencyCode;
	}
	public void setLocalCurrencyCode(String localCurrencyCode) {
		this.localCurrencyCode = localCurrencyCode;
	}
	public int getRedemptionPointIncrement() {
		return redemptionPointIncrement;
	}
	public void setRedemptionPointIncrement(int redemptionPointIncrement) {
		this.redemptionPointIncrement = redemptionPointIncrement;
	}
	public int getMaximumPointsToRedeem() {
		return maximumPointsToRedeem;
	}
	public void setMaximumPointsToRedeem(int maximumPointsToRedeem) {
		this.maximumPointsToRedeem = maximumPointsToRedeem;
	}
	public int getMinimumPointsToRedeem() {
		return minimumPointsToRedeem;
	}
	public void setMinimumPointsToRedeem(int minimumPointsToRedeem) {
		this.minimumPointsToRedeem = minimumPointsToRedeem;
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
	
}
