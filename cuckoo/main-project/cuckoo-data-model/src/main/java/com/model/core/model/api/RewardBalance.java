package com.model.core.model.api;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to RewardBalance table in database
 */
@Entity
@Table(name = "reward_balance")
public class RewardBalance {

	@Id
	@Column(name = "trans_id", nullable = false, insertable = true, updatable = true, columnDefinition = "int default 0")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer transId;
	
	@Column(name = "merchant_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String merchantCode;
	
	@Column(name = "cloaked_credit_cardNumber", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String cloakedCreditCardNumber;
	
	@Column(name = "reward_link_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String rewardLinkCode;

	@Column(name = "billing_zip_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String billingZipCode;
	
	@Column(name = "bank_name", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String bankName;
	
	@Column(name = "reward_program", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String rewardProgram;
	
	@Column(name = "status", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String status;
	
	@Column(name = "is_redemption_eligible", insertable = true, updatable = true)
	Boolean isRedemptionEligible;
	
	@Column(name = "available_point_balance", insertable = true, updatable = true, columnDefinition = "int default 0")
	int availablePointBalance;
	
	@Column(name = "program_conversion_rate", insertable = true, updatable = true, columnDefinition = "float default 0")
	Double programConversionRate;
	
	@Column(name = "local_currency_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String localCurrencyCode;
	
	@Column(name = "redemption_point_increment", insertable = true, updatable = true, columnDefinition = "int default 0")
	int redemptionPointIncrement;
	
	@Column(name = "maximum_points_to_redeem", insertable = true, updatable = true, columnDefinition = "int default 0")
	int maximumPointsToRedeem;
	
	@Column(name = "minimum_points_to_redeem", insertable = true, updatable = true, columnDefinition = "int default 0")
	int minimumPointsToRedeem;
	
	@Column(name = "creation_time", insertable = true, updatable = true, columnDefinition = "timestamp default now()")
	Timestamp creationTime;

	public RewardBalance() {
		super();
	}
	
	public RewardBalance(int transId, String merchantCode, String cloakedCreditCardNumber, String rewardLinkCode,
			String billingZipCode, String bankName, String rewardProgram, String status, Boolean isRedemptionEligible,
			int availablePointBalance, Double programConversionRate, String localCurrencyCode,
			int redemptionPointIncrement, int maximumPointsToRedeem, int minimumPointsToRedeem,
			Timestamp creationTime) {
		super();
		this.transId = transId;
		this.merchantCode = merchantCode;
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
		this.rewardLinkCode = rewardLinkCode;
		this.billingZipCode = billingZipCode;
		this.bankName = bankName;
		this.rewardProgram = rewardProgram;
		this.status = status;
		this.isRedemptionEligible = isRedemptionEligible;
		this.availablePointBalance = availablePointBalance;
		this.programConversionRate = programConversionRate;
		this.localCurrencyCode = localCurrencyCode;
		this.redemptionPointIncrement = redemptionPointIncrement;
		this.maximumPointsToRedeem = maximumPointsToRedeem;
		this.minimumPointsToRedeem = minimumPointsToRedeem;
		this.creationTime = creationTime;
	}



	public Integer getTransId() {
		return transId;
	}

	public void setTransId(Integer transId) {
		this.transId = transId;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
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

	public String getBillingZipCode() {
		return billingZipCode;
	}

	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public String getRewardProgram() {
		return rewardProgram;
	}

	public void setRewardProgram(String rewardProgram) {
		this.rewardProgram = rewardProgram;
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

	public Double getProgramConversionRate() {
		return programConversionRate;
	}

	public void setProgramConversionRate(Double programConversionRate) {
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
	
}
