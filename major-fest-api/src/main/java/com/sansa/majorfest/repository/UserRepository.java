package com.sansa.majorfest.repository;

import com.sansa.majorfest.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, UUID> {
    UserDocument findByUsername(String username);
}
