package com.blog.controller;

import com.blog.domain.Rank;
import com.blog.dto.BlogSearchResponse;
import com.blog.dto.RankResponse;
import com.blog.service.BlogSearchService;
import com.blog.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogSearchController {
    @Autowired
    private BlogSearchService blogSearchService;

    @Autowired
    private RankService rankService;

    // Keyword Search
    @GetMapping("/blogSearch")
    public List<BlogSearchResponse> blogSearch (String keyword, Integer page, Model model) throws Exception{

        List<BlogSearchResponse> result = blogSearchService.blogSearch(keyword, page);
        return result;
    }

}
