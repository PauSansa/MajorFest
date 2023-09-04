package com.sansa.majorfest.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.bson.UuidRepresentation;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        String dbName = System.getProperty("MONGO_DB_DATABASE");
        if(dbName == null){
            throw new IllegalStateException("MONGO_DB_DATABASE must be set");
        }
        return dbName;
    }

    @Override
    public MongoClient mongoClient() {

        String mongoDbUrl = System.getProperty("MONGO_DB_URL");
        String username = System.getProperty("MONGO_DB_USERNAME");
        String password = System.getProperty("MONGO_DB_PASSWORD");

        if (mongoDbUrl == null || username == null || password == null) {
            throw new IllegalStateException("MONGO_DB_URL, MONGO_DB_USERNAME and MONGO_DB_PASSWORD must be set");
        }

        String uri = "mongodb://" + username + ":" + password + "@" + mongoDbUrl;

        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build();

        return MongoClients.create(settings);
    }
}

