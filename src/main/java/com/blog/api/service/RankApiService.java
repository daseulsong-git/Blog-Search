package com.blog.api.service;

import com.blog.domain.Rank;
import java.util.List;


public interface RankApiService {
    List<Rank> getRank();

    void addCountOfKeyword(String keyword);
}
