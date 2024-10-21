package hu.foxpost.parcel_handler.config;

import hu.foxpost.parcel_handler.properties.OpenApiProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {

        @Autowired
        OpenApiProperties openApiProperties;

        @Bean
        public OpenAPI openAPI() {
            return new OpenAPI()
                        .info(new Info()
                                .title(openApiProperties.getTitle())
                                .version(openApiProperties.getVersion())
                                .description(openApiProperties.getDescription())
                                .contact(new Contact()
                                        .name(openApiProperties.getContactName())
                                        .email(openApiProperties.getContactEmail())
                                        .url(openApiProperties.getContactUrl())))
                        .addServersItem(new Server()
                                .url(openApiProperties.getServerLocalUrl())
                                .description(openApiProperties.getServerLocalName()));
        }

}
