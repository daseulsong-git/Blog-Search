package com.blog.service;

import com.blog.domain.Rank;
import com.blog.dto.BlogSearchResponse;
import java.util.List;

public interface BlogSearchService {
    List<BlogSearchResponse> blogSearch(String keyword, Integer page) throws Exception;
}
