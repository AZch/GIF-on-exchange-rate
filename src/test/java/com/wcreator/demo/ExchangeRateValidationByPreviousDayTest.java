package com.wcreator.demo;

import com.wcreator.demo.clients.exchange.ExchangeClient;
import com.wcreator.demo.clients.exchange.dto.ExchangeResponse;
import com.wcreator.demo.exceptions.ConflictCompareCurrency;
import com.wcreator.demo.services.ExchangeRateValidation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TestEnvConfiguration.class)
public class ExchangeRateValidationByPreviousDayTest {
    @Autowired
    private ExchangeRateValidation exchangeRateValidation;

    @MockBean
    private ExchangeClient exchangeClient;

    @Test
    public void shouldBeInvalidValidation() {
        ExchangeResponse lastExchangeRate = ExchangeResponse.builder()
                .base("USD")
                .rates(Map.of("RUB", 11F))
                .build();
        when(exchangeClient.getLastExchangeRate()).thenReturn(lastExchangeRate);

        ExchangeResponse historicalExchangeRate = ExchangeResponse.builder()
                .base("USD")
                .rates(Map.of("RUB", 10F))
                .build();
        when(exchangeClient.getHistoricalDateRate(any())).thenReturn(historicalExchangeRate);

        assertFalse(exchangeRateValidation.isGoodExchangeRate());
    }

    @Test
    public void shouldBeValidValidation() {
        ExchangeResponse lastExchangeRate = ExchangeResponse.builder()
                .base("USD")
                .rates(Map.of("RUB", 10F))
                .build();
        when(exchangeClient.getLastExchangeRate()).thenReturn(lastExchangeRate);

        ExchangeResponse historicalExchangeRate = ExchangeResponse.builder()
                .base("USD")
                .rates(Map.of("RUB", 11F))
                .build();
        when(exchangeClient.getHistoricalDateRate(any())).thenReturn(historicalExchangeRate);

        assertTrue(exchangeRateValidation.isGoodExchangeRate());
    }

    @Test
    public void shouldReturnExceptionBecauseLastExchangeCompareRateNotFind() {
        ExchangeResponse historicalExchangeRate = ExchangeResponse.builder()
                .base("USD")
                .rates(Map.of())
                .build();
        when(exchangeClient.getHistoricalDateRate(any())).thenReturn(historicalExchangeRate);

        Throwable thrown = catchThrowable(() -> exchangeRateValidation.isGoodExchangeRate());

        assertThat(thrown).isInstanceOf(ConflictCompareCurrency.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }

    @Test
    public void shouldReturnExceptionBecauseHistoricalExchangeCompareRateNotFind() {
        ExchangeResponse historicalExchangeRate = ExchangeResponse.builder()
                .base("USD")
                .rates(Map.of("RUB", 10F))
                .build();
        when(exchangeClient.getHistoricalDateRate(any())).thenReturn(historicalExchangeRate);

        ExchangeResponse lastExchangeRate = ExchangeResponse.builder()
                .base("USD")
                .rates(Map.of())
                .build();
        when(exchangeClient.getLastExchangeRate()).thenReturn(lastExchangeRate);

        Throwable thrown = catchThrowable(() -> exchangeRateValidation.isGoodExchangeRate());

        assertThat(thrown).isInstanceOf(ConflictCompareCurrency.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }
}
