package br.com.fiap.locatech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

	@Bean
	OpenAPI locaTech() {
		return new OpenAPI()
				.info(new Info()
						.title("LocaTech API")
						.description("Projeto desenvolvido junto ao curso de Spring MVC")
						.version("1")
						.license(new License()
								.name("Apache 2.0")
								.url("https://github.com/CorreiaGui")));
	}
}
