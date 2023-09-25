package com.majella.ordermanagerbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderManagerBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagerBffApplication.class, args);
	}

}
