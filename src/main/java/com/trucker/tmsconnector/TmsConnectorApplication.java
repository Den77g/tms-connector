package com.trucker.tmsconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TmsConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmsConnectorApplication.class, args);
	}

}
