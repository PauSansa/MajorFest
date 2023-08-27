package com.sansa.majorfest.payload;

import com.sansa.majorfest.document.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    private String token;
    private UserDto user;
}
