package com.ayi.curso.rest.serv.ayispringrestful.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
@ComponentScan(basePackages={"com.ayi.test.rest.serv.app.configuration" +
        "com.ayi.test.rest.serv.app.service" +
        "com.ayi.test.rest.serv.app.mapper" +
        "com.ayi.test.rest.serv.app.repository"})
public class CommonsConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
