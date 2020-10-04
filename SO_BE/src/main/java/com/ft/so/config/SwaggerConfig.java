package com.ft.so.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ft.so.admin.controller"))
				.build()
				.apiInfo(new ApiInfo(
						"RESTful API", 
						"RESTful API cho Social Original ", 
						"", 
						"",
						new Contact  ("Social-Original", "7", "futureteam@gmail.com"), 
						"", 
						"",
						Collections.EMPTY_LIST
					));
	}
	
}
