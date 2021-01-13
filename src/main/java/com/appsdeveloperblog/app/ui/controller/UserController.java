package com.appsdeveloperblog.app.ui.controller;

import com.appsdeveloperblog.app.exceptions.UserServiceException;
import com.appsdeveloperblog.app.ui.model.response.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;
import org.apache.catalina.User;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http:localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(@RequestParam(value="page") int page, @RequestParam(value="limit") int limit) {
        return "Get user was called with page = " + page + " and limit =" + limit;
    }

    @GetMapping(path="/{userId}")
    public ResponseEntity getUser(@PathVariable String userId) {

        //if(true) throw new UserServiceException("A user service exception is thrown");

        String f = null;
        int len = f.length();
        UserRest returnValue = new UserRest();
        returnValue.setEmail("aadil@gmail.com");
        returnValue.setFirstName("aadil");
        returnValue.setLastName("khan");

        return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
