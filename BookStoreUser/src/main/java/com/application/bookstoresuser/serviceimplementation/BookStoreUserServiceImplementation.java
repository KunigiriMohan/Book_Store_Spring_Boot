package com.application.bookstoresuser.serviceimplementation;

import com.application.bookstoresuser.dto.UserDTO;
import com.application.bookstoresuser.exception.BookStoreException;
import com.application.bookstoresuser.exception.UserNotFoundException;
import com.application.bookstoresuser.model.Detail;
import com.application.bookstoresuser.model.User;
import com.application.bookstoresuser.repository.BookStoreUserEntity;
import com.application.bookstoresuser.repository.BookStoreUserRepository;
import com.application.bookstoresuser.service.BookStoreUserService;
import com.application.bookstoresuser.utility.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * @Override : Overriding implemented methods from interface
 */
@Service
public class BookStoreUserServiceImplementation implements BookStoreUserService {

    /**
     * Autowiring to Save Data in Repository
     */
    @Autowired
    BookStoreUserRepository bookStoreUserRepository;

    @Autowired
    BookStoreUserEntity bookStoreUserEntity;
    /**
     * Autowiring JwtTokenUtil to Creating Token
     */
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * implementing method creatingUser in DB
     */


    @Override
    public User createUser(User user){
        if(bookStoreUserRepository.findAll().size()==0){
            return bookStoreUserRepository.save(user);
        }
        else{
            User userDetails=bookStoreUserRepository.getUserDetailsbyMobileandEmail(user.getMobileNumber(), user.getEmail());
            if(userDetails==null){
                return bookStoreUserRepository.save(user);
            }
            else{
                throw new BookStoreException("User Already Registered Login with your credentials");
            }
        }
    }
    //@Override
    /*public User createUser(User user){
        if(bookStoreUserRepository.findAll().size()==0){
            return bookStoreUserRepository.save(user);
        }
        else{
            User userDetails;
            try{
                userDetails = bookStoreUserEntity.getUserByEmailAndMobile(user);
            }
            if(userDetails==null){
                return bookStoreUserRepository.save(user);
            }
            else{
                throw new BookStoreException("User Already Present");
            }
        }
    }*/

    /**
     * implementing method generatingToken
     */
    @Override
    public Detail generateToken(User user) {
        User userDetails;
        try{
            userDetails = bookStoreUserEntity.loginUser(user);
            System.out.println(userDetails);
            if(userDetails==null){
                throw new UserNotFoundException("User Not Found");
            }
            else {
                Detail detail = new Detail(jwtTokenUtil.generateToken(userDetails.getMobileNumber()), userDetails.getID());
                return detail;
            }
        }catch (Exception e){
            System.out.println(e);
            throw new UserNotFoundException("User Not found check details");
        }
    }




    /**
     * Method to Delete User by id
     * @param id
     */
    @Override
    public void deletebyID(Long id) {
        try {
            bookStoreUserRepository.deleteById(id);
        }catch (Exception exception){
            throw new UserNotFoundException("User Not Found ");
        }
    }

    /**
     * Method to update User Details
     * @param id
     * @param userDTO
     * @return : Stored User Object
     */
    @Override
    public Object updateUser(Long id,  User user) {
        /*try{
            User user1 = bookStoreUserRepository.getById(id);
            //user.updateUser(userDTO);
            return bookStoreUserRepository.save(user1);
        }catch (Exception exception){
            throw new UserNotFoundException("User Not Found ");
        }*/
        return bookStoreUserRepository.updateUserDetails(user.getName(),user.getMobileNumber(),user.getPinCode(),user.getLocality(),user.getAddress(),user.getCity(),user.getLandmark(),id);
    }

    /**
     * Method to get User by userid
     * @param id
     * @return : User details of that userid
     */
    @Override
    public User getUserByID(Long id) {
        try{
            return bookStoreUserRepository.findById(id).get();
        }catch (Exception exception){
            throw new UserNotFoundException("User Not Found ");
        }
    }
}
