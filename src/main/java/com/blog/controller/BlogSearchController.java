package com.blog.controller;

import com.blog.domain.Post;
import com.blog.dto.BlogSearchResponse;
import com.blog.dto.RankResponse;
import com.blog.service.BlogSearchService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class BlogSearchController {

    @Autowired
    private BlogSearchService blogSearchService;

    // Keyword Search
    @GetMapping("api/blog/{keyword}/{page}")
    public List<BlogSearchResponse> blogSearch (@PathVariable("keyword") String keyword,
                                                @PathVariable("page") Integer page) throws Exception {

        List<BlogSearchResponse> result = blogSearchService.blogSearch(keyword, page);
        return result;
    }

    // Rank of Keyword
    @GetMapping("api/blog/rank")
    public List<RankResponse> getRank (){

        return null;
    }
}
