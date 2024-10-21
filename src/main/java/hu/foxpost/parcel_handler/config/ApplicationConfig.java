package hu.foxpost.parcel_handler.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        DataSourceConfig.class,
        JsonMapperConfig.class,
        OpenApiConfig.class,
})
public class ApplicationConfig {
}
