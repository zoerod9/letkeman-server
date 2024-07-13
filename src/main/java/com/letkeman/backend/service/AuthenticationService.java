package com.letkeman.backend.service;

import com.letkeman.backend.model.api.ApplicationUser;
import com.letkeman.backend.model.api.UserRequest;
import com.letkeman.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    public ApplicationUser createUser(UserRequest requestBody) {

        Optional<ApplicationUser> existingUser = userRepository.findByUsername(requestBody.getUsername());

        if(existingUser.isPresent()){
            throw new RuntimeException("username already exists");
        }

        return userRepository.save( new ApplicationUser(null, requestBody.getUsername(), requestBody.getEmail(), requestBody.getPassword()));

    }

    public ApplicationUser getUser(Long id) {
        return userRepository.findById(id).get();
    }
}
