package com.example.services.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Pornput",
                        email = "pornput@mail.com",
                        url = "https://localhost.com"
                ),
                description = "OpenApi Documentation for Spring boot",
                title = "OpenApi specification - Pornput",
                version = "1.0",
                license = @License(
                        name = "License name",
                        url = "http://some-url.com"
                ),
                termsOfService =  "Term of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url ="http://localhost:8080"
                ),
                @Server(
                        description = "Prod ENV",
                        url ="http://localhost:3000"
                )
        }
)
public class OpenApiConfing {
}
