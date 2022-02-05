package com.agesadev.palmpay.controller;

import com.agesadev.palmpay.model.Coin;
import com.agesadev.palmpay.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coincontroller")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @GetMapping("/getcoins")
    public List<Coin> getCoins() {
        return coinService.getCoins();
    }

    @PostMapping("/addcoin")
    public String addCoin(Coin coin) {
        coinService.saveCoin(coin);
        return "Coin added";
    }

    //update coin
    @PutMapping("/updatecoin")
    public String updateCoin(Coin coin) {
        coinService.updateCoin(coin);
        return "Coin updated";
    }

    //delete coin
    @PostMapping("/deletecoin")
    public String deleteCoin(Coin coin) {
        coinService.deleteCoinById(coin.getId());
        return "Coin deleted";
    }
}







