package com.agesadev.palmpay.service;

import com.agesadev.palmpay.model.Coin;
import com.agesadev.palmpay.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinService {
    @Autowired
    public CoinRepository coinRepository;

//    save coin to db
    public String saveCoin(Coin coin) {
        coinRepository.save(coin);
        return "Coin saved";
    }

//    get coin from db
    public com.agesadev.palmpay.model.Coin getCoin(String coinName) {
        return coinRepository.findByCoinName(coinName);
    }

//    update coin value
    public void updateCoin(String coinName, String coinValue) {
        com.agesadev.palmpay.model.Coin coin = coinRepository.findByCoinName(coinName);
        coin.setCoinValue(coinValue);
        coinRepository.save(coin);
    }
}
