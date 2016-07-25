/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.export;

import java.math.BigDecimal;
import java.util.List;

public class FolioDetailExport {
    private String id;
    private boolean defaultFolio;
    private String name;
    private String paymentSettingId;
    private List<LineItemViewExport> lineItems;

    private PaymentSettingExport paymentSetting;
    private PaymentMethodExport paymentMethod;
    private BigDecimal totalAmountDueForPaymentMethod;

    public PaymentSettingExport getPaymentSetting() {
        return paymentSetting;
    }

    public void setPaymentSetting(PaymentSettingExport paymentSetting) {
        this.paymentSetting = paymentSetting;
    }

    public PaymentMethodExport getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodExport paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotalAmountDueForPaymentMethod() {
        return totalAmountDueForPaymentMethod;
    }

    public void setTotalAmountDueForPaymentMethod(BigDecimal totalAmountDueForPaymentMethod) {
        this.totalAmountDueForPaymentMethod = totalAmountDueForPaymentMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDefaultFolio() {
        return defaultFolio;
    }

    public void setDefaultFolio(boolean defaultFolio) {
        this.defaultFolio = defaultFolio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentSettingId() {
        return paymentSettingId;
    }

    public void setPaymentSettingId(String paymentSettingId) {
        this.paymentSettingId = paymentSettingId;
    }

    public List<LineItemViewExport> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemViewExport> lineItems) {
        this.lineItems = lineItems;
    }
}