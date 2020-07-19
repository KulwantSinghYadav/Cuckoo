package com.cuckoo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.city.model.Authorization;

@Component("authorizationDao")
public class AuthorizationDaoImpl  extends DaoImpl<Integer , Authorization>  implements AuthorizationDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public String saveAuthorizationToken() {
		return null;
	}
	
	
 
}
