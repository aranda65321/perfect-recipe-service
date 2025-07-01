package com.co.perfectrecipe.manager.module.recipe.usecase.impl;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatMessageDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatRequestDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.translators.ChatGptTranslator;
import com.co.perfectrecipe.manager.module.recipe.dataprovider.ChatGptDataProvider;
import com.co.perfectrecipe.manager.module.recipe.usecase.ChatGptUseCase;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ChatGptUseCaseImpl implements ChatGptUseCase {
    private final ChatGptDataProvider chatGptDataProvider;

    @Override
    public ChatGptChatResponseDto generateChat(String model, String prompt) {
        return this.chatGptDataProvider.generateChat(ChatGptTranslator.toChatGptChatRequestDto(model, prompt));
    }

    @Override
    public ChatGptImageResponseDto generateImage(String model, String prompt) {
        return this.chatGptDataProvider.generateImage(ChatGptTranslator.toChatGptImageRequestDto(model, prompt));
    }
}
