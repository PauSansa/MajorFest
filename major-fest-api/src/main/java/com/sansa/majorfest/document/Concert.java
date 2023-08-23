package com.sansa.majorfest.document;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Concert {
    private String name;
    private Date startTime;
    private Date endTime;
}
