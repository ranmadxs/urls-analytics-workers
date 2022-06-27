package com.esanchezd.urlsln.config.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI(@Value("${application.version}") String appVersion) {
		return new OpenAPI()
				.info(new Info().title("Urls-ln")
						.description("Microservicio para redireccionar urlshortener a url base original, tambien notifica eventos estadísticos.")
						.version(appVersion)
						.termsOfService("http://codmind.com/terms")
						.contact(new Contact().name("Admin").url("#").email("grineldosanchez@yahoo.es"))
						.license(new License().name("Esanchezd").url("www.hroku......xxxx"))
						.extensions(Collections.emptyMap())
				);
	}

	
}