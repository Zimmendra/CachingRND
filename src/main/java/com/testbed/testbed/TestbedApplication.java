package com.testbed.testbed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.testbed.testbed")
@EntityScan("com.testbed.testbed.domain")
@EnableJpaRepositories(basePackages = "com.testbed.testbed.Repository")
@EnableCaching
public class TestbedApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestbedApplication.class, args);
	}

}
