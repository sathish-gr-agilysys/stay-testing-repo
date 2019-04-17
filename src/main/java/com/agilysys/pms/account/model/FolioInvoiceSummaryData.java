/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class FolioInvoiceSummaryData {

    private String accountId;
    private String folioName;
    private String folioId;
    private String paymentSettingId;
    private List<LineItemView> lineItemViews;
    private boolean hasLineItems;
    private BigDecimal totalChargesCurrency;
    private BigDecimal totalTaxCurrency;
    private BigDecimal totalChargesAndTaxesCurrency;
    private BigDecimal totalPaymentsCurrency;
    private BigDecimal totalBalanceCurrency;
    private String formattedTotalChargesCurrency;
    private String formattedTotalTaxCurrency;
    private String formattedTotalChargesAndTaxesCurrency;
    private String formattedTotalPaymentsCurrency;
    private String formattedTotalBalanceCurrency;
    private String pageBreakAfter;
    private List<TaxBreakDown> taxBreakDownList;
    private boolean showReason;

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

    public List<LineItemView> getLineItemViews() {
        return lineItemViews;
    }

    public void setLineItemViews(List<LineItemView> lineItemViews) {
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

    public String getFormattedTotalChargesCurrency() {
        return formattedTotalChargesCurrency;
    }

    public void setFormattedTotalChargesCurrency(String formattedTotalChargesCurrency) {
        this.formattedTotalChargesCurrency = formattedTotalChargesCurrency;
    }

    public String getFormattedTotalTaxCurrency() {
        return formattedTotalTaxCurrency;
    }

    public void setFormattedTotalTaxCurrency(String formattedTotalTaxCurrency) {
        this.formattedTotalTaxCurrency = formattedTotalTaxCurrency;
    }

    public String getFormattedTotalChargesAndTaxesCurrency() {
        return formattedTotalChargesAndTaxesCurrency;
    }

    public void setFormattedTotalChargesAndTaxesCurrency(String formattedTotalChargesAndTaxesCurrency) {
        this.formattedTotalChargesAndTaxesCurrency = formattedTotalChargesAndTaxesCurrency;
    }

    public String getFormattedTotalPaymentsCurrency() {
        return formattedTotalPaymentsCurrency;
    }

    public void setFormattedTotalPaymentsCurrency(String formattedTotalPaymentsCurrency) {
        this.formattedTotalPaymentsCurrency = formattedTotalPaymentsCurrency;
    }

    public String getFormattedTotalBalanceCurrency() {
        return formattedTotalBalanceCurrency;
    }

    public void setFormattedTotalBalanceCurrency(String formattedTotalBalanceCurrency) {
        this.formattedTotalBalanceCurrency = formattedTotalBalanceCurrency;
    }

    public List<TaxBreakDown> getTaxBreakDownList() {
        return taxBreakDownList;
    }

    public void setTaxBreakDownList(List<TaxBreakDown> taxBreakDownList) {
        this.taxBreakDownList = taxBreakDownList;
    }

    public boolean isShowReason() {
        return showReason;
    }

    public void setShowReason(boolean showReason) {
        this.showReason = showReason;
    }
}
