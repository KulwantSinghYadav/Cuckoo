package io.city.core.app;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.city.core.api.client.reward.balance.CallCitiRewardBalance;
import io.city.core.api.client.reward.eligibility.CallCitiRewardEligibility;
import io.city.core.api.client.reward.enablement.CallCitiRewardEnablement;
import io.city.core.api.client.reward.linkage.CallCitiRewardLinkage;
import io.city.core.api.client.reward.redemption.CallCitiRewardRedemption;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "io.city.core", "com.model.core", "com.cuckoo.config" })
public class CityApplication implements ApplicationRunner {

	/*
	 * ApplicationRunner is used when you want to execute some piece of code exactly
	 * before the application startup completes, you can use it then. In one of our
	 * projects, we used these to source data from other microservices via service
	 * discovery.
	 */

	public static void main(String[] args) {
		SpringApplication.run(CityApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println();
		CallCitiRewardLinkage callCitiRewardLinkage = new CallCitiRewardLinkage();
		String authToken = "";
		callCitiRewardLinkage.callCityRewardLinkage(authToken);

		System.out.println();
		CallCitiRewardBalance callCitiRewardBalance = new CallCitiRewardBalance();
		callCitiRewardBalance.callCityReward(authToken);

		System.out.println();
		CallCitiRewardEligibility callCitiRewardEligibility = new CallCitiRewardEligibility();
		callCitiRewardEligibility.callCityRewardEligibility(authToken);

		System.out.println();
		CallCitiRewardEnablement callCitiRewardEnablement = new CallCitiRewardEnablement();
		callCitiRewardEnablement.callCityRewardEnablement(authToken);

		/*
		 * System.out.println(); CallAuthorization authorizationToken = new
		 * CallAuthorization(); authorizationToken.callAuthorization();
		 */

		System.out.println();
		CallCitiRewardRedemption callCitiRewardRedemption = new CallCitiRewardRedemption();
		callCitiRewardRedemption.callCityRewardRedemption(authToken);

	}
}