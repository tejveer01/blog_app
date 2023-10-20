package com.mountblue.blog.repository;

import com.mountblue.blog.entitites.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // Custom query methods can be added here
    Post saveAndFlush(Post post);

    @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Post> searchByTitle(@Param("keyword") String keyword);
}
