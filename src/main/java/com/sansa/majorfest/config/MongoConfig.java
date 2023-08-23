package com.sansa.majorfest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "my-database";
    }

    @Override
    public MongoClient mongoClient() {
        String mongoDbUrl = System.getenv("MONGO_DB_URL");
        String username = System.getenv("MONGO_DB_USERNAME");
        String password = System.getenv("MONGO_DB_PASSWORD");
        if (mongoDbUrl == null || username == null || password == null) {
            throw new IllegalStateException("MONGO_DB_URL, MONGO_DB_USERNAME and MONGO_DB_PASSWORD must be set");
        }
        return MongoClients.create("mongodb://" + username + ":" + password + "@" + mongoDbUrl);
    }
}

