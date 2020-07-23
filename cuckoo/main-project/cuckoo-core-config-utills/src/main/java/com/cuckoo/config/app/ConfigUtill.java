package com.cuckoo.config.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.cuckoo.dao", "com.cuckoo.config" })
public class ConfigUtill {
    public static void main(String[] args) {
        SpringApplication.run(ConfigUtill.class, args);
    }
}