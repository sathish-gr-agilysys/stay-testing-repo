/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.base;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.agilysys.pms.account.model.InvoicePaymentView;
import com.agilysys.pms.account.model.InvoiceStatus;
import com.agilysys.pms.account.model.invoice.folio.detail.InvoiceDetailView;
import com.agilysys.pms.account.model.invoice.folio.search.InvoiceSearchView;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(value = {
      @JsonSubTypes.Type(name = "base", value = InvoiceBaseView.class),
      @JsonSubTypes.Type(name = "search", value = InvoiceSearchView.class),
      @JsonSubTypes.Type(name = "detail", value = InvoiceDetailView.class) })
public class InvoiceBaseView {
    private String id;

    private String accountId;
    private int daysOverdue;
    private LocalDate invoiceDate;
    private String invoiceNumber;
    private InvoiceStatus invoiceStatus;
    private List<InvoicePaymentView> payments;
    private String propertyId;
    private DateTime sentOnDate;
    private int terms;
    private BigDecimal invoiceChargesAmount;
    private BigDecimal invoiceTotalAmount;
    private BigDecimal paymentAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

    public void setDaysOverdue(int daysOverdue) {
        this.daysOverdue = daysOverdue;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public List<InvoicePaymentView> getPayments() {
        return payments;
    }

    public void setPayments(List<InvoicePaymentView> payments) {
        this.payments = payments;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public DateTime getSentOnDate() {
        return sentOnDate;
    }

    public void setSentOnDate(DateTime sentOnDate) {
        this.sentOnDate = sentOnDate;
    }

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public BigDecimal getInvoiceChargesAmount() {
        return invoiceChargesAmount;
    }

    public void setInvoiceChargesAmount(BigDecimal invoiceChargesAmount) {
        this.invoiceChargesAmount = invoiceChargesAmount;
    }

    public BigDecimal getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public void setInvoiceTotalAmount(BigDecimal totalAmount) {
        this.invoiceTotalAmount = totalAmount;
    }

    public BigDecimal getInvoiceTaxAmount() {
        return invoiceTotalAmount.subtract(invoiceChargesAmount);
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getOverdueAmount() {
        BigDecimal payment = getPaymentAmount();
        BigDecimal totalAmount = getInvoiceTotalAmount();
        return payment != null ? totalAmount.add(payment) : totalAmount;
    }

    public LocalDate getInvoiceDueDate() {
        return invoiceDate.plusDays(terms);
    }

    public String getType() {
        return "base";
    }
}
