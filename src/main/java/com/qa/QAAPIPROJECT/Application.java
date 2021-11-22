package com.qa.QAAPIPROJECT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Statement;
import java.time.LocalTime;

@SpringBootApplication
@EnableJpaRepositories("com.qa.QAAPIPROJECT.repository")
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		var greet = context.getBean("hi");
		System.out.println(greet);
	}

}
