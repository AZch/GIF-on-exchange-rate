package com.wcreator.demo.controllers;

import com.wcreator.demo.clients.exchange.ExchangeClient;
import com.wcreator.demo.clients.exchange.dto.ExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    @Autowired
    private ExchangeClient exchangeClient;

    @GetMapping
    ExchangeResponse test() {
        return exchangeClient.getLastExchangeRate();
    }
}
