package com.example.backEndProject.LoginCheckMethod;

import com.example.backEndProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public  class LoginChecker {


    private UserRepository userRepository;

    public LoginChecker() {
    }
    @Autowired
    public LoginChecker(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public boolean userNotLoggedInChecker(String username){



        if(userRepository.findUserByName(username).isUserLoggedIn()==false){



             return true;

        }

        return false;


    }

    public String returnedMessage(){

        return "User not logged in. Please log in to access this feature.";
    }
}
