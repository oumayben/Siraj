package com.socialmedia.app;

import org.springframework.boot.SpringApplication;
import  com.socialmedia.app.config.FileStorageConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(FileStorageConfig.class)
public class SocialMediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaApplication.class, args);
    }

}
