package com.application.bookstoresuser.service;

import com.application.bookstoresuser.dto.UserDTO;
import com.application.bookstoresuser.model.Detail;
import com.application.bookstoresuser.model.User;

/**
 * Service Layer Interface
 */
public interface BookStoreUserService {
    public User createUser(User user);
    public Detail generateToken(User user);
    public void deletebyID(Long id);
    public Object updateUser(Long id, User user);
    User getUserByID(Long id);
}
