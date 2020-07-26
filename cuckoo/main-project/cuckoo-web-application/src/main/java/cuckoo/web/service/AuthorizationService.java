package cuckoo.web.service;

import java.sql.Timestamp;
import java.util.Map;

import javax.transaction.Transactional;

import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.config.client.auth.CallAuthorization;
import com.cuckoo.config.datetime.utill.DateTimeUtill;
import com.cuckoo.dao.impl.AuthorizationDao;
import com.model.core.model.Authorization;

@Service("authorizationService")
public class AuthorizationService {

	@Autowired
	AuthorizationDao authorizationDao;

	CallAuthorization callAuthorization = new CallAuthorization();
	
	/*
	 * This function is used to save the authorization request into the database if the token gets expired,
	 * otherwise it will fetch the latest authorization token from the database. 
	 */
	@Transactional
	public String getAuthorizationToken() {
		String authToken = null;

		try {
			Integer recordCount = authorizationDao.countAll();
			Authorization extstinRecord = authorizationDao.getTopRecord();
			Timestamp currentTime = DateTimeUtill.getCurrentSqlTimeStamp("CET");

			if (recordCount == 0 || currentTime.compareTo(extstinRecord.getExpiresTime())==1) {
				
				Map<String, String> authReqRes = callAuthorization.callAuthorization();
				Timestamp expiresTime = DateTimeUtill.getAuthExpireTime("CET",authReqRes.get("expires_in"),currentTime);
				
				Authorization authorization = new Authorization();
				
				authToken = authReqRes.get("authorisation");

				authorization.setAccessToken(authReqRes.get("access_token"));
				authorization.setEncodedAuth(authReqRes.get("encoded_auth"));
				authorization.setAuthUrl(authReqRes.get("authUrl"));
				authorization.setCreationTime(currentTime);
				authorization.setExpiresIn(Integer.valueOf(authReqRes.get("expires_in")));
				authorization.setExpiresTime(expiresTime);
				authorization.setGrantType(authReqRes.get("client_credentials"));
				authorization.setScope(authReqRes.get("scope"));
				authorization.setTokenType(authReqRes.get("access_token"));
				authorization.setConsentedOn(Integer.valueOf(authReqRes.get("consented_on")));
				authorization.setAuthorisation(authReqRes.get("authorisation"));
				
				authorizationDao.persist(authorization);
				return authToken;
			}else {
				return extstinRecord.getAuthorisation();
			}


		} catch (Exception e) {
		}

		if (!StringUtil.isBlank(authToken)) {
			return authToken;
		} else {
			return "something went wrong to get the authorization token";
		}
	}

}
