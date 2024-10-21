package hu.foxpost.parcel_handler.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "openapi")
@Getter
@Setter
public class OpenApiProperties {

    private String title;
    private String version;
    private String description;
    private String contactName;
    private String contactEmail;
    private String contactUrl;
    private String serverLocalUrl;
    private String serverLocalName;

    @Override
    public String toString() {
        return "OpenApiProperties{" +
                "title='" + title + '\'' +
                ", version='" + version + '\'' +
                ", description='" + description + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactUrl='" + contactUrl + '\'' +
                ", serverLocalUrl='" + serverLocalUrl + '\'' +
                ", serverLocalName='" + serverLocalName + '\'' +
                '}';
    }

}
