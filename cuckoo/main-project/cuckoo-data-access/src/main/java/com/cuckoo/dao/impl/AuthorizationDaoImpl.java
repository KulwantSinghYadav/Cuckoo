package com.cuckoo.dao.impl;

import org.springframework.stereotype.Component;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.city.model.Authorization;

@Component("authorizationDao")
public class AuthorizationDaoImpl  extends DaoImpl<Integer , Authorization>  implements AuthorizationDao{
 
}
