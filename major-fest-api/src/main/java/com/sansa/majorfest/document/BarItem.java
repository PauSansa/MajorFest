package com.sansa.majorfest.document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BarItem {
    private String name;
    private float value;
}
