package cuckoo.web.service;

import javax.transaction.Transactional;

import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.dao.impl.AuthorizationDao;

@Service("authorizationService")
public class AuthorizationService {

	@Autowired
	AuthorizationDao authorizationDao;

	@Transactional
	public String saveAuthorizationToken() {
		String authToken = null;

		try {
			authToken = authorizationDao.saveAuthorizationToken();
		} catch (Exception e) {
		}

		if (!StringUtil.isBlank(authToken)) {
			return authToken;
		} else {
			return "something went wrong";
		}
	}

}
