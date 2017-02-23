package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;

public class RecurringChargeReportItem {
    private LocalDate chargeDate;
    private BigDecimal chargeAmount;
    private BigDecimal taxAmount;
    private boolean posted;
    private String accountId;
    private String reservationId;
    private String itemId;
    private String itemName;
    List<ComponentChargeView> componentCharges = new ArrayList<>();
    /**
     * EVERY = Every Night
     * FIRST = First Night Only
     * LAST = Last Night Only
     * EVERY_N = Every N Nights, nNights must be set > 0
     * DAYS_OF_WEEK = Specific days of the week, occurrenceDays must be set
     */
    private FrequencyType frequencyType;
    private int nNights;
    // Convention per ISO standard DateTimeConstants in org.joda.time; Monday 1 .... Sunday 7
    private Set<Integer> occurrenceDays = new HashSet<>();

    public LocalDate getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(LocalDate chargeDate) {
        this.chargeDate = chargeDate;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public FrequencyType getFrequencyType() {
        return frequencyType;
    }

    public void setFrequencyType(FrequencyType frequencyType) {
        this.frequencyType = frequencyType;
    }

    public int getnNights() {
        return nNights;
    }

    public void setnNights(int nNights) {
        this.nNights = nNights;
    }

    public Set<Integer> getOccurrenceDays() {
        return occurrenceDays;
    }

    public void setOccurrenceDays(Set<Integer> occurrenceDays) {
        this.occurrenceDays = occurrenceDays;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<ComponentChargeView> getComponentCharges() {
        return componentCharges;
    }

    public void setComponentCharges(List<ComponentChargeView> componentCharges) {
        this.componentCharges = componentCharges;
    }
}
