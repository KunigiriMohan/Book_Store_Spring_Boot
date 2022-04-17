package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : To auto Generate Getters and Setters
 * @NoArgumentConstructor : To Generate No Argument Constructer
 * @AllArgumentConstructor : To Generate All Argument Constructer
 */
/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class UserDTO {
    private String mobileNumber;
    private String password;
    private String email;
    
    
    
	public UserDTO() {
		super();
	}


	public UserDTO(String mobileNumber, String password, String email) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.email = email;
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