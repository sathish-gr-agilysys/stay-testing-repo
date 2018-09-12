/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static com.agilysys.pms.common.exceptions.ExceptionFactory.accountException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;

import com.agilysys.common.permission.OverrideType;
import com.agilysys.common.model.rate.CreateRecurringChargeOverride;
import com.agilysys.platform.common.json.schema.MinValueRestriction;
import com.agilysys.pms.common.exceptions.account.AccountErrorCode;
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

    @MinValueRestriction(1)
    private int quantity;

    @JsonProperty(required = true)
    private LocalDate startDate;

    @JsonProperty(required = true)
    private LocalDate endDate;

    private Set<OverrideType> overrideTypes;

    private Map<LocalDate, CreateRecurringChargeOverride> recurringChargeOverrides;

    public Map<LocalDate, CreateRecurringChargeOverride> getRecurringChargeOverrides() {
        return recurringChargeOverrides;
    }

    public void setRecurringChargeOverrides(Map<LocalDate, CreateRecurringChargeOverride> recurringChargeOverrides) {
        this.recurringChargeOverrides = recurringChargeOverrides;
    }

    public Set<OverrideType> getOverrideTypes() {
        return overrideTypes != null ? overrideTypes : Collections.emptySet();
    }

    public void setOverrideTypes(Set<OverrideType> overrideTypes) {
        this.overrideTypes = overrideTypes;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Convention per ISO standard DateTimeConstants in org.joda.time; Monday 1 .... Sunday 7
    private Set<Integer> occurrenceDays = new HashSet<>();

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
                    throw accountException(AccountErrorCode.OCCURRENCE_DAYS_INVALID).buildCompatible();
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
