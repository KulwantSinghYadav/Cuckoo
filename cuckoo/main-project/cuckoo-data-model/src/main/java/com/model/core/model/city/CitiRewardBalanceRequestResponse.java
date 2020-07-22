package com.model.core.model.city;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to CitiRewardBalanceRequest table in database
 */
@Entity
@Table(name = "Citi_reward_balance_request_response")
public class CitiRewardBalanceRequestResponse {

	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true, columnDefinition = "int default 0")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "request_url", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String requestUrl;
	
	@Column(name = "api_name", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String apiName;

	@Column(name = "response_data", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String responseData;

	@Column(name = "creation_time", nullable = false, insertable = true, updatable = true, columnDefinition = "timestamp default now()")
	Timestamp creationTime;

	public CitiRewardBalanceRequestResponse() {
		super();
	}

	public CitiRewardBalanceRequestResponse(int id, String requestUrl, String apiName, String responseData, Timestamp creationTime) {
		super();
		this.id = id;
		this.requestUrl = requestUrl;
		this.responseData = responseData;
		this.creationTime = creationTime;
		this.apiName = apiName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
