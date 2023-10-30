package com.blog.api.controller;

import com.blog.domain.Rank;
import com.blog.api.dto.BlogSearchResponse;
import com.blog.api.dto.RankResponse;
import com.blog.api.service.BlogSearchApiService;
import com.blog.api.service.RankApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogSearchApiController {

    @Autowired
    private BlogSearchApiService blogSearchApiService;

    @Autowired
    private RankApiService rankApiService;

    // Keyword Search
    @GetMapping("api/blog/{keyword}/{page}")
    public List<BlogSearchResponse> blogSearch (@PathVariable("keyword") String keyword,
                                                @PathVariable("page") Integer page) throws Exception {

        List<BlogSearchResponse> result = blogSearchApiService.blogSearch(keyword, page);
        return result;
    }

    // Rank of Keyword
    @GetMapping("api/blog/rank")
    public List<RankResponse> getRank(){

        List<Rank> ranks = rankApiService.getRank();
        List<RankResponse> result = new ArrayList<>();

        RankResponse tempRank = null;

        for(Rank r : ranks){
            tempRank = new RankResponse();
            tempRank.setKeyword(r.getKeyword());
            tempRank.setCount(r.getCount());
            result.add(tempRank);
        }
        return result;
    }
}
