package hu.foxpost.parcel_handler;

import hu.foxpost.parcel_handler.properties.DataSourceProperties;
import hu.foxpost.parcel_handler.properties.OpenApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ DataSourceProperties.class, OpenApiProperties.class })
public class ParcelHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcelHandlerApplication.class, args);
	}

}
