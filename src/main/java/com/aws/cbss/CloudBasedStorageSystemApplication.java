package com.aws.cbss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.aws.cbss")
public class CloudBasedStorageSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudBasedStorageSystemApplication.class, args);
	}

}
