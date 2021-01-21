package com.wcreator.demo.clients.exchange.configuration;

import com.wcreator.demo.clients.exchange.interceptor.ExchangeClientInterceptor;
import org.springframework.context.annotation.Bean;

public class ExchangeConfiguration {

    @Bean
    public ExchangeClientInterceptor exchangeClientInterceptor() {
        return new ExchangeClientInterceptor();
    }
}
