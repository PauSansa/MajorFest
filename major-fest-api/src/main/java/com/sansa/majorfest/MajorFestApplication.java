package com.sansa.majorfest;


import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import io.github.cdimascio.dotenv.DotenvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class MajorFestApplication {

    public static void main(String[] args) {
        try {
            Set<DotenvEntry> dotenvEntries = Dotenv.configure().load().entries();
            if(dotenvEntries != null) {
                dotenvEntries.forEach((entry) -> {
                    // Añade cada variable de entorno al entorno del sistema
                    System.setProperty(entry.getKey(),entry.getValue());
                });
            }
        } catch (DotenvException e) {
            System.out.println(".env file not found");
        }

        SpringApplication.run(MajorFestApplication.class, args);
    }

}
