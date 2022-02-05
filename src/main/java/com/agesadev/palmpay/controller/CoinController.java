package com.agesadev.palmpay.controller;

import com.agesadev.palmpay.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coincontroller")
public class CoinController {

    @Autowired
    public CoinService coinService;


}

