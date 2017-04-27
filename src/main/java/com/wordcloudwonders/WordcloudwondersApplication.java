package com.wordcloudwonders;

import com.wordcloudwonders.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class WordcloudwondersApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordcloudwondersApplication.class, args);
    }
}
