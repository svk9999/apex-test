package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class ApplicationConfig {
	@Value("${mockapi.url}")
	String mockApiUri;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();	
	}
	
	@Bean
	public UriComponents mockApiUriTemplate() {
		return UriComponentsBuilder.fromUriString(mockApiUri)
				.encode()
				.build();
	}
	
	
}
