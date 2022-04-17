package com.application.bookstoresuser.model;

import com.application.bookstoresuser.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * @NoArgsConstructor: Annotations to generate NoArgument Constructor
 * @AllArgsConstructor: Annotations to generate All Arguments Constructor
 * @Data : To Generate Getters and Setters
 * @Table : Declaring Table Namef
 * @Entity : For Creating Object
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "user_list")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    private String name;
    private String mobileNumber;
    private String password;
    private String email;
    private String city;
    private String landmark;
    private String locality;
    private String address;
    private String pinCode;
    private String country;


    public User(UserDTO userDTO){
        this.updateUser(userDTO);
    }

    /**
     * Method to intialise Details
     * @param userDTO
     */
    public void updateUser(UserDTO userDTO){
        this.mobileNumber= userDTO.getMobileNumber();
        this.password= userDTO.getPassword();
        this.email=userDTO.getEmail();
        this.name=userDTO.getName();
        this.landmark=userDTO.getLandmark();
        this.locality=userDTO.getLocality();
        this.address=userDTO.getAddress();
        this.pinCode=userDTO.getPinCode();
        this.city=userDTO.getCity();
        this.country=userDTO.getCountry();
    }
}
