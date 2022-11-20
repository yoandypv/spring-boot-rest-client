package com.yoandypv.restclientsamples.service.dto.user.login;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}
