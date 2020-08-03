package com.model.core.model.api;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to RewardLinkage table in database
 */
@Entity
@Table(name = "reward_linkage")
public class RewardLinkage {
	
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
	
	@Column(name = "reward_program", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String rewardProgram;

	@Column(name = "billing_zip_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String billingZipCode;
	
	@Column(name = "bank_name", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String bankName;
	
	@Column(name = "status", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String status;

	@Column(name = "creation_time", insertable = true, updatable = true, columnDefinition = "timestamp default now()")
	Timestamp creationTime;

	public RewardLinkage() {
		super();
	}

	public RewardLinkage(Integer transId, String merchantCode, String cloakedCreditCardNumber, String rewardLinkCode,
			String billingZipCode, String bankName, String status, Timestamp creationTime) {
		super();
		this.transId = transId;
		this.merchantCode = merchantCode;
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
		this.rewardLinkCode = rewardLinkCode;
		this.billingZipCode = billingZipCode;
		this.bankName = bankName;
		this.status = status;
		this.creationTime = creationTime;
	}

	public RewardLinkage(String cloakedCreditCardNumbers, String merchantCode2, String rewardProgram,
			String billingZipCode2) {
		this.cloakedCreditCardNumber = cloakedCreditCardNumbers;
		this.merchantCode = merchantCode2;
		this.rewardProgram = rewardProgram;
		this.billingZipCode = billingZipCode2;
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
	
}

