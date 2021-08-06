/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class CurrencyExchangeDetails {

    private String currency;
    private BigDecimal amount;
    private BigDecimal conversionRate;
    private BigDecimal surcharge;
    private BigDecimal exchangeValue;
    private String userId;

    public CurrencyExchangeDetails() {}

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(BigDecimal surcharge) {
        this.surcharge = surcharge;
    }

    public BigDecimal getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(BigDecimal exchangeValue) {
        this.exchangeValue = exchangeValue;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CurrencyExchangeDetails(String currency, BigDecimal amount, BigDecimal conversionRate, BigDecimal surcharge,
          BigDecimal exchangeValue, String userId) {
        this.currency = currency;
        this.amount = amount;
        this.conversionRate = conversionRate;
        this.surcharge = surcharge;
        this.exchangeValue = exchangeValue;
        this.userId = userId;
    }
}
