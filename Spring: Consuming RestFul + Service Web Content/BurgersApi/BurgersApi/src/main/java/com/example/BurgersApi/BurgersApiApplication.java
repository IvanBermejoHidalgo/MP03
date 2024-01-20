package com.example.BurgersApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BurgersApiApplication {
	private static final Logger log = LoggerFactory.getLogger(BurgersApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BurgersApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
				.defaultHeader("X-RapidAPI-Key","fea48c39c2msh8e5a8e39b930763p10f27djsn9893056b7af5")
				.build();
	}
}
