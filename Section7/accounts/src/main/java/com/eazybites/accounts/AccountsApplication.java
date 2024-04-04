package com.eazybites.accounts;

import com.eazybites.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Account Service REST API Documentation",
				description = "EazyBank Accounts microservices REST API",
				version = "v1",
				contact = @Contact(
						name = "Rama Krishna Boorgadda",
						email = "ramboorgadda@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
				        url = "http://payments.com"
         		)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Account service Rest API Documentation",
				url="https://www.payments.com/swagger-ui.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
