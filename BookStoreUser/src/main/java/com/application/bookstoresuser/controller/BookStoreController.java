package com.application.bookstoresuser.controller;

import com.application.bookstoresuser.dto.UpdateUserData;
import com.application.bookstoresuser.model.Detail;
import com.application.bookstoresuser.model.User;
import com.application.bookstoresuser.service.BookStoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
/**
 * @RestController : Defining Class as a RestController
 * @RequestMapping : Defining path of URL
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @PutMapping : Defining URL Path of API which perform PUT operation
 * @DeleteMapping : Defining URL Path of API which perform DELETE opertion
 * @Autowired : Dependency Injection
 */
@CrossOrigin
@RestController
public class BookStoreController {
    /**
     * Autowiring for Dependency Injection
     */
    @Autowired
    BookStoreUserService bookStoreUserService;

    /**
     * API for registering User for App
     * @param user
     * @return : Creating User Data
     */
    @PostMapping("/registeruser")
    public User generateUser(@RequestBody User user){
        //System.out.println(user);
        return bookStoreUserService.createUser(user);
    }


    /**
     * API for Login User
     * @param user
     * @return : token
     */
    @PostMapping("/login")
    public Detail loginUser(@RequestBody User user){
        return bookStoreUserService.generateToken(user);
    }

    /**
     * API for Delete User by id
     * @param id
     * @throws EmptyResultDataAccessException
     */
    @DeleteMapping("/deletebyid/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws EmptyResultDataAccessException {
        bookStoreUserService.deletebyID(id);
    }

    //
    /**
     * API for update user
     * @param updateUserData
     * @return : object of user details
     */
    @PutMapping("updateuser/{id}")
    public Object updateUser(@RequestBody User user,@PathVariable("id") Long id){
        System.out.println(id);
        System.out.println(user);
        return bookStoreUserService.updateUser(id,user);
    }

    @GetMapping("/getuserbyid/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return bookStoreUserService.getUserByID(id);
    }
}
