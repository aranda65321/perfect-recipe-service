package com.co.perfectrecipe.manager.crosscutting.domain.translators;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.enums.TypeError;
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
