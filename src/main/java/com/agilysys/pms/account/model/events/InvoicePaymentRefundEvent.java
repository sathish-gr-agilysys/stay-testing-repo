/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import com.agilysys.common.constants.Constants;
import com.agilysys.pms.account.model.Balance;

public class InvoicePaymentRefundEvent extends InvoiceBalanceChangeEvent {
    private String invoicePaymentId;
    private BigDecimal amount;
    private String folioLineItemId;
    private String reason;
    private LocalDate lineItemPostingDate;
    private DateTime lineItemPostingSystemDateTime;
    private LocalDate appliedOnPropertyDate;
    private DateTime appliedOnSystemDateTime;
    private String paymentMethodName;
    private String reference;

    public InvoicePaymentRefundEvent() {}

    public InvoicePaymentRefundEvent(String invoicePaymentId, BigDecimal amount, String folioLineItemId, String reason,
          LocalDate lineItemPostingDate, DateTime lineItemPostingSystemDateTime, LocalDate appliedOnPropertyDate,
          DateTime appliedOnSystemDateTime, List<Map<String, Object>> historyMetadata) {
        this.invoicePaymentId = invoicePaymentId;
        this.amount = amount;
        this.folioLineItemId = folioLineItemId;
        this.reason = reason;
        this.lineItemPostingDate = lineItemPostingDate;
        this.lineItemPostingSystemDateTime = lineItemPostingSystemDateTime;
        this.appliedOnPropertyDate = appliedOnPropertyDate;
        this.appliedOnSystemDateTime = appliedOnSystemDateTime;
        this.historyMetadata = historyMetadata;
    }

    public InvoicePaymentRefundEvent(String invoicePaymentId, BigDecimal amount, String folioLineItemId, String reason,
          LocalDate lineItemPostingDate, DateTime lineItemPostingSystemDateTime, LocalDate appliedOnPropertyDate,
          DateTime appliedOnSystemDateTime, List<Map<String, Object>> historyMetadata, Balance balance) {
        super(balance);
        this.invoicePaymentId = invoicePaymentId;
        this.amount = amount;
        this.folioLineItemId = folioLineItemId;
        this.reason = reason;
        this.lineItemPostingDate = lineItemPostingDate;
        this.lineItemPostingSystemDateTime = lineItemPostingSystemDateTime;
        this.appliedOnPropertyDate = appliedOnPropertyDate;
        this.appliedOnSystemDateTime = appliedOnSystemDateTime;
        this.historyMetadata = historyMetadata;
    }

    public InvoicePaymentRefundEvent(String invoicePaymentId, BigDecimal amount, String folioLineItemId,
          String paymentMethodName, String reason, LocalDate lineItemPostingDate,
          DateTime lineItemPostingSystemDateTime, LocalDate appliedOnPropertyDate, DateTime appliedOnSystemDateTime,
          List<Map<String, Object>> historyMetadata, Balance balance, String reference) {
        this(invoicePaymentId, amount, folioLineItemId, reason, lineItemPostingDate, lineItemPostingSystemDateTime,
              appliedOnPropertyDate, appliedOnSystemDateTime, historyMetadata, balance);
        this.paymentMethodName = paymentMethodName;
        this.reference = reference;
    }

    public String getInvoicePaymentId() {
        return invoicePaymentId;
    }

    public void setInvoicePaymentId(String invoicePaymentId) {
        this.invoicePaymentId = invoicePaymentId;
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

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public List<String> getHistoryMessages() {
        return Collections.singletonList(
              String.format("Refund applied to payment on invoice. [Payment method: %s, Amount: %s, Applied date: %s]",
                    paymentMethodName, amount, appliedOnPropertyDate.toString(Constants.INVOICE_EVENTS_DATE_FORMAT)));
    }

    @Override
    public String getEventType() {
        return "Refund";
    }
 }
