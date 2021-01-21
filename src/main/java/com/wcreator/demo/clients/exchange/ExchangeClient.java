package com.wcreator.demo.clients.exchange;

import com.wcreator.demo.clients.exchange.configuration.ExchangeConfiguration;
import com.wcreator.demo.clients.exchange.dto.ExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${exchange.name}", url = "${exchange.api.urls.base}", configuration = ExchangeConfiguration.class)
public interface ExchangeClient {
    @GetMapping("${exchange.api.urls.latest}")
    ExchangeResponse getLastExchangeRate();
}
