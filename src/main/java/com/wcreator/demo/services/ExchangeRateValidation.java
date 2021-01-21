package com.wcreator.demo.services;

import org.springframework.stereotype.Service;

@Service
public interface ExchangeRateValidation {
    boolean isGoodExchangeRate();
}
