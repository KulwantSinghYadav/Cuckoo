package com.cuckoo.core.property.config;

public interface ConfigurationKeys {

	//Header Properties
	String CLIENT_ID = "client.id";
	String CLIENT_SECRET = "client.secret";
	String UUID = "uuid";
	String CONTENT_TYPE = "content.type";
	String COUNTRY_CODE = "countrycode";
	String BUSINESS_CODE = "businesscode";
	String AUTHORIZATION = "authorization";
	String ACCEPT_LANGUAGE = "accept.language";
	String ACCEPT = "accept";
	
	//Reward Properties
	String CITY_REWARD_URL = "city.reward.url";
	String VI = "city.reward.url.v1";
	String API_PRODUCT = "city.reward.url.apiProduct";
	String ENDPOINT = "city.reward.url.endpoint";
	String CLOAKED_CREDIT_CARD_NUMBERS = "city.reward.qp.cloakedCreditCardNumber";
	String MERCHANT_CODE = "city.reward.qp.merchantCode";
	String REWARD_PROGRAM = "city.reward.qp.rewardProgram";
	String REWARD_LINK_CODE = "city.reward.qp.rewardLinkCode";
	String ELIGIBILITY_END_POINT = "city.eligibility.url.endpoint";
	String ENABLEMENT_END_POINT = "city.enablement.url.endpoint";
	String LINKAGEEND_POINT = "city.linkage.url.endpoint";
	String REDEMPTION_END_POINT = "city.redemption.url.endpoint";
	String CITY_REWARD_ELIGIBILITY_PATH = "city.reward.eligibility.path";
	
	//Authrirization Properties.
	String AUTHAUTHORIZATION = "auth.authorization";
	String AUTHCONTENT_TYPE = "auth.content-type";
	String AUTH_URL = "auth.url";
	String AUTH_MEDIA_TYPE = "auth.media.type";
	String AUTH_SCOPE = "auth.scope";

}
