package com.example.backEndProject.model;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {

//    ATTRIBUTES START


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message_content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User userS;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User userR;




//    ATTRIBUTES END
//
//
//    CONSTRUCTORS START


    public Message() {
    }

    public Message(String message_content, User userR, User userS) {
        this.message_content = message_content;
    }


//    CONSTRUCTORS END
//
//
//    Getters and setters START


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public User getUserR() {
        return userR;
    }

    public void setUserR(User userR) {
        this.userR = userR;
    }

    public User getUserS() {
        return userS;
    }

    public void setUserS(User userS) {
        this.userS = userS;
    }

//    GETTERS AND SETTERS END
//
//
//    FILE END
}
