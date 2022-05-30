package com.example.backEndProject.service;

import com.example.backEndProject.model.Post;
import com.example.backEndProject.model.User;
import com.example.backEndProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {


//    DEPENDENCY INJECTION


    private UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


//    DEPENDENCY INJECTION END
//
//
//    SERVICE METHODS START


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public String save(String name,
                       String password,
                       String dob,
                       String company,
                       String role,
                       Boolean isBusinessAccount) {

        if(userRepository.findUserByUsernameAndPassword(name,password) != null){
            return "User already exists";
        }

        userRepository.addUser(company, dob, isBusinessAccount, name, password, role);


        return "User Added";
    }


    public User findById(Long id){
        return userRepository.findByID(id);
    }


    public List<String> searchUsersForKeyword(String keyword) {

//        Gets all users and converts to a stream
//        Extracts the name from each user and maps them
//        Uses to lower case to ensure no name is missed
//        Filter with lambda is dependent on whether name contains the specified keyword
//        Returns list of posts

        List<String> foundUsers = userRepository.findAll().stream()
                .map(user -> user.getName().toLowerCase())
                .filter(s -> s.contains(keyword.toLowerCase()))
                .toList();

        if (foundUsers.isEmpty()) {
            ArrayList<String> noMatches = new ArrayList<>();
            noMatches.add("No users found :(");
            return noMatches;
        }

        return foundUsers;
    }


    public User editName(Long id, String new_name)
            throws NoSuchElementException {

//        Edits already established post by id.
//        Try catch statement for the scenario where id is not found.
//        Created current outside of try catch to ensure it was within scope for the return statement.

        User current = null;
        try {
            current = userRepository.findById(id).get();
            current.setName(new_name);
            userRepository.save(current);

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("No matching post could be found for id: " + id);
        }

        return current;
    }


    public User editCompany(Long id, String new_company)
            throws NoSuchElementException {

//        Edits already established post by id.
//        Try catch statement for the scenario where id is not found.
//        Created current outside of try catch to ensure it was within scope for the return statement.

        User current = null;
        try {
            current = userRepository.findById(id).get();
            current.setCompany(new_company);
            userRepository.save(current);

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("No matching post could be found for id: " + id);
        }

        return current;
    }


    public User editPassword(Long id, String new_password)
            throws NoSuchElementException {

//        Edits already established post by id.
//        Try catch statement for the scenario where id is not found.
//        Created current outside of try catch to ensure it was within scope for the return statement.

        User current = null;
        try {
            current = userRepository.findById(id).get();
            current.setPassword(new_password);
            userRepository.save(current);


        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("No matching post could be found for id: " + id);
        }

        return current;
    }

    public User editDOB(Long id, String new_DOB)
            throws NoSuchElementException {

//        Edits already established post by id.
//        Try catch statement for the scenario where id is not found.
//        Created current outside of try catch to ensure it was within scope for the return statement.

        User current = null;
        try {
            current = userRepository.findById(id).get();
            current.setDate_of_birth(new_DOB);
            userRepository.save(current);


        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("No matching post could be found for id: " + id);
        }

        return current;
    }

    public String logUserIn(String username, String password){

        User resultUser = userRepository.findUserByUsernameAndPassword(username,password);


        if(resultUser!=null && !resultUser.isUserLoggedIn()){

            resultUser.setUserLoggedIn(Boolean.TRUE);
            userRepository.save(resultUser);

            return "User logged in";

        }

        return "User already logged in";



    }

    public String logUserOut(String username, String password){

        User resultUser = userRepository.findUserByUsernameAndPassword(username,password);

        if(resultUser!=null && resultUser.isUserLoggedIn()==true){

            resultUser.setUserLoggedIn(Boolean.FALSE);
            userRepository.save(resultUser);

            return "User logged out";

        }

        return "User already logged out";



    }


//    END OF METHODS
//

//    END OF FILE
}
