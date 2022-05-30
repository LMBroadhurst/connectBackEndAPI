package com.example.backEndProject.controller;

import com.example.backEndProject.model.Reply;
import com.example.backEndProject.model.User;
import com.example.backEndProject.service.ReplyService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.NoSuchElementException;

@RestController
public class ReplyController {
//    @EnableWebSecurity
//    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception{
//            http.cors().and().csrf().disable();
//        }
//
//        @Bean
//        CorsConfigurationSource corsConfigurationSource() {
//            CorsConfiguration configuration = new CorsConfiguration();
//            configuration.setAllowedOrigins(Arrays.asList("*"));
//            configuration.setAllowedMethods(Arrays.asList("*"));
//            configuration.setAllowedHeaders(Arrays.asList("*"));
//            configuration.setAllowCredentials(true);
//            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//            source.registerCorsConfiguration("/**", configuration);
//            return source;
//        }

//    }

    private ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }
// Post Methods
//    @PostMapping("/addReply")
//    public ResponseEntity<Reply> addReply(@RequestBody Reply reply) {
//        Reply newReply = replyService.save(reply);
//
//        return new ResponseEntity<>(newReply, HttpStatus.CREATED);

    @PostMapping("/addReply")
    public void addReply(@RequestBody Reply reply){
        Reply savedUser = replyService.save(reply);
    }

}
