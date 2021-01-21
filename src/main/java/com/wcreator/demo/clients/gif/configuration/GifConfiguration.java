package com.wcreator.demo.clients.gif.configuration;

import com.wcreator.demo.clients.gif.interceptor.GifClientInterceptor;
import org.springframework.context.annotation.Bean;

public class GifConfiguration {

    @Bean
    GifClientInterceptor gifClientInterceptor() {
        return new GifClientInterceptor();
    }
}
