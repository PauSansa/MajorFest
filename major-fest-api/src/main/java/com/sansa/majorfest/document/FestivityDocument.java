package com.sansa.majorfest.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Document(collection = "festivity")
public class FestivityDocument {
    @MongoId
    private UUID uuid;
    private String name;
    private String location;
    private String image;
    private String description;
    private List<LocalDate> date;
    private List<BarItem> barItems;
    private List<Concert> concerts;
}
