
package com.application.bookstore.model;
import com.application.bookstore.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * @NoArgsConstructor: Annotations to generate NoArgument Constructor
 * @AllArgsConstructor: Annotations to generate All Arguments Constructor
 * @Data : To Generate Getters and Setters
 * @Table : Declaring Table Name
 * @Entity : For Creating Object
 */

//@NoArgsConstructor
//@Data
//@AllArgsConstructor
@Entity
@Table(name = "user_list")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    private String mobileNumber;
    private String password;
    private String email;

    public User(UserDTO userDTO){
        this.updateUser(userDTO);
    }

    

    
    public User() {
		super();
	}




	public User(Long iD, String mobileNumber, String password, String email) {
		super();
		this.iD = iD;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.email = email;
	}



	/*
     * Method to intialise Details
     * @param userDTO
     */

    public void updateUser(UserDTO userDTO){
        this.mobileNumber= userDTO.getMobileNumber();
        this.password= userDTO.getPassword();
        this.email=userDTO.getEmail();
    }




	public Long getiD() {
		return iD;
	}




	public void setiD(Long iD) {
		this.iD = iD;
	}




	public String getMobileNumber() {
		return mobileNumber;
	}




	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}
    
    
}

