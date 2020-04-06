/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.common.template.TemplateData;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FolioInvoiceSummary implements TemplateData {

    private String accountId;
    private String folioName;
    private String folioId;
    private String paymentSettingId;
    private List<FolioInvoiceLineItemView> lineItemViews;
    private boolean hasLineItems;
    private BigDecimal totalChargesCurrency;
    private BigDecimal totalTaxCurrency;
    private BigDecimal totalChargesAndTaxesCurrency;
    private BigDecimal totalPaymentsCurrency;
    private BigDecimal totalBalanceCurrency;
    private String pageBreakAfter;
    private VATTotalBreakDown vatTotalBreakDown;
    private String folioInvoiceNumber;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFolioName() {
        return folioName;
    }

    public void setFolioName(String folioName) {
        this.folioName = folioName;
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public String getPaymentSettingId() {
        return paymentSettingId;
    }

    public void setPaymentSettingId(String paymentSettingId) {
        this.paymentSettingId = paymentSettingId;
    }

    public List<FolioInvoiceLineItemView> getLineItemViews() {
        return lineItemViews;
    }

    public void setLineItemViews(List<FolioInvoiceLineItemView> lineItemViews) {
        this.lineItemViews = lineItemViews;
    }

    public boolean isHasLineItems() {
        return hasLineItems;
    }

    public void setHasLineItems(boolean hasLineItems) {
        this.hasLineItems = hasLineItems;
    }

    public BigDecimal getTotalChargesCurrency() {
        return totalChargesCurrency;
    }

    public void setTotalChargesCurrency(BigDecimal totalChargesCurrency) {
        this.totalChargesCurrency = totalChargesCurrency;
    }

    public BigDecimal getTotalTaxCurrency() {
        return totalTaxCurrency;
    }

    public void setTotalTaxCurrency(BigDecimal totalTaxCurrency) {
        this.totalTaxCurrency = totalTaxCurrency;
    }

    public BigDecimal getTotalChargesAndTaxesCurrency() {
        return totalChargesAndTaxesCurrency;
    }

    public void setTotalChargesAndTaxesCurrency(BigDecimal totalChargesAndTaxesCurrency) {
        this.totalChargesAndTaxesCurrency = totalChargesAndTaxesCurrency;
    }

    public BigDecimal getTotalPaymentsCurrency() {
        return totalPaymentsCurrency;
    }

    public void setTotalPaymentsCurrency(BigDecimal totalPaymentsCurrency) {
        this.totalPaymentsCurrency = totalPaymentsCurrency;
    }

    public BigDecimal getTotalBalanceCurrency() {
        return totalBalanceCurrency;
    }

    public void setTotalBalanceCurrency(BigDecimal totalBalanceCurrency) {
        this.totalBalanceCurrency = totalBalanceCurrency;
    }

    public String getPageBreakAfter() {
        return pageBreakAfter;
    }

    public void setPageBreakAfter(String pageBreakAfter) {
        this.pageBreakAfter = pageBreakAfter;
    }

    public VATTotalBreakDown getVatTotalBreakDown() {
        return vatTotalBreakDown;
    }

    public void setVatTotalBreakDown(VATTotalBreakDown vatTotalBreakDown) {
        this.vatTotalBreakDown = vatTotalBreakDown;
    }

    public String getFolioInvoiceNumber() {
        return folioInvoiceNumber;
    }

    public void setFolioInvoiceNumber(String folioInvoiceNumber) {
        this.folioInvoiceNumber = folioInvoiceNumber;
    }

    @Override
    public Map<String, Object> rawFields() {
        Map<String, Object> rawFieldMap = new HashMap<>(3);
        if (totalChargesAndTaxesCurrency != null) {
            rawFieldMap.put(TemplateData.rawField("totalChargesAndTaxesCurrency"), totalChargesAndTaxesCurrency);
        }
        if (totalPaymentsCurrency != null) {
            rawFieldMap.put(TemplateData.rawField("totalPaymentsCurrency"), totalPaymentsCurrency);
        }
        if (totalBalanceCurrency != null) {
            rawFieldMap.put(TemplateData.rawField("totalBalanceCurrency"), totalBalanceCurrency);
        }

        return rawFieldMap;
    }
}
