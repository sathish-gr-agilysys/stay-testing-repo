/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.agilysys.common.model.PaymentMethodSetting;
import com.agilysys.common.permission.PermissionType;
import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntity;
import com.agilysys.pms.common.audit.annotation.AuditField;
import com.agilysys.pms.common.model.annotation.DataPortInline;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.agilysys.pms.payment.model.Issuer;
import com.agilysys.pms.property.model.Building;
import com.agilysys.pms.property.model.Outlet;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to represent a PaymentMethod
 */
@AuditEntity(EntityTypes.PAYMENT_METHOD)
public class PaymentMethod extends AccountingItem {

    private static final String DISPLAY_NAME = "Payment method";

    //CC is the code for Credit Card in bootstrap data
    public static String CREDIT_CARD_CODE = "CC";
    //DB is the code for direct bill in bootstrap data, it is the default for company accounts
    public static String DIRECT_BILL_CODE = "DB";
    //CASH is the code for cash in bootstrap data, it is the default for groups
    public static String CASH_CODE = "CASH";
    
    private boolean cashPayment;

    public boolean isCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(boolean cashPayment) {
        this.cashPayment = cashPayment;
    }

    @JsonProperty(required = true)
    private PaymentClass paymentClass;

    @DataPortInline
    private PaymentMethodSetting paymentMethodSetting;

    @DataPortReference(name = "issuerName", type = Issuer.class, persistKey = true)
    private String issuer;

    @DataPortInline
    private PaymentInterfaces interfaces;

    //If sourceIds == null, the all sources are allowed
    @DataPortReference(name = "sourceCodes", type = { Building.class, Outlet.class }, multiple = true)
    @AuditField(name = "sources", references = { EntityTypes.BUILDING, EntityTypes.OUTLET }, inline = true)
    private Set<String> sourceIds;

    private String glCode;

    private PermissionType restrictivePermission;

    public Set<String> getSourceIds() {
        return sourceIds;
    }

    public void setSourceIds(Set<String> sourceIds) {
        this.sourceIds = sourceIds;
    }

    public PaymentClass getPaymentClass() {
        return paymentClass;
    }

    public void setPaymentClass(PaymentClass paymentClass) {
        this.paymentClass = paymentClass;
    }

    public PaymentMethodSetting getPaymentMethodSetting() {
        return paymentMethodSetting;
    }

    public void setPaymentMethodSetting(PaymentMethodSetting paymentMethodSetting) {
        this.paymentMethodSetting = paymentMethodSetting;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public PaymentInterfaces getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(PaymentInterfaces interfaces) {
        this.interfaces = interfaces;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    public PermissionType getRestrictivePermission() {
        return restrictivePermission;
    }

    public void setRestrictivePermission(PermissionType restrictivePermission) {
        this.restrictivePermission = restrictivePermission;
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
