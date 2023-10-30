package com.blog.convert;

import com.blog.api.dto.BlogSearchResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import javax.persistence.AttributeConverter;

@Component
public class JsonConverter implements AttributeConverter<BlogSearchResponse, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(BlogSearchResponse attribute) {
        return null;
    }

    @Override
    public BlogSearchResponse convertToEntityAttribute(String docu) {
        try {
            return objectMapper.readValue(docu, BlogSearchResponse.class);
        } catch (Exception e) {
            return null;
        }
    }
}
