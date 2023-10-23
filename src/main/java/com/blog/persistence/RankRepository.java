package com.blog.persistence;

import com.blog.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Rank, String> {

    @Query(nativeQuery = true, value = "select * from Post ORDER BY count desc LIMIT 10")
    List<Rank> getRank();

    @Transactional
    @Modifying
    @Query("update Rank r set r.count = r.count + 1 where r.keyword = :keyword")
    void addCountOfKeyword(String keyword);

}
