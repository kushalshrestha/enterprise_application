package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@ComponentScan
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:application.yml")
}
)
public class DemoApplication implements CommandLineRunner {

	@Autowired
	Properties properties;

	@Autowired
	YAMLProperties ymlProperties;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------Spring Boot Configuration Project Using application.properties------------");
		System.out.println("Application name : " + properties.getAppName());
		System.out.println("Application version : " + properties.getAppVersion());
		System.out.println("Server URL : " + properties.getServerUrl());
		System.out.println("Server Name : " + properties.getServerName());
		System.out.println("User First Name : " + properties.getUserFirstName());
		System.out.println("User Last Name : " + properties.getUserLastName());
		System.out.println("Password : " + properties.getPassword());
		System.out.println("LIST OF COUNTRIES : ");
		for (String country :  properties.getCountries()) {
			System.out.println(country);
		};

		System.out.println("---FROM YAML------");
		System.out.println("Application name : " + ymlProperties.getAppName());
		System.out.println("Application version : " + ymlProperties.getAppVersion());
		System.out.println("Server URL : " + ymlProperties.getServerUrl());
		System.out.println("Server Name : " + ymlProperties.getServerName());
		System.out.println("User First Name : " + ymlProperties.getUserFirstName());
		System.out.println("User Last Name : " + ymlProperties.getUserLastName());
		System.out.println("Password : " + ymlProperties.getPassword());
		System.out.println("LIST OF COUNTRIES : ");
		for (String countryYML: ymlProperties.getCountries()
			 ) {
			System.out.println(countryYML);
		}

	}
}
