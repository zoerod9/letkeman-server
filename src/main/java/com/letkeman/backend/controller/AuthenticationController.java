package com.letkeman.backend.controller;

import com.letkeman.backend.model.api.User;
import com.letkeman.backend.model.api.UserRequest;
import com.letkeman.backend.service.AuthenticationService;
import jakarta.ws.rs.Produces;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(
            value = "/letkeman/api/users",
            produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody UserRequest requestBody){
        User user = authenticationService.createUser(requestBody);
        return ResponseEntity.ok().body(user);
    }
}
