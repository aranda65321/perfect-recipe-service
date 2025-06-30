package com.co.perfectrecipe.manager.infrastructure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.co.perfectrecipe.manager"
})
@EntityScan(basePackages = {
        "com.co.perfectrecipe.manager"
})
@EnableJpaRepositories(basePackages = {
        "com.co.perfectrecipe.manager"
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
