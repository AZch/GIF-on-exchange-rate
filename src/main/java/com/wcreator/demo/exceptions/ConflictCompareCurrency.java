package com.wcreator.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictCompareCurrency extends RuntimeException {
    public ConflictCompareCurrency(String currency) {
        super(String.format("no have %s currency in exchanger response", currency));
    }
}
