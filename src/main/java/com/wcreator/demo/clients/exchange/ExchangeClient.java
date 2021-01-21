package com.wcreator.demo.clients.exchange;

import com.wcreator.demo.clients.exchange.configuration.ExchangeConfiguration;
import com.wcreator.demo.clients.exchange.dto.ExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@FeignClient(name = "${exchange.name}", url = "${exchange.api.urls.base}", configuration = ExchangeConfiguration.class)
public interface ExchangeClient {
    @GetMapping("${exchange.api.urls.latest}")
    ExchangeResponse getLastExchangeRate();

    @GetMapping("${exchange.api.urls.historical}/{date}.json")
    ExchangeResponse getHistoricalDateRate(
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date rateDate
    );
}
