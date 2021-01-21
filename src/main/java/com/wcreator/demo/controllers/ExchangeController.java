package com.wcreator.demo.controllers;

import com.wcreator.demo.clients.exchange.ExchangeClient;
import com.wcreator.demo.clients.exchange.dto.ExchangeResponse;
import com.wcreator.demo.clients.gif.GifClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class ExchangeController {

    @Autowired
    private ExchangeClient exchangeClient;

    @Autowired
    private GifClient gifClient;

    @GetMapping
    ExchangeResponse test() {
        return exchangeClient.getLastExchangeRate();
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
