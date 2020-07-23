package cuckoo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = { "cuckoo.web", "cuckoo.web.controller", "com.cuckoo.dao.impl", "com.cuckoo.config" })
@EntityScan("com.model.core.model")
@EnableJpaRepositories("cuckoo.web.service")
@EnableTransactionManagement
@EnableSpringConfigured
@Import({ WebConfig.class, DatabaseConfiguration.class })
public class CuckoWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CuckoWebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CuckoWebApplication.class, args);
	}

}