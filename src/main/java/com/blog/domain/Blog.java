package com.blog.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Blog {
    private String title;
    private String contents;
    private String url;
    private String blogname;
    private String thumbnail;
    private Date datetime;
    
    /*검색용*/
    private String keyword;
    private String sort;
    private Integer totalCount;
    private String isEnd;
    private Integer currentPage;
    private String searchYn;
}
