package com.letkeman.backend.controller;

import com.letkeman.backend.model.api.ApplicationUser;
import com.letkeman.backend.model.api.UserRequest;
import com.letkeman.backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(
            value = "/letkeman/api/users",
            produces = "application/json")
    public ResponseEntity<ApplicationUser> createUser(@RequestBody UserRequest requestBody){
        ApplicationUser applicationUser = authenticationService.createUser(requestBody);
        return ResponseEntity.ok().body(applicationUser);
    }
    @GetMapping(
            value = "/letkeman/api/users/{id}",
            produces = "application/json")
    public ResponseEntity<ApplicationUser> getUser(@PathVariable Long id){
        ApplicationUser applicationUser = authenticationService.getUser(id);
        return ResponseEntity.ok().body(applicationUser);
    }
}
