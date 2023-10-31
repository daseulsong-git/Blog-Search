package com.blog.convert;

import com.blog.domain.Blog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import javax.persistence.AttributeConverter;

@Component
public class JsonConverter implements AttributeConverter<Blog, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Blog attribute) {
        return null;
    }

    @Override
    public Blog convertToEntityAttribute(String docu) {
        try {
            return objectMapper.readValue(docu, Blog.class);
        } catch (Exception e) {
            return null;
        }
    }
}
