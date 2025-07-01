package com.co.perfectrecipe.manager.crosscutting.clients;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatRequestDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageRequestDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.net.URI;

@Component
public class ChatGptClient {
    @Autowired
    private Environment environment;
    @Autowired
    @Qualifier("chatGptClient")
    private WebClient client;

    public ChatGptChatResponseDto generateChat(ChatGptChatRequestDto request) {
        return this.client.post()
                .uri(this.environment.getRequiredProperty("services.chat-gpt.endpoint.chat"))
                .body(Mono.just((request)), ChatGptChatRequestDto.class)
                .retrieve()
                .bodyToMono(ChatGptChatResponseDto.class)
                .block();
    }

    public ChatGptImageResponseDto generateImage(ChatGptImageRequestDto request) {
        return this.client.post()
                .uri(this.environment.getRequiredProperty("services.chat-gpt.endpoint.image"))
                .body(Mono.just((request)), ChatGptImageRequestDto.class)
                .retrieve()
                .bodyToMono(ChatGptImageResponseDto.class)
                .block();
    }

    public byte[] downloadImage(String urlImage) {
        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024)) // 10 MB
                .build();
        WebClient webClient = WebClient.builder()
                .exchangeStrategies(strategies)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create()))
                .build();
        return webClient
                .get()
                .uri(URI.create(urlImage))
                .retrieve()
                .bodyToMono(byte[].class)
                .block();
    }
}
