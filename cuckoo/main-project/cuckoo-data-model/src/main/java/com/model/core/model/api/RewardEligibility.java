package com.model.core.model.api;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to RewardEligibility table in database
 */
@Entity
@Table(name = "reward_eligibility")
public class RewardEligibility {

	@Id
	@Column(name = "trans_id", nullable = false, insertable = true, updatable = true, columnDefinition = "int default 0")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer transId;

	@Column(name = "merchant_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String merchantCode;
	
	@Column(name = "cloaked_credit_cardNumber", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String cloakedCreditCardNumber;
	
	@Column(name = "bank_name", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String bankName;
	
	@Column(name = "eligibility_indicator", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String eligibilityIndicator;
	
	@Column(name = "reward_program", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String rewardProgram;
	
	@Column(name = "status", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String status;

	@Column(name = "creation_time", nullable = false, insertable = true, updatable = true, columnDefinition = "timestamp default now()")
	Timestamp creationTime;

	public RewardEligibility() {
		super();
	}

	public RewardEligibility(Integer transId, String merchantCode, String cloakedCreditCardNumber, String bankName,
			String eligibilityIndicator, String rewardProgram, String status,
			Timestamp creationTime) {
		super();
		this.transId = transId;
		this.merchantCode = merchantCode;
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
		this.bankName = bankName;
		this.eligibilityIndicator = eligibilityIndicator;
		this.rewardProgram = rewardProgram;
		this.status = status;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getEligibilityIndicator() {
		return eligibilityIndicator;
	}

	public void setEligibilityIndicator(String eligibilityIndicator) {
		this.eligibilityIndicator = eligibilityIndicator;
	}

	public String getRewardProgram() {
		return rewardProgram;
	}

	public void setRewardProgram(String rewardProgram) {
		this.rewardProgram = rewardProgram;
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

}

