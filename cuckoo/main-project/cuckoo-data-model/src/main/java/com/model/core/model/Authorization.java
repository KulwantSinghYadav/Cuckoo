package com.model.core.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Authorization table in database
 */
@Entity
@Table(name = "authorization_token")
public class Authorization {

	@Id
	@Column(name = "trans_id", nullable = false, insertable = true, updatable = true, columnDefinition = "int default 0")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int transId;

	@Column(name = "auth_url", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String authUrl;
	
	@Column(name = "authorization_base", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String authorizationBase;
	
	@Column(name = "grant_type", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String grantType;
	
	@Column(name = "access_token", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String accessToken;

	@Column(name = "refresh_token", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String refreshToken;

	@Column(name = "scope", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String scope;

	@Column(name = "token_type", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String tokenType;
	
	@Column(name = "status", nullable = false, insertable = true, updatable = true, columnDefinition = "varchar default ''")
	String status;

	@Column(name = "expires_in", nullable = false, insertable = true, updatable = true, columnDefinition = "int default 0")
	String expiresIn;

	@Column(name = "creation_time", nullable = false, insertable = true, updatable = true, columnDefinition = "timestamp default now()")
	Timestamp creationTime;
	
	@Column(name = "expires_time", nullable = false, insertable = true, updatable = true, columnDefinition = "timestamp default now()")
	Timestamp expiresTime;

	public Authorization() {
		super();
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public String getAuthorizationBase() {
		return authorizationBase;
	}

	public void setAuthorizationBase(String authorizationBase) {
		this.authorizationBase = authorizationBase;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getExpiresTime() {
		return expiresTime;
	}

	public void setExpiresTime(Timestamp expiresTime) {
		this.expiresTime = expiresTime;
	}
	
}
