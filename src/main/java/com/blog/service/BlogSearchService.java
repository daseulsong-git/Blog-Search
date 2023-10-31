package com.blog.service;

import com.blog.api.dto.BlogSearchResponse;
import com.blog.domain.Blog;
import org.springframework.ui.Model;

import java.util.List;

public interface BlogSearchService {
    List<Blog> blogSearch(String keyword, Integer page) throws Exception;
}
