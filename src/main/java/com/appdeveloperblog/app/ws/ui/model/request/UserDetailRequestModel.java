package com.appdeveloperblog.app.ws.ui.model.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class UserDetailRequestModel {
    @NotNull(message="First Name should not be Empty")
	private String firstname;
    @NotNull(message="Last Name should not be Empty")
	private String lastname;
    @NotNull(message="Email should not be Empty")
    @Email
	private String email;
    @NotNull(message="Password should not be Empty")
	@Size(min=8 , max=16 , message="Password must be greater that or equal 8 and less than 16 character")
	private String password;
    
    private String UserId;
    
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
