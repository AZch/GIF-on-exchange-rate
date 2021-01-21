package com.wcreator.demo.clients.exchange.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class ExchangeResponse {
    private String disclaimer;
    private String license;
    private Date timestamp;
    private String base;
    private Map<String, Float> rates;
}
