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
			"  \"rewardProgram\": \"THANKU\",\r\n" + 
			"  \"merchantCode\": \"FLOWR\",\r\n" + 
			"  \"enableProgramIndicator\": \"true\",\r\n" + 
			"  \"cloakedCreditCardNumber\": \"c88b3dbf7f7546c90523fe046ae5aa8639fb2dab2d8e5f4c3cc9351f99ef963086bf854bcaa6924a524a18a6c90817fc21b192c3694180a0a99ae8c1f5e68da0\",\r\n" + 
			"  \"rewardLinkCode\": \"ccfb2653-3737-4261-8c83-6fdcce6b1892\"\r\n" + 
			"}";

	public static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

}
