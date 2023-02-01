package com.seresco.multitenant.infrastructure.config.yaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ConfigurationProperties
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class YAMLConfig {

    @Autowired
    private Environment env;

    public String getProperty(String key) {
        return env.getProperty(key);
    }

}
