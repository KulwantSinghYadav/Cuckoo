package com.cuckoo.config.api.ReqRes.model;

public class RewardEligibilityResponseModel {

	String error;
	String errorResponse;
	String eligibilityIndicator;

	public RewardEligibilityResponseModel(String error, String errorResponse, String eligibilityIndicator) {
		super();
		this.error = error;
		this.errorResponse = errorResponse;
		this.eligibilityIndicator = eligibilityIndicator;
	}

	public RewardEligibilityResponseModel() {
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

	public String getEligibilityIndicator() {
		return eligibilityIndicator;
	}

	public void setEligibilityIndicator(String eligibilityIndicator) {
		this.eligibilityIndicator = eligibilityIndicator;
	}

}
