package com.example.backEndProject.service;

import com.example.backEndProject.model.Friend;
import com.example.backEndProject.model.User;
import com.example.backEndProject.model.dto.UserDto;
import com.example.backEndProject.repository.FriendRepository;
import com.example.backEndProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendService {

    //    DEPENDENCIES INJECTIONS -- START

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    UserRepository userRepository;


        public UserDto addFriend(String targetUser, String friendToAdd) {

            User userT = userRepository.findUserByName(targetUser);
            User userF = userRepository.findUserByName(friendToAdd);
            Friend friendLF = new Friend(userF.getId(), userF.getName(), userF.getCompany(), userF.getRole(), userF.getDate_of_birth(), userF.isBusinessAccount());

            //creating two new Users - userT (the target user, who's list we want to update) and the userF (friend to be added)
            //creating two new Friends - friendLT and friendLF for the corresponding users 
            //the friend objects call getters from the corresponding user class

            friendRepository.save(friendLF);

            //saving friendLT and friendLF to the repository, containing the data of the friend to add

            userT.setFriendList(friendLF);

            //setting the friend list of userT to the user info stored in friendL

            User updateUserT = userRepository.save(userF);

            //saving the updated friendList of userT and userF to the userRepo

            UserDto userDto = new UserDto(updateUserT.getId(), updateUserT.getName(), updateUserT.getCompany(), updateUserT.getRole(), updateUserT.getDate_of_birth(), updateUserT.isBusinessAccount());


            //user Dto objects created for userT AND userF to transfer the info between API and server using friend repo...

            friendRepository.addFriend(userDto.getCompany(), userDto.getDate_of_birth(), userDto.isBusinessAccount(), userDto.getName(), userDto.getRole());

            // using the userDTO to grab values from user

            return userDto;

        }
}



    //    DEPENDENCIES INJECTIONS -- END
//
//
    //    FRIENDS METHODS -- START



