package com.blog.controller;

import com.blog.domain.Rank;
import com.blog.service.BlogSearchService;
import com.blog.service.RankService;
import com.google.gson.Gson;
import jdk.jfr.Name;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class BlogSearchControllerTest {

    MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private BlogSearchService blogSearchService;

    @MockBean
    private RankService rankService;

    @MockBean
    private Rank rank;

   // @Test
    void blogSearch() {

    }

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    void getRank() throws Exception {

        //data Setting
        List<Rank> result = new ArrayList<>();
        result.add(new Rank("오렌지",3));
        result.add(new Rank("감자",2));

        Gson gson = new Gson();
        String jsonResult = gson.toJson(result);

        when(rankService.getRank()).thenReturn(result);

        // HTTP(http://localhost:8080/api/blog/rank) 요청 전송
        mockMvc.perform(MockMvcRequestBuilders.get("/api/blog/rank"))

        // HTTP 응답 결과 검증
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string(jsonResult));
    }
}