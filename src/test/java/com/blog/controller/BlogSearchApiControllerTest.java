package com.blog.controller;

import com.blog.api.controller.BlogSearchApiController;
import com.blog.api.service.RankApiServiceImpl;
import com.blog.domain.Rank;
import com.blog.api.service.BlogSearchApiService;
import com.blog.api.service.RankApiService;
import com.google.gson.Gson;
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
import static org.mockito.Mockito.when;

@WebMvcTest(BlogSearchApiController.class)
class BlogSearchApiControllerTest {

    MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;
    @MockBean
    private RankApiService rankApiService;

    @MockBean
    private BlogSearchApiService blogSearchApiService;

    @MockBean
    private Rank rank;

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

        when(rankApiService.getRank()).thenReturn(result);

        // HTTP(http://localhost:8080/api/blog/rank) 요청 전송
        mockMvc.perform(MockMvcRequestBuilders.get("/api/blog/rank"))

        // HTTP 응답 결과 검증
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string(jsonResult));
    }
}