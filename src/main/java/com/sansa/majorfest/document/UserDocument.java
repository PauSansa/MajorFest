package com.sansa.majorfest.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.UUID;

@Document
@Data
public class UserDocument {
    @MongoId
    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private String location;
    private Date createdDate;

}
