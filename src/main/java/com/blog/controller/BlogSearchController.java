package com.blog.controller;

import com.blog.domain.Rank;
import com.blog.api.dto.RankResponse;
import com.blog.service.BlogSearchService;
import com.blog.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

    @Controller
    public class BlogSearchController {
        @Autowired
        private BlogSearchService blogSearchService;

        @Autowired
        private RankService rankService;

        @GetMapping("/blogSearchView")
        public String blogSearchView() {
            return "blogSearch";
        }

        @GetMapping("/rank")
        public String getRank(){

            List<Rank> ranks = rankService.getRank();
            List<RankResponse> result = new ArrayList<>();

            RankResponse tempRank;

            for(Rank r : ranks){
                tempRank = new RankResponse();
                tempRank.setKeyword(r.getKeyword());
                tempRank.setCount(r.getCount());
                result.add(tempRank);
            }
            return "rank";
        }

        @RequestMapping("/blogSearch")
        public String blogSearch (String keyword, Integer page, String sort, Model model) throws Exception{
            model.addAttribute("blogList", blogSearchService.blogSearch(keyword, page, sort));
            return "blogSearch";
        }
}
