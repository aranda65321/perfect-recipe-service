package com.co.perfectrecipe.manager.module.chatgpt.dataprovider.impl;

import com.co.perfectrecipe.manager.crosscutting.clients.ChatGptClient;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatRequestDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageRequestDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageResponseDto;
import com.co.perfectrecipe.manager.module.chatgpt.dataprovider.ChatGptDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ChatGptDataProviderImpl implements ChatGptDataProvider {
    private final ChatGptClient chatGptClient;

    @Override
    public ChatGptChatResponseDto generateChat(ChatGptChatRequestDto request) {
        return this.chatGptClient.generateChat(request);
    }

    @Override
    public ChatGptImageResponseDto generateImage(ChatGptImageRequestDto request) {
        return this.chatGptClient.generateImage(request);
    }

    @Override
    public byte[] downloadGptImage(String urlImage) {
        return this.chatGptClient.downloadImage(urlImage);
    }
}
