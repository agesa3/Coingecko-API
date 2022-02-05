package com.agesadev.palmpay.controller;

import com.agesadev.palmpay.model.Coin;
import com.agesadev.palmpay.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Objects;

public class CoinRestClient {

    @Autowired
    public CoinRepository coinRepository;


    public static final String GET_COINS_LIST = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=1&page=1&sparkline=false";
    private static RestTemplate restTemplate = new RestTemplate();
    private static final String TEST_USER = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {
        CoinRestClient coinRestClient = new CoinRestClient();
        coinRestClient.getCoinsList();
        coinRestClient.saveCoinsList();
    }

    public void getCoinsList() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<Coin[]> response = restTemplate.exchange(GET_COINS_LIST, HttpMethod.GET, entity, Coin[].class);
        Coin[] coins = response.getBody();
        System.out.println(Arrays.toString(coins));
    }

    //save the response to mysql database
    public void saveCoinsList() {
        Coin coin = new Coin();
        coin.setId("1");
        coin.setName("bitcoin");
        coin.setSymbol("btc");
        coin.setImage("testimage");
        coin.setCurrent_price((long) 1.0);
        coin.setMarket_cap((long) 1.0);
        coin.setMarket_cap_rank((int) 1.0);
        coin.setFully_diluted_valuation((long) 1.0);
        coin.setTotal_volume((long) 1.0);
        coin.setHigh_24h((long) 1.0);
        coin.setLow_24h((long) 1.0);
        coin.setPrice_change_24h((long) 1.0);
        coin.setPrice_change_percentage_24h((long) 1.0);
        coin.setMarket_cap_change_24h((long) 1.0);
        coin.setMarket_cap_change_percentage_24h((long) 1.0);
        coin.setCirculating_supply((long) 1.0);
        coin.setTotal_supply((long) 1.0);
        coin.setMax_supply((long) 1.0);
        coin.setAth((long) 1.0);
        coin.setAth_change_percentage((long) 1.0);
        coin.setAth_date("testdate");
        coin.setAtl((long) 1.0);
        coin.setAtl_change_percentage((long) 1.0);
        coin.setAtl_date("testdate");
        coin.setLast_updated("testdate");
        coin.setRoi("testroi");

        coinRepository.save(coin);


    }


}

