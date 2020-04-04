package com.app.servicebroker;

import org.springframework.cloud.servicebroker.model.BrokerApiVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GabrielApiVersionConfiguration {
	@Bean
	public BrokerApiVersion brokerApiVersion() {
		return new BrokerApiVersion("2.13");
	}
}
