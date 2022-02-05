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

    //get coin list
    public List<Coin> getCoins() {
        return coinRepository.findAll();
    }

    //save coin to db
    public Coin saveCoin(Coin coin) {
        return coinRepository.save(coin);
    }

    //update coin
    public Coin updateCoin(Coin coin) {
        return coinRepository.save(coin);
    }

    //get coin by id
    public Coin getCoinById(String id) {
        return coinRepository.findById(id).get();
    }

    //delete coin by id
    public void deleteCoinById(String id) {
        coinRepository.deleteById(id);
    }
}
