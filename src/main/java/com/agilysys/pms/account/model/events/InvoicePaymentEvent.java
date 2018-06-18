/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model.events;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.agilysys.common.constants.Constants;

public class InvoicePaymentEvent extends InvoiceBalanceChangeEvent {
    private String invoicePaymentId;
    private BigDecimal amount;
    private String folioLineItemId;
    private String paymentMethodId;
    private String paymentMethodName;
    private String reason;
    private LocalDate lineItemPostingDate;
    private DateTime lineItemPostingSystemDateTime;
    private LocalDate appliedOnPropertyDate;
    private DateTime appliedOnSystemDateTime;
    private boolean isFullAmountApplied;

    public InvoicePaymentEvent() { super(); }

    public InvoicePaymentEvent(String invoicePaymentId, BigDecimal amount, String folioLineItemId,
          String paymentMethodId, String paymentMethodName, String reason, LocalDate lineItemPostingDate,
          DateTime lineItemPostingSystemDateTime, LocalDate appliedOnPropertyDate, DateTime appliedOnSystemDateTime,
          boolean isFullAmountApplied) {

        this.invoicePaymentId = invoicePaymentId;
        this.amount = amount;
        this.folioLineItemId = folioLineItemId;
        this.paymentMethodId = paymentMethodId;
        this.paymentMethodName = paymentMethodName;
        this.reason = reason;
        this.lineItemPostingDate = lineItemPostingDate;
        this.lineItemPostingSystemDateTime = lineItemPostingSystemDateTime;
        this.appliedOnPropertyDate = appliedOnPropertyDate;
        this.appliedOnSystemDateTime = appliedOnSystemDateTime;
        this.isFullAmountApplied = isFullAmountApplied;
    }

    public String getInvoicePaymentId() { return invoicePaymentId; }

    public void setInvoicePaymentId(String invoicePaymentId) { this.invoicePaymentId = invoicePaymentId; }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public boolean isFullAmountApplied() {
        return isFullAmountApplied;
    }

    public void setFullAmountApplied(boolean isFullAmountApplied) {
        this.isFullAmountApplied = isFullAmountApplied;
    }

    @Override
    public List<String> getHistoryMessages() {
        return Arrays.asList(
              String.format("Payment applied to invoice. [Payment method: %s, Amount: %s, Applied date: %s]",
                    paymentMethodName, amount, appliedOnPropertyDate.toString(Constants.INVOICE_EVENTS_DATE_FOTRMAT)));
    }

    @Override
    public long getEventVersion() {
        return 0;
    }
}
