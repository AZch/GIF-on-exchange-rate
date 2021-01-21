package com.wcreator.demo.controllers;

import com.wcreator.demo.clients.gif.GifClient;
import com.wcreator.demo.services.ExchangeRateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    private final GifClient gifClient;
    private final ExchangeRateValidation exchangeRateValidation;

    @Autowired
    ExchangeController(GifClient gifClient, ExchangeRateValidation exchangeRateValidation) {
        this.gifClient = gifClient;
        this.exchangeRateValidation = exchangeRateValidation;
    }

    @GetMapping
    ResponseEntity<Void> validateRate() {
        boolean isRateGood = exchangeRateValidation.isGoodExchangeRate();
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(isRateGood ? gifClient.rich().getData().getEmbedUrl() : gifClient.broke().getData().getEmbedUrl())
                .build();
    }
}
