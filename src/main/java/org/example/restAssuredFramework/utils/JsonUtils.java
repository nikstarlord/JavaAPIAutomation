package org.example.restAssuredFramework.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> T deserialize(String json, Class<T> clazz){
        try{
            return objectMapper.readValue(json, clazz);
        } catch (Exception e){
            throw new RuntimeException("Error deserializing JSON", e);
        }
    }

    public static <T> List<T> deserializeList(String json, Class<T> clazz){
        try{
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            return objectMapper.readValue(json, type);
        } catch (Exception e){
            throw new RuntimeException("Error deserializing list", e);
        }
    }

    private JsonUtils(){}
}
