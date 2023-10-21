package com.blog.persistence;

import com.blog.domain.Post;
import com.blog.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Rank, String> {

    @Query(nativeQuery = true, value = "select * from Post ORDER BY count desc LIMIT 10")
    List<Rank> getRank();

}
