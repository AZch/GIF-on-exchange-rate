package com.wcreator.demo.services;

import com.wcreator.demo.clients.exchange.ExchangeClient;
import com.wcreator.demo.clients.exchange.dto.ExchangeResponse;
import com.wcreator.demo.exceptions.ConflictCompareCurrency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class ExchangeRateValidationByPreviousDay implements ExchangeRateValidation {
    @Value("${exchange.currency.compare}")
    private String compareRate;

    private final ExchangeClient exchangeClient;

    ExchangeRateValidationByPreviousDay(ExchangeClient exchangeClient) {
        this.exchangeClient = exchangeClient;
    }

    @Override
    public boolean isGoodExchangeRate() {
        ExchangeResponse previousDateRate = exchangeClient.getHistoricalDateRate(this.getPreviousDate());
        if (!previousDateRate.getRates().containsKey(compareRate)) {
            throw new ConflictCompareCurrency(compareRate);
        }
        ExchangeResponse latestRate = exchangeClient.getLastExchangeRate();
        if (!latestRate.getRates().containsKey(compareRate)) {
            throw new ConflictCompareCurrency(compareRate);
        }
        return latestRate.getRates().get(compareRate) < previousDateRate.getRates().get(compareRate);
    }

    private Date getPreviousDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }
}
