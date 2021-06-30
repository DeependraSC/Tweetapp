package com.tweetApp.FSE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TwitterApplication {
	 private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TwitterApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
		log.info("App Started...");
		
	}

}
