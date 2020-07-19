package com.cuckoo.dao.impl;

import com.cuckoo.dao.generic.Dao;
import com.model.core.city.model.Authorization;

public interface AuthorizationDao  extends Dao<Integer , Authorization> {
	
	public String saveAuthorizationToken();

}
