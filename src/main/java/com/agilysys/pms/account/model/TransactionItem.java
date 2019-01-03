/*
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
import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntity;
import com.agilysys.pms.common.audit.annotation.AuditField;
import com.agilysys.pms.common.audit.annotation.AuditMapField;
import com.agilysys.pms.common.model.annotation.DataPortMapReference;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.agilysys.pms.property.model.Building;
import com.agilysys.pms.property.model.MealPeriod;
import com.agilysys.pms.property.model.Outlet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@AuditEntity(EntityTypes.TRANSACTION_ITEM)
public class TransactionItem extends AccountingItem {
    private static final String DISPLAY_NAME = "Transaction item";

    /**
     * An optional id to associate this transaction item with an item from an external system.
     * i.e. a tax service item
     */
    protected String altSystemId;

    @JsonProperty(required = true)
    protected BigDecimal defaultPrice;

    /**
     * An optional mapping that is used to map charges made by comtrol to transaction items.
     */
    protected List<FolioPostingCodes> folioPostingCodes;

    protected String glCode;

    protected String plu;

    @JsonProperty(required = true)
    @DataPortMapReference(name = "sourceCodeToMealPeriodCodes", keyType = {
          Building.class, Outlet.class }, valueType = MealPeriod.class, multipleValues = true)
    @AuditMapField(keyReferences = { EntityTypes.BUILDING, EntityTypes.OUTLET },
          valueReferences = EntityTypes.MEAL_PERIOD, valueInline = true)
    private Map<String, List<String>> sourceMealPeriods;

    protected CanonicalId status;

    @DataPortReference(name = "taxClassNames", type = TaxClass.class, multiple = true)
    @AuditField(inline = true)
    protected List<String> taxClasses;   
    
    public TransactionItem() {
        super();

        status = CanonicalId.ACTIVE;
    }

    public TransactionItem(TransactionItem transactionItem) {
        super(transactionItem);

        altSystemId = transactionItem.getAltSystemId();
        defaultPrice = transactionItem.getDefaultPrice();
        folioPostingCodes = transactionItem.getFolioPostingCodes();
        glCode = transactionItem.getGlCode();
        plu = transactionItem.getPlu();
        sourceMealPeriods = transactionItem.getSourceMealPeriods();
        status = transactionItem.getStatus();
        taxClasses = transactionItem.getTaxClasses();
    }

    public String getAltSystemId() {
        return altSystemId;
    }

    public void setAltSystemId(String altSystemId) {
        this.altSystemId = altSystemId;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
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

    public String getPlu() {
        return (StringUtils.isNotEmpty(plu) ? plu : null);
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public Map<String, List<String>> getSourceMealPeriods() {
        return sourceMealPeriods;
    }

    public void setSourceMealPeriods(Map<String, List<String>> sourceMealPeriods) {
        this.sourceMealPeriods = sourceMealPeriods;
    }

    public CanonicalId getStatus() {
        return status;
    }

    public void setStatus(CanonicalId status) {
        this.status = status;
    }

    public List<String> getTaxClasses() {
        return taxClasses;
    }

    public void setTaxClasses(List<String> taxClasses) {
        this.taxClasses = taxClasses;
    }

    public TransactionItemType getType() {
        return TransactionItemType.TRANSACTION;
    }

    @JsonIgnore
    public boolean isActive() {
        return this.status == CanonicalId.ACTIVE;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, Boolean.FALSE);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, Boolean.FALSE);
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
