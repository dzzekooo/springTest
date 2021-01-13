package com.appsdeveloperblog.app.ws.userservice;

import com.appsdeveloperblog.app.ui.model.response.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
