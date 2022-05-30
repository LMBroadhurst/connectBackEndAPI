package com.example.backEndProject.controller;

import com.example.backEndProject.model.Message;
import com.example.backEndProject.repository.MessageRepository;
import com.example.backEndProject.repository.UserRepository;
import com.example.backEndProject.service.MessageService;
import com.example.backEndProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {


//    Injection Dependency START

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

//    Injection Dependency END
//
//
//    MESSAGING FEATURES START

    @PostMapping("/sendMessageToUser")
    public String sendMessageToUser(
                                     @RequestParam("message_content") String message_content,
                                     @RequestParam("name_of_sender") String name_of_sender,
                                     @RequestParam("password") String password,
                                     @RequestParam("receiver_name") String receiver_name) {

        return messageService.sendMessageToUser(message_content, name_of_sender, password, receiver_name);
    }

    @GetMapping("/getMessageByID/{id}")
    public String getMessageByID(@PathVariable("id") int id) {
        return messageService.getAll().get(id).getMessage_content();
    }

    @GetMapping("/getInboxOfSpecificUserByName")
    public List<String> getInboxOfSpecificUserByName(@RequestParam String user_name,
                                                      String user_password) {
        return messageService.getAllMessagesFromSpecificUsersInbox(user_name, user_password);
    }

    @PutMapping("/editSentMessage/{message_id}")
    public Message editSentMessage(@RequestParam Long message_id,
                                   @RequestParam String newMessageContent
                                   ) {
        return messageService.editSentMessage(message_id, newMessageContent);
    }

    @DeleteMapping("/deleteASentMessage/{id}")
    public String deleteMessage(@PathVariable("id") Long id) {

        return messageService.deleteMessage(id);
    }

//    MESSAGING FEATURES END
//
//
//    FILE END

}
