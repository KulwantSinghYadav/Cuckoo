package com.model.core.model.api;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to RewardEnablement table in database
 */
@Entity
@Table(name = "reward_enablement")
public class RewardEnablement {

	@Id
	@Column(name = "trans_id", nullable = false, insertable = true, updatable = true, columnDefinition = "int default 0")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int transId;

	@Column(name = "merchant_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String merchantCode;
	
	@Column(name = "cloaked_credit_cardNumber", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String cloakedCreditCardNumber;
	
	@Column(name = "bank_name", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String bankName;
	
	@Column(name = "reward_link_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String rewardLinkCode;
	
	@Column(name = "enable_program_indicator", insertable = true, updatable = true)
	Boolean enableProgramIndicator;
	
	@Column(name = "reward_program", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String rewardProgram;

	@Column(name = "status", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String status;
	
	@Column(name = "creation_time", nullable = false, insertable = true, updatable = true, columnDefinition = "timestamp default now()")
	Timestamp creationTime;

	public RewardEnablement() {
		super();
	}

	public RewardEnablement(int transId, String merchantCode, String cloakedCreditCardNumber, String bankName,
			String rewardLinkCode, Boolean enableProgramIndicator, String rewardProgram, String status,
			Timestamp creationTime) {
		super();
		this.transId = transId;
		this.merchantCode = merchantCode;
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
		this.bankName = bankName;
		this.rewardLinkCode = rewardLinkCode;
		this.enableProgramIndicator = enableProgramIndicator;
		this.rewardProgram = rewardProgram;
		this.status = status;
		this.creationTime = creationTime;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
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

	public String getRewardLinkCode() {
		return rewardLinkCode;
	}

	public void setRewardLinkCode(String rewardLinkCode) {
		this.rewardLinkCode = rewardLinkCode;
	}

	public Boolean getEnableProgramIndicator() {
		return enableProgramIndicator;
	}

	public void setEnableProgramIndicator(Boolean enableProgramIndicator) {
		this.enableProgramIndicator = enableProgramIndicator;
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
