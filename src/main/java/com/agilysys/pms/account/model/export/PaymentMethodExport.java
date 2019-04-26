/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.export;

import java.util.Set;

import com.agilysys.common.model.export.PaymentMethodSettingExport;

/**
 * Class to represent a PaymentMethod
 */
public class PaymentMethodExport extends AccountingItemExport {
    //CC is the code for Credit Card in bootstrap data
    public static String CREDIT_CARD_CODE = "CC";
    //DB is the code for direct bill in bootstrap data, it is the default for company accounts
    public static String DIRECT_BILL_CODE = "DB";
    //CASH is the code for cash in bootstrap data, it is the default for groups
    public static String CASH_CODE = "CASH";

    private PaymentClassExport paymentClass;
    private PaymentMethodSettingExport paymentMethodSetting;
    private String issuer;
    private PaymentInterfacesExport interfaces;
    private Set<String> sourceIds;
    private String glCode;

    public Set<String> getSourceIds() {
        return sourceIds;
    }

    public void setSourceIds(Set<String> sourceIds) {
        this.sourceIds = sourceIds;
    }

    public PaymentClassExport getPaymentClass() {
        return paymentClass;
    }

    public void setPaymentClass(PaymentClassExport paymentClass) {
        this.paymentClass = paymentClass;
    }

    public PaymentMethodSettingExport getPaymentMethodSetting() {
        return paymentMethodSetting;
    }

    public void setPaymentMethodSetting(PaymentMethodSettingExport paymentMethodSetting) {
        this.paymentMethodSetting = paymentMethodSetting;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public PaymentInterfacesExport getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(PaymentInterfacesExport interfaces) {
        this.interfaces = interfaces;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }
}
