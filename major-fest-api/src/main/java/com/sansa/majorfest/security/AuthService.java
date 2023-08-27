package com.sansa.majorfest.security;


import com.sansa.majorfest.converter.UserToDto;
import com.sansa.majorfest.document.UserDocument;
import com.sansa.majorfest.document.UserDto;
import com.sansa.majorfest.payload.AuthResponse;
import com.sansa.majorfest.payload.LoginRequest;
import com.sansa.majorfest.payload.RegisterRequest;
import com.sansa.majorfest.repository.UserRepository;
import com.sansa.majorfest.security.jwt.JwtService;
import com.sansa.majorfest.document.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserToDto userToDto;

    public AuthResponse createUser(RegisterRequest request){

        UserDocument user = UserDocument.builder()
                .uuid(UUID.randomUUID())
                .name(request.getName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .location(request.getLocation())
                .createdAt(new Date())
                .role(Role.USER)
                .build();

        UserDocument savedUser = userRepository.save(user);
        UserDto userDto = userToDto.apply(savedUser);


        return AuthResponse.builder()
                .user(userDto)
                .token(jwtService.generateToken(savedUser, new HashMap<>()))
                .build();
    }

    public AuthResponse authenthicate(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        UserDocument user = userRepository.findByUsername(request.getUsername());
        String token = jwtService.generateToken(user, new HashMap<>());
        return AuthResponse.builder()
                .user(userToDto.apply(user))
                .token(token)
                .build();

    }
}
