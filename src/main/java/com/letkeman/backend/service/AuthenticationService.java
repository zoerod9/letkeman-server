package com.letkeman.backend.service;

import com.letkeman.backend.model.api.User;
import com.letkeman.backend.model.api.UserRequest;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AuthenticationService {


    public User createUser(UserRequest requestBody) {
        return new User(requestBody.getUsername(),requestBody.getEmail());
    }
}
