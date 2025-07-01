package com.co.perfectrecipe.manager.crosscutting.utils;

import com.co.perfectrecipe.manager.crosscutting.exception.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T fromJson(String json, Class<T> clazz) throws JsonParseException {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new JsonParseException("Error al deserializar JSON", e);
        }
    }
}
