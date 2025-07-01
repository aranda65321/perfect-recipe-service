package com.co.perfectrecipe.manager.crosscutting.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatGptChatResponseDto {
    private String id;
    private String object;
    private String model;
    private List<ChatGptChoice> choices;

}