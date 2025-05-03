package com.example.demo.service;

import com.example.demo.dto.request.AccountSignUp;
import com.example.demo.dto.request.SignInRequest;
import com.example.demo.dto.response.SignInResponse;

public interface UserService {
    AccountSignUp signUp(AccountSignUp dto);

    SignInResponse signIn(SignInRequest dto);

    void logout(String email);
}
