package com.cuckoo.config.api.ReqRes.model;

public class RewardLinkageRequestBody {
	
	String cloakedCreditCardNumbers;
	String merchantCode;
	String rewardProgram;
	String billingZipCode;
	
	public RewardLinkageRequestBody(String cloakedCreditCardNumbers, String merchantCode, String rewardProgram,
			String billingZipCode) {
		super();
		this.cloakedCreditCardNumbers = cloakedCreditCardNumbers;
		this.merchantCode = merchantCode;
		this.rewardProgram = rewardProgram;
		this.billingZipCode = billingZipCode;
	}
	
	public RewardLinkageRequestBody() {
	}

	public String getCloakedCreditCardNumbers() {
		return cloakedCreditCardNumbers;
	}
	public void setCloakedCreditCardNumbers(String cloakedCreditCardNumbers) {
		this.cloakedCreditCardNumbers = cloakedCreditCardNumbers;
	}
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getRewardProgram() {
		return rewardProgram;
	}
	public void setRewardProgram(String rewardProgram) {
		this.rewardProgram = rewardProgram;
	}
	public String getBillingZipCode() {
		return billingZipCode;
	}
	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}
	
}
