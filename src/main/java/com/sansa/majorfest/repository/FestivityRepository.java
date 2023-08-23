package com.sansa.majorfest.repository;

import com.sansa.majorfest.document.FestivityDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FestivityRepository extends MongoRepository<FestivityDocument, UUID> {
}
