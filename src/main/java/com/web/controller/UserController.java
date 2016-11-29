package com.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.web.dao.UserDAO;
import com.web.model.User;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	
//	@Autowired
//	User user;
	
	
	@Autowired
	private UserDAO userDAO;

	

	@GetMapping("/users/")
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userDAO.list();
		System.out.println(users);
		if (users.isEmpty()) {
			//user.setErrorCode("404");
			//user.setErrorMessage("No user Available");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);// You
		}																// many
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);																// decide
																			// to
	}																		// return
																			// HttpStatus.NOT_FOUND
		
		
	

	@GetMapping("/user/{id}")
	public ResponseEntity getUser(@PathVariable("id") String id) {

		User user = userDAO.get(id);
		if (user == null) {
			
			//user.setErrorCode("404");
			//user.setErrorMessage("no user is esist"+id);
			return new ResponseEntity("No UserDetails found for ID " + id, HttpStatus.NOT_FOUND);
		}	

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
//===========================Register=======================================
	@PostMapping(value = "/register/")
	public ResponseEntity<User> register(@RequestBody User user) {

		if (userDAO.get(user.getId()) != null) {
            user.setErrorCode("404");
            user.setErrorMessage("Record is already exist  choose another id ");
          
		} else {
			if (userDAO.save(user)) {
			  user.setErrorCode("200");
			  user.setErrorMessage("Regisster successfully");
			} 
			else 
			{
				user.setErrorCode("405");
			    user.setErrorMessage("unablw to process your request , contact admin");
		}
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	
	@RequestMapping(value="validate/",method=RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user,HttpSession session)
	{
		if(userDAO.validate(user.getId(), user.getPassword())==null)
		{
			//user.setEmail("404");
			//user.setErrorMessage("User not exist with this id");
		}
		else
		{
			//user.setIsOnline("Y");
			userDAO.update(user);
			//session.setAttribute("loggedInUserID", user.getId());
			
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
//	@RequestMapping(value="logout/",method=RequestMethod.GET)
//	public ResponseEntity<User> logout(HttpSession session)
//	{
//		//user.setIsOnline("N");
//		session.invalidate();
//		if(userDAO.update(user))
//		{
//			user.setErrorCode("200");
//			user.setErrorMessage("Logout successfully");
//		}
//		else
//		{
//			user.setErrorCode("404");
//			user.setErrorMessage("you could not logout, please contact admin");
//		}	
//		
//		return new ResponseEntity<User>(user,HttpStatus.OK);
//	}
//	
//	
//	
	
	
//	@DeleteMapping("/users/{id}")
//	public ResponseEntity deleteUser(@PathVariable String id) {
//
//		if (null == userDetailsDAO.get(id)) {
//			return new ResponseEntity("No UserDetails found for ID " + id, HttpStatus.NOT_FOUND);
//		}
//		userDetailsDAO.deleteUserById(id);
//		return new ResponseEntity(id, HttpStatus.OK);
//
//	}

//	@PutMapping("/users/{id}")
//	public ResponseEntity updateUser(@PathVariable String id, @RequestBody User user) {
//
//		if (null == userDetailsDAO.get(id)) {
//			return new ResponseEntity("No UserDetails found for ID " + id, HttpStatus.NOT_FOUND);
//		}
//		userDetailsDAO.addUser(user);
//		return new ResponseEntity(user, HttpStatus.OK);
//	}
//
}
