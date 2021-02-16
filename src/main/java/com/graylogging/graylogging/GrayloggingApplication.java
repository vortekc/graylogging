package com.graylogging.graylogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class GrayloggingApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(GrayloggingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GrayloggingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
