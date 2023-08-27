package com.sansa.majorfest.converter;

import com.sansa.majorfest.document.UserDocument;
import com.sansa.majorfest.document.UserDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserToDto implements Function<UserDocument, UserDto> {
    @Override
    public UserDto apply(UserDocument userDocument) {
        return UserDto.builder()
                .uuid(userDocument.getUuid())
                .name(userDocument.getName())
                .email(userDocument.getEmail())
                .location(userDocument.getLocation())
                .createdAt(userDocument.getCreatedAt())
                .username(userDocument.getUsername())
                .build();
    }
}
