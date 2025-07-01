package com.co.perfectrecipe.manager.module.recipe.usecase;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageResponseDto;

public interface ChatGptUseCase {
    public ChatGptChatResponseDto generateChat(String model, String prompt);

    public ChatGptImageResponseDto generateImage(String model, String prompt);
}
