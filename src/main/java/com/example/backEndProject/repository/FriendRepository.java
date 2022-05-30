package com.example.backEndProject.repository;

import com.example.backEndProject.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO friends (company,date_of_birth,is_business_account,name,role)" +
            "VALUES (?1,?2,?3,?4,?5)",nativeQuery = true)
    void addFriend(String company, String date_of_birth, boolean isBusinessAccount, String name, String role);
}
