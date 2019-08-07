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
    private BigDecimal totalAmount;

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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPaymentAmount() {
        if (payments != null) {
            return payments.stream().map(InvoicePaymentView::getPaymentBalance)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return null;
    }

    public BigDecimal getOverdueAmount() {
        BigDecimal payment = getPaymentAmount();
        BigDecimal totalAmount = getTotalAmount();
        return payment != null ? totalAmount.add(payment) : totalAmount;
    }

    public LocalDate getInvoiceDueDate() {
        return invoiceDate.plusDays(terms);
    }
}
