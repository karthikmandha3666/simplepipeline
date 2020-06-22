package com.karthik.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.ramana"})
public class PivotalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PivotalApplication.class, args);
	}

}
