/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model.events;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class InvoicePaymentRefundEvent extends InvoiceFolioLineItemEvent {
    private BigDecimal amount;
    private String invoicePaymentId;
    private String folioLineItemId;
    private String reason;
    private LocalDate lineItemPostingDate;
    private DateTime lineItemPostingSystemDateTime;
    private LocalDate appliedOnPropertyDate;
    private DateTime appliedOnSystemDateTime;

    public InvoicePaymentRefundEvent(BigDecimal amount, String invoicePaymentId, String folioLineItemId, String reason,
          LocalDate lineItemPostingDate, DateTime lineItemPostingSystemDateTime, LocalDate appliedOnPropertyDate,
          DateTime appliedOnSystemDateTime, List<Map<String, Object>> historyMetadata, boolean closed) {
        super(closed);

        this.amount = amount;
        this.invoicePaymentId = invoicePaymentId;
        this.folioLineItemId = folioLineItemId;
        this.reason = reason;
        this.lineItemPostingDate = lineItemPostingDate;
        this.lineItemPostingSystemDateTime = lineItemPostingSystemDateTime;
        this.appliedOnPropertyDate = appliedOnPropertyDate;
        this.appliedOnSystemDateTime = appliedOnSystemDateTime;
        this.historyMetadata = historyMetadata;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getInvoicePaymentId() {
        return invoicePaymentId;
    }

    public void setInvoicePaymentId(String invoicePaymentId) {
        this.invoicePaymentId = invoicePaymentId;
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

    @Override
    public List<String> getHistoryMessages() {
        // TODO create a better message for the event history
        return Arrays.asList("Refund applied to payment on invoice.");
    }

    @Override
    public long getEventVersion() {
        return 0;
    }
}
