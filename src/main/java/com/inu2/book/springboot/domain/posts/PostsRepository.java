package com.inu2.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
// JpaRepository : MyBatis 등에서 Dao라고 불리는 DB Layer 접근자
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p From Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
