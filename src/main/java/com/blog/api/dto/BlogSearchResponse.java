package com.blog.api.dto;

import com.blog.convert.JsonConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Convert;
import java.util.Date;

@Data
@AllArgsConstructor
public class BlogSearchResponse {
    private String title;
    private String contents;
    private String url;
    private String blogname;
    private String thumbnail;
    private Date datetime;

    public BlogSearchResponse() {

    }
}