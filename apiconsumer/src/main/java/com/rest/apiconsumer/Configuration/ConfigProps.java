package com.rest.apiconsumer.Configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "webapi")
@Data
public class ConfigProps {
    private String baseurl;

}
