package com.cuckoo.core.constant;

import okhttp3.MediaType;

public class ApplicationConstant {
	
	public static final String payWithRewardsSample = "{\r\n" + 
			"  \"account_key\": {\r\n" + 
			"    \"card_number\": \"379620156962001\"\r\n" + 
			"  },\r\n" + 
			"  \"amount\": {\r\n" + 
			"    \"value\": \"10\",\r\n" + 
			"    \"currency_code\": \"USD\"\r\n" + 
			"  }\r\n" + 
			"}";
	
	public static final String Get_Citi_Reward_Enablement_Body = "{\r\n" + 
			"    \"type\": \"object\",\r\n" + 
			"    \"required\": [\r\n" + 
			"        \"rewardProgram\",\r\n" + 
			"        \"merchantCode\",\r\n" + 
			"        \"enableProgramIndicator\"\r\n" + 
			"    ],\r\n" + 
			"    \"properties\": {\r\n" + 
			"        \"rewardProgram\": {\r\n" + 
			"            \"type\": \"string\",\r\n" + 
			"            \"description\": \"The name of the rewards program (Example: THANKU)\",\r\n" + 
			"            \"example\": \"THANKU\"\r\n" + 
			"        },\r\n" + 
			"        \"merchantCode\": {\r\n" + 
			"            \"type\": \"string\",\r\n" + 
			"            \"description\": \"Merchant code\",\r\n" + 
			"            \"example\": \"FLOWR\"\r\n" + 
			"        },\r\n" + 
			"        \"enableProgramIndicator\": {\r\n" + 
			"            \"type\": \"boolean\",\r\n" + 
			"            \"description\": \"Set to 'false' to disable (opt out of) a rewards program.  Set to 'true' to enable (opt in to) a rewards program\",\r\n" + 
			"            \"example\": \"true\"\r\n" + 
			"        },\r\n" + 
			"        \"cloakedCreditCardNumber\": {\r\n" + 
			"            \"type\": \"string\",\r\n" + 
			"            \"description\": \"hashed credit card (SHA512). Either cloakedCreditCardNumber or linkCode MUST be in the request.\",\r\n" + 
			"            \"example\": \"c88b3dbf7f7546c90523fe046ae5aa8639fb2dab2d8e5f4c3cc9351f99ef963086bf854bcaa6924a524a18a6c90817fc21b192c3694180a0a99ae8c1f5e68da0\"\r\n" + 
			"        },\r\n" + 
			"        \"rewardLinkCode\": {\r\n" + 
			"            \"type\": \"string\",\r\n" + 
			"            \"description\": \"A unique link Code that, when available, should be sent in this request in place of the cloakedCreditCardNumber.  Either cloakedCreditCardNumber or linkCode MUST be in the request.\",\r\n" + 
			"            \"example\": \"ccfb2653-3737-4261-8c83-6fdcce6b1892\"\r\n" + 
			"        }\r\n" + 
			"    },\r\n" + 
			"    \"additionalProperties\": true\r\n" + 
			"}";

	public static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

}
