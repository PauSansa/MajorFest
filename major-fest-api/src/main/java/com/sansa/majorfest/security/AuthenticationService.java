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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class AuthenticationService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserToDto userToDto;

    public UserDto createUser(RegisterRequest request){

        UserDocument user = UserDocument.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .createdAt(new Date())
                .role(Role.USER)
                .build();

        UserDocument savedUser = userRepository.save(user);

        return userToDto.apply(savedUser);
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
