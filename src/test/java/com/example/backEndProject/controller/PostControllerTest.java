package com.example.backEndProject.controller;

import com.example.backEndProject.model.Post;
import com.example.backEndProject.repository.PostRepository;
import com.example.backEndProject.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import javax.print.DocFlavor;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    //Methods to test endpoints
    private MockMvc mockMvc;
//    @Autowired
    //methods to map json <-> java
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostController postController;

    @Autowired
    private PostService postService;

    @Test
    void getAll() {
    }

    @Test
    void findPostByID() {
    }

    @Test
    void findLikesByID() {
    }

    @Test
    void searchPostsForKeyword() {
    }


    @Test
    void shouldAddNewPost() throws Exception {
        // Given
        assertEquals(55, postRepository.findAll().size());
        // When
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/addNewPost")
//                                .param("id", "null")
                                .param("content_text", "I love coding")
                                .param("isBusinessAccount", "false")
                                .param("post_type_id", "1")
                                .param("user_id", "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        // Then
        String postInJsonFormat = mvcResult.getResponse().getContentAsString();
        Post post = objectMapper.readValue(postInJsonFormat, Post.class);

        assertEquals(56, postRepository.findAll().size());
        assertEquals(56L, post.getId());
        assertEquals("I love coding", post.getContent_text());
//        assertEquals(false, post.getBusinessAccount());
        assertEquals(1, post.getPost_types_id());
//        assertEquals(1L, post.getUser().getId());
    }
}

    @Test
    void updateLikeCount() {
//        Why use the longer .getAll .get . getNumberOfLikes?
//        We don't want to test with our getWithId method in case we have problems
//        in the future


//        Given
        Long existingIdLong = 1L;
        int existingIdInt = 1;
        int current_likes = postController.getAll().get(existingIdInt).getNumber_of_likes();

//        When
        postController.updateLikeCount(existingIdLong);

//        Then
        assertEquals(current_likes, postController.getAll().get(existingIdInt).getNumber_of_likes());
    }

    @Test
    void superLikePost() {
    }

    @Test
    void editPost() {
    }

    @Test
    void deletePostById() {
        //        Given
        String result = postController.deletePostByID(1L);
        //        When

        //        Then
        assertEquals("Deleted Post 1. If this was a mistake, you can add a new post using the Add post function!", result);
    }

    @Test
    void searchForAllBusinessAccountPosts() {
        List result = postService.searchAllBusinessAccountPosts(true).stream().toList();
        assertEquals(true, result);
    }

    @Test
    void addPost() {
    }
}