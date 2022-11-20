package com.yoandypv.restclientsamples.service;


import com.yoandypv.restclientsamples.service.dto.user.login.LoginRequest;
import com.yoandypv.restclientsamples.service.dto.user.login.LoginResponse;
import com.yoandypv.restclientsamples.service.dto.user.register.RegisterUserRequest;
import com.yoandypv.restclientsamples.service.dto.user.register.RegisteredUserResponse;

public interface UserService {
    RegisteredUserResponse create(RegisterUserRequest user);
    LoginResponse login(LoginRequest loginRequest);
}
