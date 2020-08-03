package com.model.core.constant;

import okhttp3.MediaType;

/*
 * This class is used to make constant for the entire application.
 */
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

	public static final String Get_Citi_Reward_Linkage_Body = "{\r\n" + 
			"  \"rewardProgram\": \"THANKU\",\r\n" + 
			"  \"merchantCode\": \"FLOWR\",\r\n" + 
			"  \"cloakedCreditCardNumber\": \"c88b3dbf7f7546c90523fe046ae5aa8639fb2dab2d8e5f4c3cc9351f99ef963086bf854bcaa6924a524a18a6c90817fc21b192c3694180a0a99ae8c1f5e68da0\",\r\n" + 
			"  \"billingZipCode\": \"12345\"\r\n" + 
			"}";

	public static final String Get_Citi_Reward_Redemption_Body = "{\r\n" + 
			"  \"rewardProgram\": \"THANKU\",\r\n" + 
			"  \"cloakedCreditCardNumber\": \"c88b3dbf7f7546c90523fe046ae5aa8639fb2dab2d8e5f4c3cc9351f99ef963086bf854bcaa6924a524a18a6c90817fc21b192c3694180a0a99ae8c1f5e68da0\",\r\n" + 
			"  \"rewardLinkCode\": \"998OB390B502W4G4PQIMGP8P4155378GM4SQ3ORF418134ST\",\r\n" + 
			"  \"merchantCode\": \"FLOWR\",\r\n" + 
			"  \"transactionReferenceNumber\": \"12345\",\r\n" + 
			"  \"redemptionOrder\": {\r\n" + 
			"    \"transactionAmount\": 10.5,\r\n" + 
			"    \"pointsToRedeem\": 1000,\r\n" + 
			"    \"transactionDescription\": \"Coffee\"\r\n" + 
			"  }\r\n" + 
			"}";

	public static final String Pending = "Pending";
	public static final String Completed = "Completed";
	public static final String Error = "Error";
	
	public static final String City = "City";
			
	public static final String Client_Credentials = "client_credentials";
	public static final String Cloaked_Credit_Card_Numbers = "cloakedCreditCardNumbers";
	public static final String Merchant_Code = "merchantCode";
	public static final String Reward_Program = "rewardProgram";
	public static final String Reward_Link_Code = "rewardLinkCode";
	public static final String Client_Id = "client_id";
	public static final String UUID = "uuid";
	public static final String Content_Type = "content-type";
	public static final String Country_Code = "countrycode";
	public static final String Business_Code = "businesscode";
	public static final String Authorization = "authorization";
	public static final String Accept_Language = "accept-language";
	public static final String Accept = "accept";
	public static final String Api_Product = "apiProduct";
	public static final String End_Point = "endpoint";

}
