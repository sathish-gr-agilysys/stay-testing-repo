/**
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Field;

public class InvoicePaymentCal {

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

    public boolean isFullAmountApplied() {
        return fullAmountApplied;
    }

    public void setFullAmountApplied(boolean fullAmountApplied) {
        this.fullAmountApplied = fullAmountApplied;
    }

    private boolean fullAmountApplied;
    private Boolean unAppliedAmountUsed;
    private List<InvoicePaymentCal> refunds;

    public InvoiceBalance getBalance() {
        return balance;
    }

    public void setBalance(InvoiceBalance balance) {
        this.balance = balance;
    }

    private InvoiceBalance balance;

    public InvoicePaymentCal() {
    }

    public List<InvoicePaymentCal> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<InvoicePaymentCal> refunds) {
        this.refunds = refunds;
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


    public Boolean getUnAppliedAmountUsed() {
        return unAppliedAmountUsed;
    }

    public void setUnAppliedAmountUsed(Boolean unAppliedAmountUsed) {
        this.unAppliedAmountUsed = unAppliedAmountUsed;
    }

    public InvoicePaymentCal(InvoicePaymentBalance invoicePaymentBalance, BigDecimal amount) {
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


    }

    public static class InvoiceBalance {
        public static final String SUBTOTAL_FIELD = "st";
        public static final String TOTAL_FIELD = "t";
        @Field(SUBTOTAL_FIELD)
        private BigDecimal subtotal;
        @Field(TOTAL_FIELD)
        private BigDecimal total;

        public InvoiceBalance(BigDecimal subtotal, BigDecimal total) {
            this.subtotal = subtotal;
            this.total = total;
        }

        public BigDecimal getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(BigDecimal subtotal) {
            this.subtotal = subtotal;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public void setTotal(BigDecimal total) {
            this.total = total;
        }
    }
}
