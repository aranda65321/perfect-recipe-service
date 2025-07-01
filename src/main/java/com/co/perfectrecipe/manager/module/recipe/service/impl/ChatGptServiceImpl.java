package com.co.perfectrecipe.manager.module.recipe.service.impl;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptChatResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.ChatGptImageResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.exception.ApiProcessException;
import com.co.perfectrecipe.manager.crosscutting.utils.JsonUtils;
import com.co.perfectrecipe.manager.module.recipe.service.ChatGptService;
import com.co.perfectrecipe.manager.module.recipe.usecase.ChatGptUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ChatGptServiceImpl implements ChatGptService {
    private final ChatGptUseCase chatGptUseCase;
    private final Environment environment;

    @Override
    public RecipeDto generateRecipe() throws ApiProcessException {
        try {
            RecipeDto recipe = RecipeDto.builder().build();
            ChatGptChatResponseDto recipeGpt = this.chatGptUseCase.generateChat(
                    this.environment.getRequiredProperty("services.chat-gpt.chat-model"),
                    this.environment.getRequiredProperty("services.chat-gpt.default-message"));
            if (recipeGpt.getChoices().stream().findFirst().isPresent()) {
                recipe = JsonUtils.fromJson(recipeGpt.getChoices().stream().findFirst().get().getMessage().getContent(),
                        RecipeDto.class);
                ChatGptImageResponseDto recipeImgGpt = this.chatGptUseCase.generateImage(
                        this.environment.getRequiredProperty("services.chat-gpt.img-model"),
                        String.format(this.environment.getRequiredProperty("services.chat-gpt.default-message-img"), recipe.getName()));

            }
            return recipe;
        } catch (Exception ex) {
            log.error("No fue posible generar la receta", ex);
            throw new ApiProcessException(ex);
        }
    }
}
