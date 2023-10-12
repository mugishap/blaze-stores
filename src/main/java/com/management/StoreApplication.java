package com.management;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "Auth", description = "Authentication operations."),
                @Tag(name = "Users", description = "User operations."),
                @Tag(name = "Products", description = "Product operations."),
        },
        info = @Info(
                title = "Blaze Stores API",
                version = "1.0.1",
                contact = @Contact(
                        name = "Mugisha Precieux",
                        url = "https://mugishap.pro",
                        email = "precieuxmugisha@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html")),
        components = @Components(
                securitySchemes = {
                        @SecurityScheme(
                                securitySchemeName = "jwt",
                                description = "JWT Bearer Token",
                                type = SecuritySchemeType.HTTP,
                                scheme = "bearer",
                                bearerFormat = "jwt"
                        )
                }
        )
)
public class StoreApplication extends Application {
}
