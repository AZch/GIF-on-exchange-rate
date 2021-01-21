package com.wcreator.demo.clients.gif.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

public class GifClientInterceptor implements RequestInterceptor {

    @Value("${gif.api.key}")
    private String apiKey;

    private static final String API_KEY = "api_key";

    @Override
    public void apply(RequestTemplate template) {
        template.query(API_KEY, apiKey);
    }
}
