package com.co.perfectrecipe.manager.module.chatgpt.usecase.impl;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.translators.ChatGptTranslator;
import com.co.perfectrecipe.manager.module.chatgpt.dataprovider.ChatGptDataProvider;
import com.co.perfectrecipe.manager.module.chatgpt.usecase.ChatGptUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ChatGptUseCaseImpl implements ChatGptUseCase {
    private final ChatGptDataProvider chatGptDataProvider;

    @Override
    public ChatGptChatResponseDto generateChat(String model, String prompt) {
        log.info("Realizando peticion para generacion de texto con chatgpt");
        return this.chatGptDataProvider.generateChat(ChatGptTranslator.toChatGptChatRequestDto(model, prompt));
    }

    @Override
    public ChatGptImageResponseDto generateImage(String model, String prompt) {
        log.info("Realizando peticion para generacion de imagenes con chatgpt");
        return this.chatGptDataProvider.generateImage(ChatGptTranslator.toChatGptImageRequestDto(model, prompt));
    }

    @Override
    public byte[] downloadGptImage(String urlImage) {
        log.info("Realizando peticion para descarga de imagenes con chatgpt");
        return this.chatGptDataProvider.downloadGptImage(urlImage);
    }
}
