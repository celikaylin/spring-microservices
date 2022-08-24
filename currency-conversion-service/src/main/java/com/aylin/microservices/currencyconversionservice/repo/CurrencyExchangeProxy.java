package com.aylin.microservices.currencyconversionservice.repo;

import com.aylin.microservices.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="currency-exchange", url = "http://localhost:8000")
public interface CurrencyExchangeProxy {
    @RequestMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion getCurrencyExchange(@PathVariable String from, @PathVariable String to );
}
