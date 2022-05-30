package com.example.backEndProject.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {


//    ATTRIBUTES START

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,columnDefinition = "INTEGER DEFAULT 0")
    private int likes;

    @Column(nullable=false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean heartByUser;

    private String commentContent;

//    @Min(1)
//    @Max(500)
//    private int numberOfCharacters;

    @ManyToOne
    private Post post;

    @ManyToOne
    @JoinColumn(name = "commenter_UserID")
    private User user;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"comment"})
    private List<Reply> commentReplies;


//    ATTRIBUTES END
//
//
//    CONSTRUCTORS START


    public Comment() {
    }

    public Comment(Long id,String commentContent, Post post, User user) {
        this.id = id;
        this.commentContent = commentContent;
        this.post = post;
        this.user = user;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Boolean getHeartByUser() {
        return heartByUser;
    }

    public void setHeartByUser(Boolean heartByUser) {
        this.heartByUser = heartByUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


//    GETTERS AND SETTERS END
//
//
//    END OF FILE

}
