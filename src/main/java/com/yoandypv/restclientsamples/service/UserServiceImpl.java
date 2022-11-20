package com.yoandypv.restclientsamples.service;

import com.yoandypv.restclientsamples.service.dto.user.login.LoginRequest;
import com.yoandypv.restclientsamples.service.dto.user.login.LoginResponse;
import com.yoandypv.restclientsamples.service.dto.user.register.RegisterUserRequest;
import com.yoandypv.restclientsamples.service.dto.user.register.RegisteredUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserServiceImpl extends AbstractClient implements UserService {

    public UserServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }
    @Override
    public RegisteredUserResponse create(RegisterUserRequest user) {
        String uri = baseUrl + "/user";
        log.info("Going to create {}", user);
        ResponseEntity<RegisteredUserResponse> response = restTemplate.postForEntity(uri, user, RegisteredUserResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Successfully user creation: {}", response.getBody().getStatus());
            return response.getBody();
        }
        log.error("Error in user creation - httpStatus was: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        String uri = baseUrl + "/user/login";
        log.info("Going to login {}", loginRequest);
        ResponseEntity<LoginResponse> response = restTemplate.postForEntity(uri, loginRequest, LoginResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Successfully user creation: {}", response.getBody().getStatus());
            return response.getBody();
        }
        log.error("Error in user login - httpStatus was: {}", response.getStatusCode());
        throw new RuntimeException("Error");

    }
}
