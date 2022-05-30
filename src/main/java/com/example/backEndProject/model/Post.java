package com.example.backEndProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.function.Predicate;

@Entity
@Table(name = "posts")
public class Post {

//    ATTRIBUTES START


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content_text;
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int number_of_likes;

    @Column(name = "post_types_id")
    private Integer post_types_id;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE", name = "is_business_account")
    private boolean isBusinessAccount;

    @Column(name = "company_id")
    private int companyId;

//    Relationship Mapping

    @ManyToOne
    private User user;

    @JsonIgnoreProperties({"post"})
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> postComments;



//    ATTRIBUTES END
//
//
//    CONSTRUCTORS START


    public Post() {}

    public Post(Long id, String content_text, Integer number_of_likes, boolean isBusinessAccount, Integer post_type_id) {}

    public Post(Long id, String content_text, int number_of_likes, int companyId, boolean isBusinessAccount, int post_types_id) {
        this.id = id;
        this.content_text = content_text;
        this.number_of_likes = number_of_likes;
        this.companyId = companyId;
        this.isBusinessAccount = isBusinessAccount;
        this.post_types_id = post_types_id;
    }

    public Post(String content_text, User user) {
        this.content_text = content_text;
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

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public int getNumber_of_likes() {
        return number_of_likes;
    }

    public void setNumber_of_likes(int number_of_likes) {
        this.number_of_likes = number_of_likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPost_types_id() {
        return post_types_id;
    }

    public void setPost_types_id(int post_types_id) {
        this.post_types_id = post_types_id;
    }

    public boolean isBusinessAccount() {
        return isBusinessAccount;
    }

    public void setBusinessAccount(boolean businessAccount) {
        isBusinessAccount = businessAccount;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

//    GETTERS AND SETTERS END
//
//
//    CODE BEING TESTED...


//    public int getBusinessAccID() {
//        return businessAccID;
//    }
//
//    public void setBusinessAccID(int businessAccID) {
//        this.businessAccID = businessAccID;
//    }


//    CODE BEING TESTED...
//
//
//    END OF FILE
}
