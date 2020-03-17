/**
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class InvoicePaymentBalance {

    private String id;
    private String accountId;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private BigDecimal amount;
    private String folioLineItemId;
    private String paymentMethodId;
    private String paymentMethodName;
    private LocalDate lineItemPostingDate;
    private DateTime lineItemPostingSystemDateTime;
    private LocalDate appliedOnPropertyDate;
    private DateTime appliedOnSystemDateTime;
    private String userId;
    private Boolean fullAmountApplied;
    private Boolean unAppliedAmountUsed;
    private List<BigDecimal> refunds;
    private BigDecimal subTotal;
    private BigDecimal total;
    private BigDecimal totalInvoicePayment;

    public InvoicePaymentBalance() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFolioLineItemId() {
        return folioLineItemId;
    }

    public void setFolioLineItemId(String folioLineItemId) {
        this.folioLineItemId = folioLineItemId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public LocalDate getLineItemPostingDate() {
        return lineItemPostingDate;
    }

    public void setLineItemPostingDate(LocalDate lineItemPostingDate) {
        this.lineItemPostingDate = lineItemPostingDate;
    }

    public DateTime getLineItemPostingSystemDateTime() {
        return lineItemPostingSystemDateTime;
    }

    public void setLineItemPostingSystemDateTime(DateTime lineItemPostingSystemDateTime) {
        this.lineItemPostingSystemDateTime = lineItemPostingSystemDateTime;
    }

    public LocalDate getAppliedOnPropertyDate() {
        return appliedOnPropertyDate;
    }

    public void setAppliedOnPropertyDate(LocalDate appliedOnPropertyDate) {
        this.appliedOnPropertyDate = appliedOnPropertyDate;
    }

    public DateTime getAppliedOnSystemDateTime() {
        return appliedOnSystemDateTime;
    }

    public void setAppliedOnSystemDateTime(DateTime appliedOnSystemDateTime) {
        this.appliedOnSystemDateTime = appliedOnSystemDateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getFullAmountApplied() {
        return fullAmountApplied;
    }

    public void setFullAmountApplied(boolean fullAmountApplied) {
        this.fullAmountApplied = fullAmountApplied;
    }

    public Boolean getUnAppliedAmountUsed() {
        return unAppliedAmountUsed;
    }

    public void setUnAppliedAmountUsed(Boolean unAppliedAmountUsed) {
        this.unAppliedAmountUsed = unAppliedAmountUsed;
    }

    public List<BigDecimal> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<BigDecimal> refunds) {
        this.refunds = refunds;
    }

    public BigDecimal getTotalInvoicePayment() {
        return totalInvoicePayment;
    }

    public void setTotalInvoicePayment(BigDecimal totalInvoicePayment) {
        this.totalInvoicePayment = totalInvoicePayment;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public InvoicePaymentBalance(InvoicePaymentBalance invoicePaymentBalance, BigDecimal amount) {
        this.id = invoicePaymentBalance.getId();
        this.accountId = invoicePaymentBalance.getAccountId();
        this.invoiceNumber = invoicePaymentBalance.getInvoiceNumber();
        this.invoiceDate = invoicePaymentBalance.getInvoiceDate();
        this.folioLineItemId = invoicePaymentBalance.getFolioLineItemId();
        this.paymentMethodId = invoicePaymentBalance.getPaymentMethodId();
        this.paymentMethodName = invoicePaymentBalance.getPaymentMethodName();
        this.lineItemPostingDate = invoicePaymentBalance.getLineItemPostingDate();
        this.lineItemPostingSystemDateTime = invoicePaymentBalance.getLineItemPostingSystemDateTime();
        this.appliedOnPropertyDate = invoicePaymentBalance.getAppliedOnPropertyDate();
        this.appliedOnSystemDateTime = invoicePaymentBalance.getAppliedOnSystemDateTime();
        this.userId = invoicePaymentBalance.getUserId();
        this.fullAmountApplied = invoicePaymentBalance.getFullAmountApplied();
        this.unAppliedAmountUsed = invoicePaymentBalance.getUnAppliedAmountUsed();
        this.subTotal = invoicePaymentBalance.getSubTotal();
        this.total = invoicePaymentBalance.getTotal();

    }

}
