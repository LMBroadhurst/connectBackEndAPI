package com.example.backEndProject.controller;


import com.example.backEndProject.model.dto.UserDto;
import com.example.backEndProject.repository.FriendRepository;
import com.example.backEndProject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FriendControllerTest {

    @Autowired
    FriendController friendController;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FriendRepository friendRepository;

    @Test
    void addFriend(){

        //        Given
//        UserDto userOutput = friendController.addFriend("Jem", "Scott");
//        //        When
//
//        //        Then
//        assertEquals("Scott", userOutput.getName());
    }


}
