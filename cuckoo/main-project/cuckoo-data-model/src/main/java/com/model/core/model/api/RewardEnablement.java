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

	@Column(name = "request_url", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String requestUrl;
	
	@Column(name = "api_name", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String apiName;

	@Column(name = "response_data", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String responseData;

	@Column(name = "creation_time", nullable = false, insertable = true, updatable = true, columnDefinition = "timestamp default now()")
	Timestamp creationTime;

	public RewardEnablement() {
		super();
	}

	public RewardEnablement(int id, String requestUrl, String apiName, String responseData, Timestamp creationTime) {
		super();
		this.transId = id;
		this.requestUrl = requestUrl;
		this.responseData = responseData;
		this.creationTime = creationTime;
		this.apiName = apiName;
	}

	public int getId() {
		return transId;
	}

	public void setId(int id) {
		this.transId = id;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp timestamp) {
		this.creationTime = timestamp;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	
}
