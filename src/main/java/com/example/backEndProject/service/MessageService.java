package com.example.backEndProject.service;

import com.example.backEndProject.model.Message;
import com.example.backEndProject.model.User;
import com.example.backEndProject.repository.MessageRepository;
import com.example.backEndProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MessageService {


//    DEPENDENCY INJECTION

    @Autowired
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Autowired
    private UserRepository userRepository;


//    END OF DEPENDENCY INJECTION
//
//
//    START OF METHODS


    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public String sendMessageToUser(String message_content,
                                     String name_of_sender,
                                     String password_of_sender,
                                     String receiver_name) {

        User receiver = getUserFromName(receiver_name.toLowerCase());
        User sender = getUserFromName(name_of_sender.toLowerCase());

        if (credentialsChecker(password_of_sender, receiver, sender) != null) {
            return credentialsChecker(password_of_sender, receiver, sender);
        }

        Message newMessage = createSetAndSaveMessage(message_content, receiver, sender);

        return formatMessage(newMessage);
    }

    public String formatMessage(Message message) {
        return message.getMessage_content() +
                "\nMessage to " + message.getUserR().getName() + " sent successfully! \n" +
                "Message sent at: " + LocalDateTime.now() +
                ". \nThanks for using connect, " + message.getUserS().getName() + " :)";
    }

    private String credentialsChecker(String password_of_sender, User receiver, User sender) {
        if (sender == null) {
            return "We could not find your username.";
        } else if (!Objects.equals(sender.getPassword(), password_of_sender)) {
            return "Incorrect password.";
        } else if (receiver == null) {
            return "Could not find the message recipient, please try again.";
        } else {
            return null;
        }
    }

    private Message createSetAndSaveMessage(String message_content, User receiver, User sender) {
        Message newMessage = new Message(message_content, sender, receiver);
        receiver.getInbox().add(newMessage);
        newMessage.setUserR(receiver);
        newMessage.setUserS(sender);
        messageRepository.save(newMessage);
        userRepository.save(receiver);
        return newMessage;
    }

    private User getUserFromName(String user_name) {
        return userRepository.findAll().stream()
                .filter(userX -> user_name.equals(userX.getName().toLowerCase()))
                .findFirst()
                .orElse(null);
    }




    public List<String> getAllMessagesFromSpecificUsersInbox(String user_name,
                                                              String user_password) {

        User user = getUserFromName(user_name.toLowerCase());
        List<String> inboxMessages = new ArrayList<>();

        for (Message msg: userRepository.findByID(user.getId()).getInbox()) {
            inboxMessages.add(msg.getMessage_content());
        }

        return inboxMessages;
    }




    public Message editSentMessage(Long message_id,
                                   String newMessageContent) {

        Message editedMessage = messageRepository.findById(message_id).get();
        editedMessage.setMessage_content(newMessageContent);

        return messageRepository.save(editedMessage);
    }

    public String deleteMessage(Long id) {
        String outputMessage = "Successfully deleted message with id: " + id;

        try {
            messageRepository.deleteById(id);
        } catch (Exception e) {
            outputMessage = "Could not find message id";
        }

        return outputMessage;
    }


//    END OF METHODS
//
//
//    END OF FILE
}
