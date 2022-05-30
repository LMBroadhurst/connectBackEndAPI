package com.example.backEndProject.controller;

import com.example.backEndProject.model.User;
import com.example.backEndProject.repository.MessageRepository;
import com.example.backEndProject.service.MessageService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageControllerTest {

    @Autowired
    MessageController messageController;

    @Test
    void sendMessageToUser__incorrectPassword() {
//        When
        String output = messageController.sendMessageToUser
                ("Hi test!","lewis", "koolkoder", "scott");
//        Then
        assertEquals("Incorrect password.", output);
    }

    @Test
    void sendMessageToUser__senderNotFound() {
//        When
        String output = messageController.sendMessageToUser
                ("Hi test!","lewisss", "koolkode", "scott");
//        Then
        assertEquals("We could not find your username.", output);
    }

    @Test
    void sendMessageToUser__receiverNotFound() {
//        When
        String output = messageController.sendMessageToUser
                ("Hi test!","lewis", "koolkode", "scottie");
//        Then
        assertEquals("Could not find the message recipient, please try again.", output);
    }
}