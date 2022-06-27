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
				.info(new Info().title("urls-analytics-workers")
						.description("Microservicio que efectúa cálculos y consolidación de estadísticas analíticas de los “urlshortener.")
						.version(appVersion)
						.termsOfService("http://codmind.com/terms")
						.contact(new Contact().name("Admin").url("#").email("grineldosanchez@yahoo.es"))
						.license(new License().name("Esanchezd").url("https://urls-analytics-workers.herokuapp.com/"))
						.extensions(Collections.emptyMap())
				);
	}

	
}