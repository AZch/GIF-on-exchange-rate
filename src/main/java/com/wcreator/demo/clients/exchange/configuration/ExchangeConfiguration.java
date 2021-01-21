package com.wcreator.demo.clients.exchange.configuration;

import com.wcreator.demo.clients.exchange.interceptor.ExchangeClientAuthInterceptor;
import com.wcreator.demo.clients.exchange.interceptor.ExchangeClientCurrencyInterceptor;
import org.springframework.context.annotation.Bean;

public class ExchangeConfiguration {

    @Bean
    public ExchangeClientAuthInterceptor exchangeClientInterceptor() {
        return new ExchangeClientAuthInterceptor();
    }

    @Bean
    public ExchangeClientCurrencyInterceptor exchangeClientCurrencyInterceptor() { return new ExchangeClientCurrencyInterceptor(); }
}
