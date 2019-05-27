package com.genpact.smssender.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.smssender.controller.SmsSenderController;

@SpringBootApplication
@ComponentScan(basePackageClasses = SmsSenderController.class)
public class SmsServiceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SmsServiceApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SmsServiceApplication.class);
	}
	
//	@RequestMapping(value="/test")
//	public String demo() {
//		return "Working !!";
//	}

}
