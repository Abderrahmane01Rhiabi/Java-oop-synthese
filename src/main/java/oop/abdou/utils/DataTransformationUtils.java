package oop.abdou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataTransformationUtils {

    public static String toJason(Object o){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return "{}";
        }

    }

}
