package com.blog.api.service;

import com.blog.domain.Rank;
import com.blog.api.persistence.RankApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankApiServiceImpl implements RankApiService {

    @Autowired
    private RankApiRepository rankApiRepository;

    @Override
    public List<Rank> getRank() {
        return rankApiRepository.getRank();
    }

    @Override
    public void addCountOfKeyword(String keyword) {
        rankApiRepository.addCountOfKeyword(keyword);
    }


}
