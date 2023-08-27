package com.sansa.majorfest.document;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class UserDto {private UUID uuid;
    private String name;
    private String username;
    private String email;
    private String location;
    private Date createdAt;
}
