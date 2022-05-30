//package com.example.backEndProject.controller;
//
//import com.example.backEndProject.model.Post;
//import com.example.backEndProject.model.User;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//
//// THIS IS FOR AUTHENTICATION LOGIN! PLEASE DON'T TOUCH!
//
//
//@Controller
//public class HomeController {
//
//    private Map<String, LocalDateTime> usersLastAccess = new HashMap<>();
//
//    @GetMapping("/")
//    public String getCurrentUser(@AuthenticationPrincipal User admin, Model model) {
//
//        String username = admin.getName();
//
//        model.addAttribute("username", username);
//        model.addAttribute("lastAccess", usersLastAccess.get(username));
//
//        usersLastAccess.put(username, LocalDateTime.now());
//
//        return "home";
//    }
//}
//
//// THIS IS FOR AUTHENTICATION LOGIN! PLEASE DON'T TOUCH!
