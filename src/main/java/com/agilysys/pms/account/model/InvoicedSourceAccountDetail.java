/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.pms.profile.model.AddressDetails;

public class InvoicedSourceAccountDetail {
    protected String sourceAccountId;
    protected String sourceAccountName;
    protected String sourceAccountType;
    protected String referenceId; // reservationId for GUEST, groupId for GROUP, companyProfileId for COMPANY private LocalDate arrivalDate;
    protected LocalDate arrivalDate;
    protected LocalDate departureDate;
    protected String name;
    protected String groupCode;
    protected AddressDetails addressDetails;
    protected List<LineItemView> invoicedCharges;
    protected BigDecimal chargesBalance;
    protected BigDecimal taxBalance;
    protected BigDecimal totalBalance;

    public InvoicedSourceAccountDetail(){
        invoicedCharges = new ArrayList<>();
        chargesBalance = BigDecimal.ZERO;
        taxBalance = BigDecimal.ZERO;
        totalBalance = BigDecimal.ZERO;
    }

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

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LineItemView> getInvoicedCharges() {
        return invoicedCharges;
    }

    public void setInvoicedCharges(List<LineItemView> invoicedCharges) {
        this.invoicedCharges = invoicedCharges;
    }

    public BigDecimal getChargesBalance() {
        return chargesBalance;
    }

    public void setChargesBalance(BigDecimal chargesBalance) {
        this.chargesBalance = chargesBalance;
    }

    public BigDecimal getTaxBalance() {
        return taxBalance;
    }

    public void setTaxBalance(BigDecimal taxBalance) {
        this.taxBalance = taxBalance;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }
}
