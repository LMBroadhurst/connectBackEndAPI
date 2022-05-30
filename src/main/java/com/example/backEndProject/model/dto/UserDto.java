package com.example.backEndProject.model.dto;

public class UserDto {

    private Long id;
    private String name;
    private String company;
    private String role;
    private String date_of_birth;
    boolean isBusinessAccount;

    public UserDto(Long id, String name, String company, String role, String date_of_birth, boolean isBusinessAccount) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.role = role;
        this.date_of_birth = date_of_birth;
        this.isBusinessAccount = isBusinessAccount;
    }

    public UserDto(){}

    public Long getId() {
        return id;
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

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public boolean isBusinessAccount() {
        return isBusinessAccount;
    }

    public void setBusinessAccount(boolean businessAccount) {
        isBusinessAccount = businessAccount;
    }
}
