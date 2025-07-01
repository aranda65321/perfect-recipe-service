package com.co.perfectrecipe.manager.infrastructure.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientsConfig {
    @Autowired
    private Environment environment;

    @Bean
    @Qualifier("chatGptClient")
    public WebClient getChatGptClient() {
        return WebClient.builder()
                .baseUrl(this.environment.getRequiredProperty("services.chat-gpt.host"))
                .defaultHeader(HttpHeaders.AUTHORIZATION, this.environment.getRequiredProperty("services.chat-gpt.key-secret"))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
