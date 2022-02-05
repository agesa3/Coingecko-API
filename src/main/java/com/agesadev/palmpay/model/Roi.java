package com.agesadev.palmpay.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Roi {
    private double times;
    private String currency;
    private double percentage;
}
