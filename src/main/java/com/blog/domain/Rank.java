package com.blog.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class Rank{
    @Id
    private String keyword;
    private Integer count;

    public Rank(String keyword, int i) {
        this.keyword = keyword;
        this.count = i;
    }
}
