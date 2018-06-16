/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class InvoiceView {
    private String id;
    private String tenantId;
    private String propertyId;
    private String accountId;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private List<InvoicedSourceAccountDetail> invoicedSourceAccounts;
    private List<GroupInvoiceDetail> groupInvoiceDetails;
    private List<InvoicePaymentView> payments;
    private InvoiceStatus invoiceStatus;
    private int terms;
    private int daysOverdue;
    private List<TaxAmountInfo> taxTotalsBreakdown;
    private DateTime sentOnDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
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

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

    public void setDaysOverdue(int daysOverdue) {
        this.daysOverdue = daysOverdue;
    }

    public List<TaxAmountInfo> getTaxTotalsBreakdown() {
        return taxTotalsBreakdown;
    }

    public void setTaxTotalsBreakdown(List<TaxAmountInfo> taxTotalsBreakdown) {
        this.taxTotalsBreakdown = taxTotalsBreakdown;
    }

    public List<InvoicedSourceAccountDetail> getInvoicedSourceAccounts() {
        return invoicedSourceAccounts;
    }

    public void setInvoicedSourceAccounts(List<InvoicedSourceAccountDetail> invoicedSourceAccounts) {
        this.invoicedSourceAccounts = invoicedSourceAccounts;
    }

    public List<GroupInvoiceDetail> getGroupInvoiceDetails() {
        return groupInvoiceDetails;
    }

    public void setGroupInvoiceDetails(List<GroupInvoiceDetail> groupInvoiceDetails) {
        this.groupInvoiceDetails = groupInvoiceDetails;
    }

    public List<InvoicePaymentView> getPayments() {
        return payments;
    }

    public void setPayments(List<InvoicePaymentView> payments) {
        this.payments = payments;
    }

    /**
     * @return amount of invoice
     */
    public BigDecimal getInvoiceChargesAmount() {
        BigDecimal balance = BigDecimal.ZERO;
        if (invoicedSourceAccounts != null) {
            balance = invoicedSourceAccounts.stream()
                  .map(invoicedSourceAccount -> invoicedSourceAccount.getChargesBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if(groupInvoiceDetails != null){
            balance = balance.add(groupInvoiceDetails.stream()
                  .map(groupNonInvoicedDetail -> groupNonInvoicedDetail.getChargesBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }

    /**
     * @return amount of invoice
     */
    public BigDecimal getInvoiceTaxAmount() {
        BigDecimal balance = BigDecimal.ZERO;
        if (invoicedSourceAccounts != null) {
            return invoicedSourceAccounts.stream().map(invoicedSourceAccount -> invoicedSourceAccount.getTaxBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if(groupInvoiceDetails != null){
            balance = balance.add(groupInvoiceDetails.stream()
                  .map(groupNonInvoicedDetail -> groupNonInvoicedDetail.getTaxBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }

    /**
     * @return amount of invoice
     */
    public BigDecimal getInvoiceTotalAmount() {
        BigDecimal balance = BigDecimal.ZERO;
        if (invoicedSourceAccounts != null) {
            return invoicedSourceAccounts.stream().map(invoicedSourceAccount -> invoicedSourceAccount.getTotalBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if(groupInvoiceDetails != null){
            balance = balance.add(groupInvoiceDetails.stream()
                  .map(groupNonInvoicedDetail -> groupNonInvoicedDetail.getTaxBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }

    /**
     * @return amount of payments and refunds made on invoice
     */
    public BigDecimal getPaymentAmount() {
        BigDecimal balance = BigDecimal.ZERO;
        if (payments != null) {
            return payments.stream().map(paymentView -> paymentView.getPaymentBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return BigDecimal.ZERO;
    }

    /**
     * @return balance of invoice (amount + payment)
     */
    public BigDecimal getInvoiceBalance() {
        return getInvoiceTotalAmount().add(getPaymentAmount());
    }

    public LocalDate getInvoiceDueDate() {
        return invoiceDate.plusDays(terms);
    }

    public DateTime getSentOnDate() {
        return sentOnDate;
    }

    public void setSentOnDate(DateTime sentOnDate) {
        this.sentOnDate = sentOnDate;
    }
}
