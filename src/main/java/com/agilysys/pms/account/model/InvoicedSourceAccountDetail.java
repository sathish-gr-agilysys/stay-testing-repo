/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;

public class InvoicedSourceAccountDetail {
    private String sourceAccountId;
    private String sourceAccountName;
    private String sourceAccountType;
    private String referenceId; // reservationId for GUEST, groupId for GROUP, companyProfileId for COMPANY
    private List<LineItemView> invoicedCharges;
    private String name;
    private LocalDate arrivalDate;
    private LocalDate departureDate;

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getSourceAccountName() {
        return sourceAccountName;
    }

    public void setSourceAccountName(String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
    }

    public String getSourceAccountType() {
        return sourceAccountType;
    }

    public void setSourceAccountType(String sourceAccountType) {
        this.sourceAccountType = sourceAccountType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public List<LineItemView> getInvoicedCharges() {
        return invoicedCharges;
    }

    public void setInvoicedCharges(List<LineItemView> invoicedCharges) {
        this.invoicedCharges = invoicedCharges;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public LocalDate getArrivalDate() { return arrivalDate; }

    public void setArrivalDate(LocalDate arrivalDate) { this.arrivalDate = arrivalDate; }

    public LocalDate getDepartureDate() { return departureDate; }

    public void setDepartureDate(LocalDate departureDate) { this.departureDate = departureDate; }

    public BigDecimal getChargesBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        if (invoicedCharges != null) {
            for (LineItemView invoicedChargeItem : invoicedCharges) {
                balance = balance.add(invoicedChargeItem.getLineItemChargesBalance());
            }
        }
        return balance;
    }

    public BigDecimal getTaxBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        if (invoicedCharges != null) {
            for (LineItemView invoicedChargeItem : invoicedCharges) {
                balance = balance.add(invoicedChargeItem.getLineItemTaxBalance());
            }
        }
        return balance;
    }

    public BigDecimal getTotalBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        if (invoicedCharges != null) {
            for (LineItemView invoicedChargeItem : invoicedCharges) {
                balance = balance.add(invoicedChargeItem.getLineItemBalance());
            }
        }
        return balance;
    }
}
