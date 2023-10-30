package com.blog.api.service;

import com.blog.api.dto.BlogSearchResponse;
import org.springframework.ui.Model;

import java.util.List;

public interface BlogSearchApiService {
    List<BlogSearchResponse> blogSearch(String keyword, Integer page) throws Exception;
    List<BlogSearchResponse> blogSearch(String keyword, Integer page, Model model) throws Exception;
}
