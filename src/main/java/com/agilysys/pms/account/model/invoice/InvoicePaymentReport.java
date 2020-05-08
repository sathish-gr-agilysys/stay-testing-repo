/**
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class InvoicePaymentReport {

    private String accountId;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private BigDecimal amount;
    private String folioLineItemId;
    private BigDecimal lineItemAmount;
    private String paymentMethodId;
    private String paymentMethodName;
    private LocalDate lineItemPostingDate;
    private DateTime lineItemPostingSystemDateTime;
    private LocalDate appliedOnPropertyDate;
    private DateTime appliedOnSystemDateTime;
    private String reason;
    private String userId;
    private Boolean fullAmountApplied;
    private Boolean unAppliedAmountUsed;
    private BigDecimal invoiceTotal;
    private BigDecimal invoiceBalance;
    private String companyId;
    private String companyName;
    private BigDecimal creditLimit;
    private String accountNumber;
    private String contactId;

    public InvoicePaymentReport() {
    }

    public InvoicePaymentReport(String accountId, String invoiceNumber, LocalDate invoiceDate, BigDecimal amount,
          String folioLineItemId, BigDecimal lineItemAmount, String paymentMethodId, String paymentMethodName,
          LocalDate lineItemPostingDate, DateTime lineItemPostingSystemDateTime, LocalDate appliedOnPropertyDate,
          DateTime appliedOnSystemDateTime, String reason, String userId, Boolean fullAmountApplied,
          Boolean unAppliedAmountUsed, BigDecimal invoiceTotal, BigDecimal invoiceBalance, String companyId,
          String companyName, BigDecimal creditLimit, String accountNumber, String contactId) {
        this.accountId = accountId;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.folioLineItemId = folioLineItemId;
        this.lineItemAmount = lineItemAmount;
        this.paymentMethodId = paymentMethodId;
        this.paymentMethodName = paymentMethodName;
        this.lineItemPostingDate = lineItemPostingDate;
        this.lineItemPostingSystemDateTime = lineItemPostingSystemDateTime;
        this.appliedOnPropertyDate = appliedOnPropertyDate;
        this.appliedOnSystemDateTime = appliedOnSystemDateTime;
        this.reason = reason;
        this.userId = userId;
        this.fullAmountApplied = fullAmountApplied;
        this.unAppliedAmountUsed = unAppliedAmountUsed;
        this.invoiceTotal = invoiceTotal;
        this.invoiceBalance = invoiceBalance;
        this.companyId = companyId;
        this.companyName = companyName;
        this.creditLimit = creditLimit;
        this.accountNumber = accountNumber;
        this.contactId = contactId;
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

    public String getFolioLineItemId() {
        return folioLineItemId;
    }

    public void setFolioLineItemId(String folioLineItemId) {
        this.folioLineItemId = folioLineItemId;
    }

    public BigDecimal getLineItemAmount() {
        return lineItemAmount;
    }

    public void setLineItemAmount(BigDecimal lineItemAmount) {
        this.lineItemAmount = lineItemAmount;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public void setFullAmountApplied(Boolean fullAmountApplied) {
        this.fullAmountApplied = fullAmountApplied;
    }

    public Boolean getUnAppliedAmountUsed() {
        return unAppliedAmountUsed;
    }

    public void setUnAppliedAmountUsed(Boolean unAppliedAmountUsed) {
        this.unAppliedAmountUsed = unAppliedAmountUsed;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public BigDecimal getInvoiceBalance() {
        return invoiceBalance;
    }

    public void setInvoiceBalance(BigDecimal invoiceBalance) {
        this.invoiceBalance = invoiceBalance;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

}
