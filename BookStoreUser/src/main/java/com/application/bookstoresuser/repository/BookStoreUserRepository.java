package com.application.bookstoresuser.repository;

import com.application.bookstoresuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Repository : Creating Repository
 */
@Repository
public interface BookStoreUserRepository extends JpaRepository<User,Long> {
    @Query("select user from User user where user.mobileNumber=:userMobile or user.password=:pass")
    public User getUserDetails(@Param("userMobile") String mobileNumber, @Param("pass") String password);

    //it is getting user by password match sir
    //i need to change that sir
    @Query("select user from User user where user.email=:emailAddress and user.mobileNumber=:mobile")
    //@Query("select user from User user where user.mobileNumber=:userMobile")
    public User getUserDetailsbyMobileandEmail(@Param("mobile") String mobile,@Param("emailAddress") String emailAddress);

    @Query("select user from User user where user.email=:emailAddress")
    User findByEmail(@Param("emailAddress") String email);


    @Transactional
    @Modifying
    @Query("update User u set u.name=:userName, u.mobileNumber=:userMobile,u.pinCode=:userPinCode,u.locality=:userLocality,u.address=:userAddress,u.city=:userCity,u.landmark=:userLandmark where u.iD=:userId")
    Object updateUserDetails(@Param("userName") String name,@Param("userMobile") String mobile,@Param("userPinCode") String pinCode,@Param("userLocality") String locality,@Param("userAddress") String userAddress,@Param("userCity") String city,@Param("userLandmark") String landmark,@Param("userId") Long iD);
}
