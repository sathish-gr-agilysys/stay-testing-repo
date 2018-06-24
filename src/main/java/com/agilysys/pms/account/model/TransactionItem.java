/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.agilysys.common.model.statuses.PropertyConfigItemStatus.CanonicalId;
import com.agilysys.intapp.model.FolioPostingCodes;
import com.agilysys.platform.tax.model.TaxClass;
import com.agilysys.pms.common.model.annotation.DataPortMapReference;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.agilysys.pms.property.model.Building;
import com.agilysys.pms.property.model.MealPeriod;
import com.agilysys.pms.property.model.Outlet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represents a TransactionItem in the application.
 */
public class TransactionItem extends AccountingItem {
    private static final String DISPLAY_NAME = "Transaction item";

    private String plu;

    @JsonProperty(required = true)
    private BigDecimal defaultPrice;

    @JsonProperty(required = true)
    @DataPortMapReference(name = "sourceCodeToMealPeriodCodes", keyType = {
          Building.class, Outlet.class }, valueType = MealPeriod.class, multipleValues = true)
    private Map<String, List<String>> sourceMealPeriods;

    @DataPortReference(name = "taxClassNames", type = TaxClass.class, multiple = true)
    private List<String> taxClasses;

    private String glCode;

    private CanonicalId status = CanonicalId.ACTIVE;
    /**
     * An optional id to associate this transaction item with an item from an external system.
     * i.e. a tax service item
     */
    private String altSystemId;

    /**
     * An optional mapping that is used to map charges made by comtrol to transaction items.
     */
    private List<FolioPostingCodes> folioPostingCodes;

    public TransactionItem() {

    }

    public TransactionItem(TransactionItem transactionItem) {
        super(transactionItem);

        plu = transactionItem.getPlu();
        defaultPrice = transactionItem.getDefaultPrice();
        sourceMealPeriods = transactionItem.getSourceMealPeriods();
        taxClasses = transactionItem.getTaxClasses();
        glCode = transactionItem.getGlCode();
        status = transactionItem.getStatus();
        altSystemId = transactionItem.getAltSystemId();
        folioPostingCodes = transactionItem.getFolioPostingCodes();
    }
    /**
     * @return the plu
     */
    public String getPlu() {
        return (StringUtils.isNotEmpty(plu) ? plu : null);
    }

    /**
     * @param plu the plu to set
     */
    public void setPlu(String plu) {
        this.plu = plu;
    }

    /**
     * @return the defaultPrice
     */
    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    /**
     * @param defaultPrice the defaultPrice to set
     */
    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    /**
     * @return the sourceMealPeriods
     */
    public Map<String, List<String>> getSourceMealPeriods() {
        return sourceMealPeriods;
    }

    /**
     * @param sourceMealPeriods the sourceMealPeriods to set
     */
    public void setSourceMealPeriods(Map<String, List<String>> sourceMealPeriods) {
        this.sourceMealPeriods = sourceMealPeriods;
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

    public List<FolioPostingCodes> getFolioPostingCodes() {
        return folioPostingCodes;
    }

    public void setFolioPostingCodes(List<FolioPostingCodes> folioPostingCodes) {
        this.folioPostingCodes = folioPostingCodes;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    public CanonicalId getStatus() {
        return status;
    }

    public void setStatus(CanonicalId status) {
        this.status = status;
    }

    public TransactionItemType getType() {
        return TransactionItemType.TRANSACTION;
    }

    @JsonIgnore
    public boolean isActive() {
        return this.status == CanonicalId.ACTIVE;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj, Boolean.FALSE);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this, Boolean.FALSE);
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
