package com.appsdeveloperblog.app.ws.userservice.impl;

import com.appsdeveloperblog.app.ui.model.response.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        return returnValue;
    }
}
