/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.agilysys.platform.common.exception.ValidationException;
import com.agilysys.platform.common.json.schema.MinValueRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRecurringCharge {
    private String agentId;

    @JsonProperty(required = true)
    private String sourceId;

    @JsonProperty(required = true)
    private String itemId;

    @JsonProperty(required = true)
    private BigDecimal amount;

    private String reason;

    @JsonProperty(required = true)
    private String folioId;

    @JsonProperty(required = true)
    private FrequencyType frequencyType;

    @MinValueRestriction(1)
    private int nNights;

    // Convention per ISO standard DateTimeConstants in org.joda.time; Monday 1 .... Sunday 7
    private Set<Integer> occurrenceDays = new HashSet<>();

    //This is here only because the UI needs to send it in
    private int quantity;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public FrequencyType getFrequencyType() {
        return frequencyType;
    }

    public void setFrequencyType(FrequencyType value) {
        this.frequencyType = value;
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
        if (occurrenceDays != null) {
            for (Integer day : occurrenceDays) {
                if (day < 1 || day > 7) {
                    throw new ValidationException("Occurrence days must be 1-7 inclusive.");
                }
            }
        }

        this.occurrenceDays = occurrenceDays;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    @Override
    public String toString() {
        return "RecurringCharge [agentId=" + agentId + ", itemId=" + itemId + ", amount=" + amount + ", reason=" +
              reason + ", frequency=" + frequencyType + ", nNights=" + nNights + ", occurrenceDays=" +
              Arrays.toString(occurrenceDays.toArray()) + "]";
    }

    public CreateRecurringCharge(String agentId, String itemId, BigDecimal amount, String reason,
          FrequencyType frequencyType, int nNights, Set<Integer> occurrenceDays) {
        this.agentId = agentId;
        this.itemId = itemId;
        this.amount = amount;
        this.reason = reason;
        this.frequencyType = frequencyType;
        this.nNights = nNights;
        this.occurrenceDays = occurrenceDays;
    }

    public CreateRecurringCharge() {

    }
}
