package com.agesadev.palmpay.controller;

import com.agesadev.palmpay.model.Coin;
import com.agesadev.palmpay.repository.CoinRepository;
import com.agesadev.palmpay.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


public class CoinRestClient {

    @Autowired
    CoinService coinService;

    public static final String GET_COINS_LIST = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=1&page=1&sparkline=false";
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        CoinRestClient coinRestClient = new CoinRestClient();
        coinRestClient.getCoinsList();
        coinRestClient.saveCoinsList();
    }

    //get the coin list from the api
    public void getCoinsList() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<Coin[]> response = restTemplate.exchange(GET_COINS_LIST, HttpMethod.GET, entity, Coin[].class);
        Coin[] coins = response.getBody();
        System.out.println(Arrays.toString(coins));
    }

    //save the coin list to the database
    public void saveCoinsList() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<Coin[]> response = restTemplate.exchange(GET_COINS_LIST, HttpMethod.GET, entity, Coin[].class);
        Coin[] coins = response.getBody();
        for (Coin coin : coins) {
            coinService.save((List<Coin>) coin);
        }
    }


}

