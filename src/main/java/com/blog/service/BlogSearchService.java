package com.blog.service;

import com.blog.domain.Blog;
import java.util.List;

public interface BlogSearchService {
    List<Blog> blogSearch(String keyword, Integer page, String sort, String searchYn) throws Exception;
}
