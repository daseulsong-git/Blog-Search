package com.blog.service;

import com.blog.domain.Rank;
import com.blog.persistence.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService{

    @Autowired
    private RankRepository rankRepository;

    @Override
    public List<Rank> getRank() {
        return rankRepository.getRank();
    }

    @Override
    public void addCountOfKeyword(String keyword) {
        rankRepository.addCountOfKeyword(keyword);
    }


}
