package io.city.core.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("io")
@PropertySource(value = {"classpath:application.properties"})
public class CityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityApplication.class, args);
	}
	

}
