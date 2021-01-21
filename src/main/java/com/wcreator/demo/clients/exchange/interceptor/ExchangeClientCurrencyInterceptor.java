package com.wcreator.demo.clients.exchange.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

public class ExchangeClientCurrencyInterceptor implements RequestInterceptor {
    @Value("${exchange.currency.base}")
    private String currencyBase;

    private static final String CURRENCY_BASE = "base";

    @Override
    public void apply(RequestTemplate template) {
        template.query(CURRENCY_BASE, currencyBase);
    }
}
