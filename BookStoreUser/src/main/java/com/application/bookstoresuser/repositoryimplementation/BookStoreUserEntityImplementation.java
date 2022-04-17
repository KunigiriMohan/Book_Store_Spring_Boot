package com.application.bookstoresuser.repositoryimplementation;

import com.application.bookstoresuser.model.User;
import com.application.bookstoresuser.repository.BookStoreUserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class BookStoreUserEntityImplementation implements BookStoreUserEntity {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User loginUser(User user) {
        System.out.println(user);
        String query = "select user from User user where user.email=:emailAddress and user.password=:pass";
        Query query1 = entityManager.createQuery(query).setParameter("emailAddress",user.getEmail())
                .setParameter("pass",user.getPassword());

        return (User) query1.getSingleResult();
    }

    /*@Override
    @Transactional
    @Modifying
    public Object updateUserDetails(User user,Long id) {
        String query = "update User u set u.name=:userName, u.mobileNumber=:userMobile,u.pinCode=:userPinCode,u.locality=:userLocality,u.address=:userAddress,u.city=:userCity,u.landmark=:userLandmark where u.iD=:userId";
        Query query1 = entityManager.createQuery(query).setParameter("userName",user.getName())
                .setParameter("userMobile",user.getMobileNumber()).setParameter("userPinCode",user.getPinCode()).setParameter("userLocality",user.getLocality()).setParameter("userAddress",user.getAddress()).setParameter("userCity",user.getCity()).setParameter("userLandmark",user.getLandmark()).setParameter("userId",id);

        return query1.getSingleResult();
    }*/
}
