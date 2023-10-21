package com.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RankResponse {
    private String keyword;
    private Integer count;

}

