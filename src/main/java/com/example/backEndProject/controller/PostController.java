package com.example.backEndProject.controller;

import com.example.backEndProject.model.Post;
import com.example.backEndProject.model.User;
import com.example.backEndProject.repository.PostRepository;
import com.example.backEndProject.service.PostService;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
public class PostController {


//    Dependency Injection START


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    Dependency Injection END
//
//
//    Get Methods START


    @GetMapping("/list_all_posts")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/post/{id}")
    public Post findPostByID(@PathVariable("id") Long id) {
        return postService.findPostByID(id);
    }

    @GetMapping("/numberOfLikesOnPost/{id}")
    public int findLikesByID(@PathVariable("id") Long id) {
        return postService.findLikesByID(id);
    }

    @GetMapping("/searchForKeyword/{keyword}")
    public List searchPostsForKeyword(@PathVariable("keyword") String keyword) {
        return postService.searchPostsForKeyword(keyword);
    }

    @GetMapping("/searchAllBusinessAccountPosts/{is_business_account}/")
    public List searchAllBusinessAccountPosts(@PathVariable("is_business_account") boolean isBusinessAccount) {
        return postService.searchAllBusinessAccountPosts(isBusinessAccount);
    }

//    @GetMapping("/searchSpecificBusinessAccountPosts/{is_business_account}")
//    public List<Post> searchSpecificBusinessAccountPosts(@PathVariable("is_business_account") Boolean isBusinessAccount, int companyId) {
//        return postService.searchSpecificBusinessAccountPosts(isBusinessAccount, companyId);
//    }

//    Get Methods END
//
//
//    Put Methods START


//    Put Methods

    @PutMapping("/addLikeToPost/{id}")
    public Post updateLikeCount(@PathVariable("id") Long id) throws NoSuchElementException {

        return postService.updateLikeCount(id);
    }

    @PutMapping("/addSuperlikeToPost/{id}")
    public Post superLikePost(@PathVariable("id") Long id) throws NoSuchElementException {

        return postService.superLikePost(id);
    }

    @PutMapping("/editOldPost/{id}")
    public Post editPost(@RequestBody String new_content, @PathVariable("id") Long id)
            throws NoSuchElementException, IOException {
        return postService.editPost(id, new_content);
    }


//    Put Methods END
//
//
//    Delete Methods START


    @DeleteMapping("/deletePost/{id}")
    public String deletePostByID(@PathVariable("id") Long id) {

        return postService.deletePostByID(id);
    }

//    Delete Methods END
//
//
//    POST METHODS START

    @PostMapping("/addNewPost")
    public Post addPost(@RequestParam("id") Long id,
                        @RequestParam("content") String content_text,
                        @RequestParam("isBusiness") boolean isBusinessAccount,
                        @RequestParam("post_type") Integer post_type_id,
                        @RequestParam("user_id") Long user_id) throws IOException {

        return postService.addPost(id, content_text, 0, isBusinessAccount, post_type_id, user_id);

    }
}

