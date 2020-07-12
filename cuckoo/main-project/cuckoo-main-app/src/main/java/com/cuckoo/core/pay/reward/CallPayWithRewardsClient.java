package com.cuckoo.core.pay.reward;

import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cuckoo.core.constant.ApplicationConstant;

import io.aexp.api.client.core.pay.reward.PayWithRewardsClient;

@Component
public class CallPayWithRewardsClient implements ApplicationRunner {

	PayWithRewardsClient payWithRewardsClient = new PayWithRewardsClient();

	public void  callPayWithRewardsClient(){
		String payWithRewards;
		try
		{
			 payWithRewards = payWithRewardsClient.searchRewards(ApplicationConstant.payWithRewardsSample);
			 System.out.println("Pay With Rewards " + payWithRewards);
		}catch(IOException ioException)
		{

		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		CallPayWithRewardsClient callPayWithRewardsClient = new CallPayWithRewardsClient();
		callPayWithRewardsClient.callPayWithRewardsClient();
	}
	
}