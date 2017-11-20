/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.agilysys.common.model.statuses.PropertyConfigItemStatus;
import com.agilysys.common.model.statuses.PropertyConfigItemStatus.CanonicalId;
import com.agilysys.intapp.model.FolioPostingCodes;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.platform.tax.model.TaxClass;
import com.agilysys.pms.common.model.annotation.DataPortMapReference;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.agilysys.pms.property.model.Building;
import com.agilysys.pms.property.model.MealPeriod;
import com.agilysys.pms.property.model.Outlet;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NonRoomInventoryItem extends AccountingItem{
    @MinLengthRestriction(4)
    private String plu;

    @JsonProperty(required = true)
    private BigDecimal defaultPrice;

    @DataPortMapReference(name = "sourceCodeToMealPeriodCodes", keyType = {
          Building.class, Outlet.class }, valueType = MealPeriod.class, multipleValues = true)
    private Map<String, List<String>> sourceMealPeriods;

    @DataPortReference(name = "taxClassNames", type = TaxClass.class, multiple = true)
    private List<String> taxClasses;

    private String glCode;

    private PropertyConfigItemStatus.CanonicalId status =  CanonicalId.ACTIVE;

    @JsonProperty(required = true)
    private int availableCount;

    private String altSystemId;

    private List<FolioPostingCodes> folioPostingCodes;

    public List<FolioPostingCodes> getFolioPostingCodes() {
        return folioPostingCodes;
    }

    public void setFolioPostingCodes(List<FolioPostingCodes> folioPostingCodes) {
        this.folioPostingCodes = folioPostingCodes;
    }

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

    public PropertyConfigItemStatus.CanonicalId getStatus() {
        return status;
    }

    public void setStatus(PropertyConfigItemStatus.CanonicalId status) {
        this.status = status;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public Map<String, List<String>> getSourceMealPeriods() {
        return sourceMealPeriods;
    }

    public void setSourceMealPeriods(Map<String, List<String>> sourceMealPeriods) {
        this.sourceMealPeriods = sourceMealPeriods;
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
