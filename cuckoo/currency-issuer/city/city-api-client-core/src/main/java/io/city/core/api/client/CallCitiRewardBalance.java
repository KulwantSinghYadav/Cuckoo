package io.city.core.api.client;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class CallCitiRewardBalance implements ApplicationRunner {
	
	CitiRewardBalanceConfiguration balanceConfiguration = new CitiRewardBalanceConfiguration();
	
	public  String callCityReward() throws IOException {
		
		Map<String,String> congigValues = balanceConfiguration.getPropValues();
		
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(congigValues.get("cityRewardUrl"))
				.get().addHeader("client_id", congigValues.get("clientId"))
				.addHeader("uuid",congigValues.get("uuid") ).addHeader("content-type", congigValues.get("contentType"))
				.addHeader("countrycode", congigValues.get("countryCode")).addHeader("businesscode", congigValues.get("businessCode"))
				.addHeader("authorization", congigValues.get("authorization"))
				.addHeader("accept-language", congigValues.get("acceptLanguage")).addHeader("accept", congigValues.get("accept")).build();

		Response response = client.newCall(request).execute();
		System.out.println("Response " + response.body().string());
		return response.body().toString();
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		CallCitiRewardBalance callCitiRewardBalance = new CallCitiRewardBalance();
		callCitiRewardBalance.callCityReward();
	}

}