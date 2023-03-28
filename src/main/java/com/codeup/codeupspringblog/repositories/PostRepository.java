package com.codeup.codeupspringblog.repositories;


import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);

    @Query("from Dog d where d.name like %:title%")
    List<Post> findLikeName(@Param("title") String title);
}
