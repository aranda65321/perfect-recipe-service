package com.co.perfectrecipe.manager.module.recipe.dataprovider;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatRequestDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageRequestDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageResponseDto;

public interface ChatGptDataProvider {
    public ChatGptChatResponseDto generateChat(ChatGptChatRequestDto request);

    public ChatGptImageResponseDto generateImage(ChatGptImageRequestDto request);
}
