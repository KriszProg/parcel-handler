package hu.foxpost.parcel_handler.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonMapperConfig {

    @Value("${local.date.time.format}")
    private String localDateTimeFormat;

    @Bean
    public JsonMapper jsonMapper() {
        JsonMapper jsonMapper = new JsonMapper();

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule
                .addSerializer(LocalDateTime.class,
                        new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(localDateTimeFormat)))
                .addDeserializer(LocalDateTime.class,
                        new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(localDateTimeFormat)));

        jsonMapper
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(javaTimeModule);
        return jsonMapper;
    }

}
