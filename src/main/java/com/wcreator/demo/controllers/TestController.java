package com.wcreator.demo.controllers;

import com.wcreator.demo.clients.exchange.ExchangeClient;
import com.wcreator.demo.clients.exchange.dto.ExchangeResponse;
import com.wcreator.demo.clients.gif.GifClient;
import com.wcreator.demo.services.ExchangeRateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {
    private final ExchangeClient exchangeClient;
    private final GifClient gifClient;
    private final ExchangeRateValidation exchangeRateValidation;

    @Autowired
    TestController(ExchangeClient exchangeClient, GifClient gifClient, ExchangeRateValidation exchangeRateValidation) {
        this.exchangeClient = exchangeClient;
        this.gifClient = gifClient;
        this.exchangeRateValidation = exchangeRateValidation;
    }

    @GetMapping
    ExchangeResponse test() {
        return exchangeClient.getLastExchangeRate();
    }

    @GetMapping("/historical")
    ExchangeResponse historical() {
        Date date = Calendar.getInstance().getTime();
        return exchangeClient.getHistoricalDateRate(date);
    }

    @GetMapping("/validate")
    boolean validate() {
        return exchangeRateValidation.isGoodExchangeRate();
    }

    @GetMapping("/rich")
    ResponseEntity<Void> richTest() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(gifClient.rich().getData().getEmbedUrl())
                .build();
    }

    @GetMapping("/broke")
    ResponseEntity<Void> brokeTest() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(gifClient.broke().getData().getEmbedUrl())
                .build();
    }
}
