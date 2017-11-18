/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.agilysys.common.model.statuses.PropertyConfigItemStatus.CanonicalId;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.platform.tax.model.TaxClass;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.agilysys.pms.property.model.RoomType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NonRoomInventoryItem extends AccountingItem{
    @MinLengthRestriction(4)
    private String plu;

    @JsonProperty(required = true)
    private BigDecimal defaultPrice;

    @DataPortReference(name = "taxClassNames", type = TaxClass.class, multiple = true)
    private List<String> taxClasses;

    private String glCode;

    private String status =  CanonicalId.ACTIVE.name();

    @JsonProperty(required = true)
    private int availableCount;

    private int allowedLimitPerReservation = Integer.MIN_VALUE;

    @DataPortReference(name = "blockForRoomTypeCodes", type = { RoomType.class}, multiple = true)
    private List<String> blockForRoomTypes;

    private String altSystemId;

    public String getPlu() {
        return (StringUtils.isNotEmpty(plu) ? plu : null);
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public List<String> getTaxClasses() {
        return taxClasses;
    }

    public void setTaxClasses(List<String> taxClasses) {
        this.taxClasses = taxClasses;
    }

    public String getAltSystemId() {
        return altSystemId;
    }

    public void setAltSystemId(String altSystemId) {
        this.altSystemId = altSystemId;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    public List<String> getBlockForRoomTypes() {
        return blockForRoomTypes;
    }

    public void setBlockForRoomTypes(List<String> blockForRoomTypes) {
        this.blockForRoomTypes = blockForRoomTypes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getAllowedLimitPerReservation() {
        return allowedLimitPerReservation;
    }

    public void setAllowedLimitPerReservation(int allowedLimitPerReservation) {
        this.allowedLimitPerReservation = allowedLimitPerReservation;
    }

    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj, Boolean.FALSE);
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this, Boolean.FALSE);
    }
}
