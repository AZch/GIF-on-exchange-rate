package com.wcreator.demo.clients.exchange.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

public class ExchangeClientInterceptor implements RequestInterceptor {

    @Value("${exchange.api.key}")
    private String apiKey;

    private static final String APP_ID = "app_id";

    @Override
    public void apply(RequestTemplate template) {
        template.query(APP_ID, apiKey);
    }
}
