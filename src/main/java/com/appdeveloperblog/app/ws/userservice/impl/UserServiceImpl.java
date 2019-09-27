package com.appdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdeveloperblog.app.ws.shared.Utill;
import com.appdeveloperblog.app.ws.ui.model.request.UserDetailRequestModel;
import com.appdeveloperblog.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDetailRequestModel userDetailRequestModelObj;
	
	Utill utills;
	
	Map<String, UserDetailRequestModel> users;
	
	@Autowired
	public UserServiceImpl(Utill utill) {
		this.utills=utill;
	}
	
	public UserServiceImpl() {
		
	}

	@Override
	public UserDetailRequestModel createUser(UserDetailRequestModel userDetailRequestModel) {
		userDetailRequestModelObj.setEmail(userDetailRequestModel.getEmail());
		userDetailRequestModelObj.setFirstname(userDetailRequestModel.getFirstname());
		userDetailRequestModelObj.setLastname(userDetailRequestModel.getLastname());
		userDetailRequestModelObj.setPassword(userDetailRequestModel.getPassword());

		String userId = utills.generateId();
		userDetailRequestModelObj.setUserId(userId);

		if (users == null)
			users = new HashMap<>();
		users.put(userId, userDetailRequestModelObj);
		
		return userDetailRequestModelObj;
	}

}
