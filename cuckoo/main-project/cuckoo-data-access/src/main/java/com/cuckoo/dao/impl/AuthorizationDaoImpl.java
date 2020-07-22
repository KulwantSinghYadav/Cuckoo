package com.cuckoo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.model.Authorization;

@Component("authorizationDao")
public class AuthorizationDaoImpl  extends DaoImpl<Integer , Authorization>  implements AuthorizationDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void saveRequestDetail(String authUrl, String encodedAuth, String status, String clientCredentials) {
		Authorization authorization = new Authorization();
    	authorization.setAuthUrl(authUrl);
    	authorization.setAuthorizationBase(encodedAuth);
    	authorization.setStatus(status);
    	authorization.setGrantType(clientCredentials);
    	entityManager.persist(authorization);
	}

	@Override
	public String getAuthorizationToken() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
 
}
