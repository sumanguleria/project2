package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.dao.UserDAO;
import com.web.model.User;
import com.web.model.UserAdmin;
import com.web.model.UserRole;


@RestController
public class MainController {


//	
//	@Autowired 
//	UserDAO userDao;
//	
//	@Autowired
//	UserRole userRole;
//	
//	
//    @RequestMapping(value = "/add/", method = RequestMethod.GET)
//    public ResponseEntity<User>  addUser() {
//	try{
//		User u= new User();
//
//      u.setEmail("vish@"); 
//      u.setPassword("0029"); 
//        u.setUserName("suman");
//		u.setLocation("chd");
//
//      userDao.addUser(u);
//		System.out.println("data saved");
//	}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//	}
//		return new ResponseEntity<User>(HttpStatus.OK);
//	}
// 
//	
//    
//    @PostMapping(value = "/users")
//	public ResponseEntity createUser(@RequestBody User userDetails) {
//
//		userDao.addUser(userDetails);
//		System.out.println(" data saved");
//
//        return new ResponseEntity(userDetails, HttpStatus.OK);
//	}
//    
//	 @RequestMapping(value = "/view/", method = RequestMethod.GET)
//	    public ResponseEntity<List<User>> listAllUsers() {
//	        List<User> users = userDao.viewALL();
//	        System.out.println(users);
//	        if(users.isEmpty()){
//	            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//	        }
//	        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//	    }
//	
//	
//	
}
