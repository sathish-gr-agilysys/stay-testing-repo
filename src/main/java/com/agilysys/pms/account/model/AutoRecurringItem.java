/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Transient;

import com.agilysys.common.model.FrequencyType;
import com.agilysys.common.model.statuses.PropertyConfigItemStatus.CanonicalId;
import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntity;
import com.agilysys.pms.common.audit.annotation.AuditField;
import com.agilysys.pms.common.model.RateCalculationBaseType;
import com.agilysys.pms.common.model.ValueType;
import com.fasterxml.jackson.annotation.JsonProperty;

@AuditEntity(EntityTypes.AUTO_RECURRING_ITEM)
public class AutoRecurringItem extends AccountingObjectBase {
    private static final String DISPLAY_NAME = "Auto-Recurring item";

    @JsonProperty(required = true)
    private BigDecimal value;

    @JsonProperty(required = true)
    ValueType valueType = ValueType.AMOUNT;

    @JsonProperty(required = true)
    RateCalculationBaseType basedOn = RateCalculationBaseType.NIGHTLY_ROOM_CHARGE;

    @JsonProperty(required = true)
    @AuditField(name = "defaultSource", references = { EntityTypes.BUILDING, EntityTypes.OUTLET })
    private String defaultSourceId;

    @JsonProperty(required = true)
    private FrequencyType frequencyType;

    @JsonProperty(required = true)
    @AuditField(name = "parentTransactionItem", references = EntityTypes.TRANSACTION_ITEM)
    private String parentTransactionItemId;

    private CanonicalId status;
    private int nNights;

    @JsonProperty(required = true)
    private LocalDate startDate;

    private LocalDate endDate;
    private String description;

    public AutoRecurringItem(){
        this.status = CanonicalId.INACTIVE;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public RateCalculationBaseType getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(RateCalculationBaseType basedOn) {
        this.basedOn = basedOn;
    }

    public String getDefaultSourceId() {
        return defaultSourceId;
    }

    public void setDefaultSourceId(String defaultSourceId) {
        this.defaultSourceId = defaultSourceId;
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

    public CanonicalId getStatus() {
        return status;
    }

    public void setStatus(CanonicalId status) {
        this.status = status;
    }

    @Transient
    public boolean isActive() {
        return this.status == CanonicalId.ACTIVE;
    }

    public String getParentTransactionItemId() {
        return parentTransactionItemId;
    }

    public void setParentTransactionItemId(String parentTransactionItemId) {
        this.parentTransactionItemId = parentTransactionItemId;
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

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
