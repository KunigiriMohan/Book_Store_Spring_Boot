package com.application.bookstoresuser.repository;

import com.application.bookstoresuser.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookStoreUserEntity {
    User loginUser(User user);
   /* @Modifying
    @Transactional
    Object updateUserDetails(User user,Long id);*/
}
