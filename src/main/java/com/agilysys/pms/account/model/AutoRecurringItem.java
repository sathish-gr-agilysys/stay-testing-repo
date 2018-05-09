/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Set;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Transient;

import com.agilysys.common.model.statuses.PropertyConfigItemStatus.CanonicalId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AutoRecurringItem extends AccountingObjectBase {
    @JsonProperty(required = true)
    private String defaultSource;
    @JsonProperty(required = true)
    private String parentTransactionItemId;
    @JsonProperty(required = true)
    private BigDecimal defaultPrice;
    private CanonicalId status;
    @JsonProperty(required = true)
    private FrequencyType frequency;
    private int nNights;
    @JsonProperty(required = true)
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    @Transient
    private Set<String> parentTransactionItemSources;

    public Set<String> getParentTransactionItemSources() {
        return parentTransactionItemSources;
    }

    public void setParentTransactionItemSources(Set<String> parentTransactionItemSources) {
        this.parentTransactionItemSources = parentTransactionItemSources;
    }

    public FrequencyType getFrequency() {
        return frequency;
    }

    public void setFrequency(FrequencyType frequency) {
        this.frequency = frequency;
    }

    public int getnNights() {
        return nNights;
    }

    public void setnNights(int nNights) {
        this.nNights = nNights;
    }

    public CanonicalId getStatus() {
        return status;
    }

    public void setStatus(CanonicalId status) {
        this.status = status;
    }

    @JsonIgnore
    public boolean isActive() {
        return this.status == CanonicalId.ACTIVE;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getParentTransactionItemId() {
        return parentTransactionItemId;
    }

    public void setParentTransactionItemId(String parentTransactionItemId) {
        this.parentTransactionItemId = parentTransactionItemId;
    }

    public String getDefaultSource() {
        return defaultSource;
    }

    public void setDefaultSource(String defaultSource) {
        this.defaultSource = defaultSource;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
