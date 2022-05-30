package com.example.backEndProject.model;

import javax.persistence.*;

@Entity
@Table(name = "replies")
public class Reply {

//    ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reply;

    private int numberOfLikes;

    @ManyToOne
    private Comment comment;


//    ATTRIBUTES END
//
//
//    CONSTRUCTORS START


    public Reply() {
    }

    public Reply(Long id, String reply) {
        this.id = id;
        this.reply = reply;
    }


//    CONSTRUCTORS END
//
//
//    GETTERS AND SETTERS START


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }


//    GETTERS AND SETTERS END
//
//
//    END OF FILE

}
