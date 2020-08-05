package com.cuckoo.config.api.ReqRes.model;

public class RewardEnablementReqResModel {

	String rewardProgram;
	String merchantCode;
	Boolean enableProgramIndicator;
	String cloakedCreditCardNumber;
	String rewardLinkCode;
	
	String error;
	String errorResponse;

	public RewardEnablementReqResModel() {
		super();
	}

	public RewardEnablementReqResModel(String rewardProgram, String merchantCode, Boolean enableProgramIndicator,
			String cloakedCreditCardNumber, String rewardLinkCode,String error,String errorResponse) {
		super();
		this.rewardProgram = rewardProgram;
		this.merchantCode = merchantCode;
		this.enableProgramIndicator = enableProgramIndicator;
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
		this.rewardLinkCode = rewardLinkCode;
		this.error = error;
		this.errorResponse = errorResponse;
	}

	public String getRewardProgram() {
		return rewardProgram;
	}

	public void setRewardProgram(String rewardProgram) {
		this.rewardProgram = rewardProgram;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public Boolean getEnableProgramIndicator() {
		return enableProgramIndicator;
	}

	public void setEnableProgramIndicator(Boolean enableProgramIndicator) {
		this.enableProgramIndicator = enableProgramIndicator;
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