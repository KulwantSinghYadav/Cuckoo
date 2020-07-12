package com.cuckoo.core.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com")
public class CuckooMainAppApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CuckooMainAppApplication.class, args);
	
//		CallPayWithRewardsClient callPayWithRewardsClient = new CallPayWithRewardsClient();
//		callPayWithRewardsClient.callPayWithRewardsClient();
	}

}
