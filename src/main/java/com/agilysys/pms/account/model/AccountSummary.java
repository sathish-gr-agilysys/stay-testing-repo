/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.agilysys.common.model.PaymentSetting;
import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.platform.common.json.schema.PatternRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.agilysys.common.utils.Utils.ALPHANUMERIC_HYPHEN_VALIDATION_REGEX;

public class AccountSummary {
    protected String id;

    protected String tenantId;

    @JsonProperty(required = true)
    protected String propertyId;

    protected List<PaymentSetting> paymentSettings = new ArrayList<>();

    protected String accountStatus;

    @JsonProperty(required = true)
    protected String accountType;

    protected String referenceId;

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
    protected TaxExemptSettings taxExemptSettings;

    protected String companyProfileId;

    protected String groupAccountId;

    protected AccountsReceivableSettings accountsReceivableSettings;

    @MinLengthRestriction(4)
    @MaxLengthRestriction(12)
    @PatternRestriction(ALPHANUMERIC_HYPHEN_VALIDATION_REGEX)
    protected String number;

    @MinLengthRestriction(1)
    @MaxLengthRestriction(64)
    protected String name;

    protected String houseAccountCategoryId;

    private Map<String, Object> taxFacts = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public List<PaymentSetting> getPaymentSettings() {
        return paymentSettings;
    }

    public void setPaymentSettings(List<PaymentSetting> paymentSettings) {
        this.paymentSettings = paymentSettings;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String type) {
        this.accountType = type;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String status) {
        this.accountStatus = status;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String id) {
        this.referenceId = id;
    }

    public String getGroupAccountId() {
        return groupAccountId;
    }

    public void setGroupAccountId(String id) {
        this.groupAccountId = id;
    }

    public String getCompanyProfileId() {
        return companyProfileId;
    }

    public void setCompanyProfileId(String id) {
        this.companyProfileId = id;
    }

    public void setTaxExemptSettings(TaxExemptSettings settings) {
        this.taxExemptSettings = settings;
    }

    public TaxExemptSettings getTaxExemptSettings() {
        return this.taxExemptSettings;
    }

    public AccountsReceivableSettings getAccountsReceivableSettings() {
        return accountsReceivableSettings;
    }

    public void setAccountsReceivableSettings(AccountsReceivableSettings accountsReceivableSettings) {
        this.accountsReceivableSettings = accountsReceivableSettings;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseAccountCategoryId() {
        return houseAccountCategoryId;
    }

    public void setHouseAccountCategoryId(String houseAccountCategoryId) {
        this.houseAccountCategoryId = houseAccountCategoryId;
    }

    public Map<String, Object> getTaxFacts() {
        return taxFacts;
    }

    public void setTaxFacts(Map<String, Object> taxFacts) {
        this.taxFacts = taxFacts;
    }
}