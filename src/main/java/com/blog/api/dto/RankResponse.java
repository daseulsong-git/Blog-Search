package com.blog.api.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RankResponse {
    private String keyword;
    private Integer count;
}


