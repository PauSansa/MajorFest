package com.sansa.majorfest.controller;

import com.sansa.majorfest.payload.AuthResponse;
import com.sansa.majorfest.payload.LoginRequest;
import com.sansa.majorfest.payload.RegisterRequest;
import com.sansa.majorfest.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse authResponse = authService.authenthicate(loginRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
        AuthResponse authResponse = authService.createUser(registerRequest);
        return ResponseEntity.ok(authResponse);
    }

    @GetMapping("/prueba")
    public String prueba(){
        return "prueba";
    }
}
