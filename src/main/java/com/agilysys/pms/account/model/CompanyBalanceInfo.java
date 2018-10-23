/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.agilysys.pms.account.model.AccountAttributes.PreferredCommunication;

public class CompanyBalanceInfo {

    private String id;
    private String name;
    private PreferredCommunication deliveryPreference;
    private String email;

    private Collection<BigDecimal> invoiceTotalsByAging; //invoiceTotalByAgeGroup
    private BigDecimal invoicedTotal; //  sum(invoiceTotalsByAgeGroups)
    private BigDecimal unInvoicedTotal;
    private BigDecimal balance; // subTotal + unInvoicedTotal

    private List<PropertyBalanceInfo> properties;

    public CompanyBalanceInfo(String id, String name) {
        this.id = id;
        this.name = name;
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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Collection<BigDecimal> getInvoiceTotalsByAging() { return invoiceTotalsByAging; }

    public void setInvoiceTotalsByAging(Collection<BigDecimal> invoiceTotalsByAging) {
        this.invoiceTotalsByAging = invoiceTotalsByAging;
    }

    public BigDecimal getInvoiceTotal() {
        return invoicedTotal;
    }

    public void setInvoiceTotal(BigDecimal invoicedTotal) {
        this.invoicedTotal = invoicedTotal;
    }

    public BigDecimal getUnInvoicedTotal() {
        return unInvoicedTotal;
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

    public List<PropertyBalanceInfo> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyBalanceInfo> properties) {
        this.properties = properties;
    }
}