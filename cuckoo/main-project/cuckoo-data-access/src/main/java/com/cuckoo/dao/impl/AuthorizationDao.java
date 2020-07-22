package com.cuckoo.dao.impl;

import com.cuckoo.dao.generic.Dao;
import com.model.core.model.Authorization;

public interface AuthorizationDao  extends Dao<Integer , Authorization> {
	
	public void saveRequestDetail(String authUrl, String encodedAuth, String status, String clientCredentials);
	public String getAuthorizationToken();

}
