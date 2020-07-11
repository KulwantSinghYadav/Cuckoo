package io.aexp.api.client.core.callapi;

import java.io.IOException;

import io.aexp.api.client.core.pay.reward.PayWithRewardsClient;

public class CallSendBoxApi {
	
	public static final String payWithRewards = "{\r\n" + 
			"  \"account_key\": {\r\n" + 
			"    \"card_number\": \"379620156962001\"\r\n" + 
			"  },\r\n" + 
			"  \"amount\": {\r\n" + 
			"    \"value\": \"10\",\r\n" + 
			"    \"currency_code\": \"USD\"\r\n" + 
			"  }\r\n" + 
			"}";

	public static void main(String[] args) throws IOException {
		PayWithRewardsClient payWithRewardsClient = new PayWithRewardsClient();

		payWithRewardsClient.searchRewards(payWithRewards);
		
		System.out.println("PayWithRewards " + payWithRewards);
	}

}
