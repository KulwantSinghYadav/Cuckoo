package io.city.core.api.configuration;

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
	String ELIGIBILITYENDPOINT = "city.eligibility.url.endpoint";
	String ENABLEMENTENDPOINT = "city.enablement.url.endpoint";
	String LINKAGEENDPOINT = "city.linkage.url.endpoint";
	String REDEMPTIONENDPOINT = "city.redemption.url.endpoint";
	String CITYREWARDELIGIBILITYPATH = "city.reward.eligibility.path";
	
	//Authrirization Properties.
	String AUTHAUTHORIZATION = "auth.authorization";
	String AUTHCONTENTTYPE = "auth.content-type";
	String AUTHURL = "auth.url";
	String AUTHMEDIATYPE = "auth.media.type";
	String AUTHSCOPE = "auth.scope";

}
