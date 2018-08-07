package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

public class EstimatedRoomChargeView {
    private BigDecimal amount;
    private LocalDate chargeDate;
    private String rateCode;

    public EstimatedRoomChargeView(BigDecimal amount, LocalDate chargeDate, String rateCode) {
        this.amount = amount;
        this.chargeDate = chargeDate;
        this.rateCode = rateCode;
    }

    public BigDecimal getAmount() {
        return amount;

    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(LocalDate chargeDate) {
        this.chargeDate = chargeDate;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }
}
