package com.wcreator.demo.clients.exchange.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ExchangeResponse {
    private String base;
    private Map<String, Float> rates;
}
