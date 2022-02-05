package com.agesadev.palmpay.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embedded;
import java.util.List;


@ToString
@Data
@Getter
@Setter
public class Coin {
    private String id;
    private String symbol;
    private String name;
    private String image;
    private Long current_price;
    private Long market_cap;
    private int market_cap_rank;
    private Long fully_diluted_valuation;
    private Long total_volume;
    private double high_24h;
    private double low_24h;
    private double price_change_24h;
    private double price_change_percentage_24h;
    private Long market_cap_change_24h;
    private double market_cap_change_percentage_24h;
    private double circulating_supply;
    private double total_supply;
    private double max_supply;
    private double ath;
    private double ath_change_percentage;
    private String ath_date;
    private double atl;
    private double atl_change_percentage;
    private String atl_date;
    private String last_updated;
    @Embedded
    private Roi roi;



}
