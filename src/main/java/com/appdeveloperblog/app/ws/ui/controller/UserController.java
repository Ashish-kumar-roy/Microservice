package com.appdeveloperblog.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdeveloperblog.app.ws.ui.model.request.UserDetailRequestModel;
import com.appdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appdeveloperblog.app.ws.userservice.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	Map<String, UserDetailRequestModel> users;

	@Autowired
	UserRest userRest;
	@Autowired
	UserDetailRequestModel userDetailRequestModelObj;
	@Autowired
	UserService userService;

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit) {

		return "get user was called with page = " + page + " and Limit =" + limit;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetailRequestModel> getUser(@PathVariable String userId) {
        
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetailRequestModel> createUser(
			@Valid @RequestBody UserDetailRequestModel userDetailRequestModel) {

		userDetailRequestModelObj= userService.createUser(userDetailRequestModel);
		return new ResponseEntity<UserDetailRequestModel>(userDetailRequestModelObj, HttpStatus.CREATED);

	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserDetailRequestModel updateUser(@PathVariable String userId,
			@RequestBody UserDetailRequestModel userDetailRequestModel) {

		UserDetailRequestModel updateUserDetailRequestModel = users.get(userId);

		updateUserDetailRequestModel.setFirstname(userDetailRequestModel.getFirstname());
		updateUserDetailRequestModel.setLastname(userDetailRequestModel.getLastname());

		return updateUserDetailRequestModel;

	}

	@DeleteMapping(path = "{Id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String Id) {

		users.remove(Id);

		return ResponseEntity.noContent().build();

	}

}
