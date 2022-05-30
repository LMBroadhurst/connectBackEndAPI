package com.example.backEndProject.repository;

import com.example.backEndProject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM posts WHERE id = ?",nativeQuery = true)
    Post findPostByID(Long id);

    // delete query to delete a post by a specific post_id
    @Query(value = "DELETE FROM posts WHERE post_id = ?", nativeQuery = true)
    String deletePostByID(Long id);


    @Query(value = "SELECT * FROM posts WHERE is_business_account = ?", nativeQuery = true)
    List searchAllBusinessAccountPosts(boolean isBusinessAccount);


}
