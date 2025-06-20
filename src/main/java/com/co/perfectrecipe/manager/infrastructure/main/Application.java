package com.co.domainconfiguration.manager.infrastructure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.co.multimedia.manager"
})
@EntityScan(basePackages = {
        "com.co.multimedia.manager"
})
@EnableJpaRepositories(basePackages = {
        "com.co.multimedia.manager"
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(com.co.domainconfiguration.manager.infrastructure.main.Application.class, args);
    }

}
