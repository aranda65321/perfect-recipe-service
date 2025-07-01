package com.co.perfectrecipe.manager.crosscutting.clients;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatRequestDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageRequestDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ChatGptClient {

    private WebClient client;
    private Environment environment;

    @PostMapping
    private void init() {
        this.client = WebClient.builder()
                .baseUrl(this.environment.getRequiredProperty("services.chat-gpt.host"))
                .defaultHeader(HttpHeaders.AUTHORIZATION, this.environment.getRequiredProperty("services.chat-gpt.key-secret"))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

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
}
