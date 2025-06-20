package com.co.domainconfiguration.manager.crosscutting.domain.translators;

import com.co.domainconfiguration.manager.crosscutting.domain.enums.TypeError;
import com.co.domainconfiguration.manager.crosscutting.domain.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;

public class ApiResponseTranslator {
    public static ApiResponseDto toApiResponseDto(HttpStatus statusCode, Object content) {
        return ApiResponseDto.builder()
                .statusCode(String.valueOf(statusCode.value()))
                .content(content)
                .build();
    }

    public static ApiResponseDto toApiResponseDtoWithError(TypeError typeError) {
        return ApiResponseDto.builder()
                .statusCode(typeError.getCode())
                .error(typeError.getDescription())
                .build();
    }
}
