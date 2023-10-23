package com.blog.service;

import com.blog.domain.Rank;
import java.util.List;

public interface RankService {
    List<Rank> getRank();

    void addCountOfKeyword(String keyword);
}
