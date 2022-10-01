package com.ayi.curso.rest.serv.ayispringrestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EntityScan(basePackages = { "com.ayi.curso.rest.serv.ayispringrestful.entity"})
@EnableJpaRepositories( basePackages = {"com.ayi.curso.rest.serv.ayispringrestful.repository"})
@SpringBootApplication
public class AyiSpringRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(AyiSpringRestfulApplication.class, args);
	}

}
