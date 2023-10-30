package com.blog.service;

import com.blog.domain.Rank;
import com.blog.dto.BlogSearchResponse;
import org.springframework.ui.Model;

import java.util.List;

public interface BlogSearchService {
    List<BlogSearchResponse> blogSearch(String keyword, Integer page) throws Exception;
    List<BlogSearchResponse> blogSearch(String keyword, Integer page, Model model) throws Exception;
}
