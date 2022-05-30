package com.example.backEndProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {


//    ATTRIBUTES START


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String company;
    private String role;

    private String password;
    private String date_of_birth;

//    Inbox/Messages



    @JsonIgnoreProperties({"userS", "userR"})
    @OneToMany(mappedBy = "userS",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Message> inbox;



//    Relationship Mapping

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> allPostsByUser;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> allCommentsByUser;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_list")
    private Friend friend;


    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE", name = "is_business_account")
    private Boolean isBusinessAccount;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE",name = "user_logged_in")
    private boolean isUserLoggedIn;

    @Column(name = "company_id")
    private int companyId;


//    Constructors
//    ATTRIBUTES END
//
//
//    CONSTRUCTORS START


    public User() {}

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(Long id, String name, String company, String role, String password,
                String date_of_birth, ArrayList<Message> inbox, ArrayList<Post> allPostsByUser,
                boolean isBusinessAccount, boolean isUserLoggedIn, int companyId, Friend friend) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.role = role;
        this.password = password;
        this.date_of_birth = date_of_birth;
        this.allPostsByUser = allPostsByUser;
        this.inbox = new ArrayList<>();
        this.isBusinessAccount = isBusinessAccount;
        this.isUserLoggedIn = isUserLoggedIn;
        this.companyId = companyId;
        this.friend = friend;
    }

    public User(Long id, String name, String company, String role, String date_of_birth, boolean isBusinessAccount) {
    }

    // NO ARG CONSTRUCTOR FOR FRIENDS TABLE


    //simplified constructor

    public User(String name, String company, String role, String password, String date_of_birth) {
        this.name = name;
        this.company = company;
        this.role = role;
        this.password = password;
        this.date_of_birth = date_of_birth;
    }

    //    CONSTRUCTORS ENDS
//
//
//    GETTERS AND SETTERS START


    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public List<Post> getAllPostsByUser() {
        return allPostsByUser;
    }

    public void setAllPostsByUser(List<Post> allPostsByUser) {
        this.allPostsByUser = allPostsByUser;
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public void setInbox(List<Message> inbox) {
        this.inbox = inbox;
    }


    public boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
    }

    public Friend getFriendList() {
        return friend;
    }

    public void setFriendList(Friend friend) {
        this.friend = friend;
    }

    //    GETTERS AND SETTERS END
//
//
//    FILE END
}
