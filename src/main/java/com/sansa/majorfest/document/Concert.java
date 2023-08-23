package com.sansa.majorfest.document;

import lombok.Data;

import java.util.Date;

@Data
public class Concert {
    private String name;
    private Date startTime;
    private Date endTime;
}
