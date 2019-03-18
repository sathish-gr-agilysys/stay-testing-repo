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
    private List<FolioInvoiceFolioViewLineItem> lineItemViewList;
    private boolean hasLineItems;
    private BigDecimal totalChargesCurrency;
    private BigDecimal totalTaxCurrency;
    private BigDecimal totalChargesAndTaxesCurrency;
    private BigDecimal totalPaymentsCurrency;
    private BigDecimal totalBalanceCurrency;
    private String totalChargesCurrencys;
    private String totalTaxCurrencys;
    private String totalChargesAndTaxesCurrencys;
    private String totalPaymentsCurrencys;
    private String totalBalanceCurrencys;
    private String pageBreakAfter;

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

    public List<FolioInvoiceFolioViewLineItem> getLineItemViewList() {
        return lineItemViewList;
    }

    public void setLineItemViewList(List<FolioInvoiceFolioViewLineItem> lineItemViewList) {
        this.lineItemViewList = lineItemViewList;
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

    public String getTotalChargesCurrencys() {
        return totalChargesCurrencys;
    }

    public void setTotalChargesCurrencys(String totalChargesCurrencys) {
        this.totalChargesCurrencys = totalChargesCurrencys;
    }

    public String getTotalTaxCurrencys() {
        return totalTaxCurrencys;
    }

    public void setTotalTaxCurrencys(String totalTaxCurrencys) {
        this.totalTaxCurrencys = totalTaxCurrencys;
    }

    public String getTotalChargesAndTaxesCurrencys() {
        return totalChargesAndTaxesCurrencys;
    }

    public void setTotalChargesAndTaxesCurrencys(String totalChargesAndTaxesCurrencys) {
        this.totalChargesAndTaxesCurrencys = totalChargesAndTaxesCurrencys;
    }

    public String getTotalPaymentsCurrencys() {
        return totalPaymentsCurrencys;
    }

    public void setTotalPaymentsCurrencys(String totalPaymentsCurrencys) {
        this.totalPaymentsCurrencys = totalPaymentsCurrencys;
    }

    public String getTotalBalanceCurrencys() {
        return totalBalanceCurrencys;
    }

    public void setTotalBalanceCurrencys(String totalBalanceCurrencys) {
        this.totalBalanceCurrencys = totalBalanceCurrencys;
    }
}
