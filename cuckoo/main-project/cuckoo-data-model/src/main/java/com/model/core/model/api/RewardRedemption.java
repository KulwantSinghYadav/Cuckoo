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
@Table(name = "reward_redemption")
public class RewardRedemption {

	@Id
	@Column(name = "trans_id", nullable = false, insertable = true, updatable = true, columnDefinition = "int default 0")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int transId;

	@Column(name = "transaction_reference_number", insertable = true, updatable = true, columnDefinition = "int default 0")
	int transactionReferenceNumber;
	
	@Column(name = "transaction_amount", insertable = true, updatable = true, columnDefinition = "int default 0")
	int transactionAmount;
	
	@Column(name = "pointsTo_redeem", insertable = true, updatable = true, columnDefinition = "int default 0")
	int pointsToRedeem;

	@Column(name = "merchant_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String merchantCode;
	
	@Column(name = "cloaked_credit_cardNumber", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String cloakedCreditCardNumber;
	
	@Column(name = "bank_name", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String bankName;
	
	@Column(name = "reward_link_code", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String rewardLinkCode;
	
	@Column(name = "transaction_description", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String transactionDescription;
	
	@Column(name = "reward_program", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String rewardProgram;
	
	@Column(name = "status", insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String status;
	
	@Column(name = "order_id", insertable = true, updatable = true, columnDefinition = "bigint default 0")
	long orderId;
	
	@Column(name = "available_point_balance", insertable = true, updatable = true, columnDefinition = "bigint default 0")
	long availablePointBalance;

	@Column(name = "creation_time", nullable = false, insertable = true, updatable = true, columnDefinition = "timestamp default now()")
	Timestamp creationTime;

	public RewardRedemption() {
		super();
	}

	public RewardRedemption(int transId, int transactionReferenceNumber, int transactionAmount, int pointsToRedeem,
			String merchantCode, String cloakedCreditCardNumber, String bankName, String rewardLinkCode,
			String transactionDescription, String rewardProgram, String status, long orderId,
			long availablePointBalance, Timestamp creationTime) {
		super();
		this.transId = transId;
		this.transactionReferenceNumber = transactionReferenceNumber;
		this.transactionAmount = transactionAmount;
		this.pointsToRedeem = pointsToRedeem;
		this.merchantCode = merchantCode;
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
		this.bankName = bankName;
		this.rewardLinkCode = rewardLinkCode;
		this.transactionDescription = transactionDescription;
		this.rewardProgram = rewardProgram;
		this.status = status;
		this.orderId = orderId;
		this.availablePointBalance = availablePointBalance;
		this.creationTime = creationTime;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getTransactionReferenceNumber() {
		return transactionReferenceNumber;
	}

	public void setTransactionReferenceNumber(int transactionReferenceNumber) {
		this.transactionReferenceNumber = transactionReferenceNumber;
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

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
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
