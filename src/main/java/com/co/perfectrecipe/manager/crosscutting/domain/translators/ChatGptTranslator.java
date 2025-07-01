package com.co.perfectrecipe.manager.crosscutting.domain.translators;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.*;

import java.util.List;

public class ChatGptTranslator {
    private static final String ROLE = "user";
    private static final int N = 1;
    private static final String SIZE = "1024x1024";

    public static ChatGptChatRequestDto toChatGptChatRequestDto(String model, String content) {
        return ChatGptChatRequestDto.builder()
                .model(model)
                .messages(List.of(ChatGptChatMessageDto.builder()
                        .role(ROLE)
                        .content(content)
                        .build()))
                .build();
    }

    public static ChatGptImageRequestDto toChatGptImageRequestDto(String model, String prompt) {
        return ChatGptImageRequestDto.builder()
                .model(model)
                .n(N)
                .size(SIZE)
                .prompt(prompt)
                .build();
    }
}
