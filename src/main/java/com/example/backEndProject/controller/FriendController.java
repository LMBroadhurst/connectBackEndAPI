package com.example.backEndProject.controller;

import com.example.backEndProject.model.User;
import com.example.backEndProject.model.dto.UserDto;
import com.example.backEndProject.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FriendController {

    //    INJECTION DEPENDENCIES -- START

    @Autowired
    FriendService friendService;

    @PostMapping("/addFriend/{targetUser}/{friendToAdd}")
    public UserDto addFriend(@PathVariable String targetUser, @PathVariable String friendToAdd) {
        return friendService.addFriend(targetUser, friendToAdd);
    }
//



    //    INJECTION DEPENDENCIES -- END
//
//
    //    FRIEND FEATURES -- START

}
