package com.example.backEndProject.service;

import com.example.backEndProject.controller.MessageController;
import com.example.backEndProject.model.User;
import com.example.backEndProject.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @Autowired
    MessageController messageController;

    @Autowired
    MessageRepository messageRepository;

    @Test
    void credentialsChecker__test() {

    }

    @Test
    void createSetAndSaveMessage__test() {

    }

    @Test
    void getUserFromName__test() {

    }

    @Test
    void sendMessageToUser__test() {
        //        Given
        User testUserS = new User(1L, "Lewis1", "password1");
        User testUserR = new User(2L, "Lewis2", "password2");

//        When
        messageController.sendMessageToUser
                ("Hi test!","lewis", "koolkode", "scott");

//        Then
        assertEquals(7, messageRepository.findAll().size());
    }


}