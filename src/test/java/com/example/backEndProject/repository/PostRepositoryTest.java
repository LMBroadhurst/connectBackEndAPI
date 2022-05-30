package com.example.backEndProject.repository;

import com.example.backEndProject.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

//    @Autowired
    private PostRepository postRepository;



    @Test
    void findPostByID() {
    }

//    @Test
//    void deletePostById() {
//        ArrayList<Post> postList = new ArrayList<>();
//        Post post1 = new Post(1L, "this is a post", 10);
//        Post post2 = new Post(2L, "this is a post", 9);
//        postList.add(1, post1);
//        postList.add(2, post2);
//        postRepository.deletePostByID(post1.getId());
//        assertThat(postRepository.count()).isEqualTo(1);
}