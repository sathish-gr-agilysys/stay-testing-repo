package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class InvoicePaymentView {
    // Needed so a client can reference an invoice payment to refund against
    private String id;
    private BigDecimal amount;
    private String paymentMethodId;
    private String paymentMethodName;
    private String reason;
    private LocalDate postingPropertyDate;
    private DateTime postingSystemDateTime;
    private LocalDate appliedOnPropertyDate;
    private DateTime appliedOnSystemDateTime;
    private List<InvoicePaymentView> refunds;
    // Needed so a client can reference a payment folio line item to refund against
    private String folioLineItemId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public LocalDate getPostingPropertyDate() {
        return postingPropertyDate;
    }

    public void setPostingPropertyDate(LocalDate postingPropertyDate) {
        this.postingPropertyDate = postingPropertyDate;
    }

    public DateTime getPostingSystemDateTime() {
        return postingSystemDateTime;
    }

    public void setPostingSystemDateTime(DateTime postingSystemDateTime) {
        this.postingSystemDateTime = postingSystemDateTime;
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

    public List<InvoicePaymentView> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<InvoicePaymentView> refunds) {
        this.refunds = refunds;
    }

    public String getFolioLineItemId() {
        return folioLineItemId;
    }

    public void setFolioLineItemId(String folioLineItemId) {
        this.folioLineItemId = folioLineItemId;
    }

    public BigDecimal getRefundTotal() {
        if (refunds != null && !refunds.isEmpty()) {
            return refunds.stream().map(refund -> refund.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return BigDecimal.ZERO;
    }

    public BigDecimal getPaymentBalance() {
        return amount.add(getRefundTotal());
    }

}
