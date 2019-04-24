/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Collection;

import com.agilysys.pms.account.model.AccountAttributes.PreferredCommunication;

public class PropertyBalanceInfo {
    private String id;
    private String name;
    private PreferredCommunication deliveryPreference;

    private String accountId;
    private String email;

    private boolean readOnly;
    private boolean closed;

    private Collection<BigDecimal> invoiceTotalsByAging; //invoiceTotalByAgeGroup
    private BigDecimal invoicedTotal; // invoiceTotal = sum(invoiceTotalsByAgeGroups)
    private BigDecimal unInvoicedTotal; // sum(unInvoicedCharges)
    private BigDecimal balance; // balance = subTotal + unInvoicedTotal

    public PropertyBalanceInfo(String id, String name) {
        this.id = id;
        this.name = name;
        this.deliveryPreference = PreferredCommunication.Print;
    }

    public PropertyBalanceInfo(String id, String name, boolean readOnly) {
        this(id, name);
        this.readOnly = readOnly;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PreferredCommunication getDeliveryPreference() {
        return deliveryPreference;
    }

    public void setDeliveryPreference(PreferredCommunication deliveryPreference) {
        this.deliveryPreference = deliveryPreference;
    }

    public String getAccountId() { return accountId; }

    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Collection<BigDecimal> getInvoiceTotalsByAging() { return invoiceTotalsByAging; }

    public void setInvoiceTotalsByAging(Collection<BigDecimal> invoiceTotalsByAging) {
        this.invoiceTotalsByAging = invoiceTotalsByAging;
    }

    public void setInvoiceTotal(BigDecimal invoicedTotal) {
        this.invoicedTotal = invoicedTotal;
    }

    public BigDecimal getInvoiceTotal() {
        return invoicedTotal;
    }

    public BigDecimal getUnInvoicedTotal() {
        return unInvoicedTotal == null ? BigDecimal.ZERO : unInvoicedTotal;
    }

    public void setUnInvoicedTotal(BigDecimal unInvoicedTotal) {
        this.unInvoicedTotal = unInvoicedTotal;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
