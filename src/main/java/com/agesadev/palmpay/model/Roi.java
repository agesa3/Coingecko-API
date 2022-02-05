package com.agesadev.palmpay.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Embeddable;

@Data
@ToString
@Embeddable
public class Roi {
    private double times;
    private String currency;
    private double percentage;
}
