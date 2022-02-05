package com.agesadev.palmpay.service;

import com.agesadev.palmpay.model.Coin;
import com.agesadev.palmpay.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {
    @Autowired
    public CoinRepository coinRepository;

    // save coin to db
    public String saveCoin(Coin coin) {
        coinRepository.save(coin);
        return "Coin saved";
    }

    public Iterable<Coin> save(List<Coin> coins) {
        return (Iterable<Coin>) coinRepository.save((Coin) coins);
    }

    //    get coin from db
    public Coin getCoin(String id) {
        return coinRepository.findById(id).get();
    }
    //get all coins from db
    public Iterable<Coin> getAllCoins(){
        return coinRepository.findAll();
    }
}
