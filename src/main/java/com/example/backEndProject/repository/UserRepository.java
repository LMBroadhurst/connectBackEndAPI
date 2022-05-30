package com.example.backEndProject.repository;

import com.example.backEndProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE id = ?",nativeQuery = true)
    User findByID(Long id);

    @Query(value = "SELECT * FROM users WHERE name = ?1 AND password = ?2",nativeQuery = true)
    User findUserByUsernameAndPassword(String username,String password);

    @Query(value = "SELECT * FROM users WHERE name = ?",nativeQuery = true)
    User findUserByName(String username);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users (company,date_of_birth,is_business_account,name,password,role) " +
            "VALUES (?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    void addUser(String company, String date_of_birth,
                 Boolean is_business_account, String name, String password, String role);
}
