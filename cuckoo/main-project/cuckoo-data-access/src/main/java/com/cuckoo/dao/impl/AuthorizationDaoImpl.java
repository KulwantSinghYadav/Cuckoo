package com.cuckoo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.model.Authorization;

@Repository
@Component("authorizationDao")
public class AuthorizationDaoImpl  extends DaoImpl<Integer , Authorization>  implements AuthorizationDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void saveRequestDetail(String authUrl, String encodedAuth, String status, String clientCredentials) {
//		Authorization authorization = new Authorization();
//    	authorization.setAuthUrl(authUrl);
//    	authorization.setAuthorizationBase(encodedAuth);
//    	authorization.setStatus(status);
//    	authorization.setGrantType(clientCredentials);
//    	
//    	persist(authorization);
//    	
//    	System.out.println("In AuthorizationDaoImpl");
	}

	@Override
	public String getAuthorizationToken() {
		
		return "";
	}

	@Override
	public Authorization getTopRecord() {
		Authorization authorization = new Authorization();
		try {
			String hqlQuery = "from Authorization auth order by auth.transId desc";
			authorization = (Authorization) entityManager.createQuery(hqlQuery).setMaxResults(1).getSingleResult();
			entityManager.close();
		}catch (Exception e) {
			System.out.println("Error occurred during fetching Authorization record"+e);
		}	
		
		return authorization;
	}
	
	
 
}
