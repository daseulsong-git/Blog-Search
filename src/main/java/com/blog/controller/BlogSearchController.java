package com.blog.controller;

import com.blog.domain.Rank;
import com.blog.dto.BlogSearchResponse;
import com.blog.dto.RankResponse;
import com.blog.service.BlogSearchService;
import com.blog.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogSearchController {

    @Autowired
    private BlogSearchService blogSearchService;

    @Autowired
    private RankService rankService;

    // Keyword Search
    @GetMapping("api/blog/{keyword}/{page}")
    public List<BlogSearchResponse> blogSearch (@PathVariable("keyword") String keyword,
                                                @PathVariable("page") Integer page) throws Exception {

        List<BlogSearchResponse> result = blogSearchService.blogSearch(keyword, page);
        return result;
    }

    // Rank of Keyword
    @GetMapping("api/blog/rank")
    public List<RankResponse> getRank(){

        List<Rank> ranks = rankService.getRank();
        List<RankResponse> result = new ArrayList<>();

        RankResponse tempRank = null;
        for(Rank r : ranks){
            tempRank.setKeyword(r.getKeyword());
            tempRank.setCount(r.getCount());
        }
        return result;
    }
}
