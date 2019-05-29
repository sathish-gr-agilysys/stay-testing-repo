/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.pms.profile.model.AddressDetails;

public class NonInvoicedSourceAccountDetail {
    protected String sourceAccountId;
    protected String sourceAccountType;
    protected String sourceAccountName;
    protected String referenceId; // reservationId for GUEST, groupId for GROUP, companyProfileId for COMPANY
    protected LocalDate arrivalDate;
    protected LocalDate departureDate;
    protected String name;
    protected String groupCode;
    protected AddressDetails addressDetails;
    protected List<LineItemView> nonInvoicedCharges = new ArrayList<>();
    protected List<LineItemView> nonInvoicePayments = new ArrayList<>();
    protected BigDecimal nonInvoicedChargesBalance = BigDecimal.ZERO;
    protected BigDecimal nonInvoicedChargesTaxBalance = BigDecimal.ZERO;
    protected BigDecimal nonInvoicedChargesTotalBalance = BigDecimal.ZERO;
    protected BigDecimal nonInvoicedPaymentsTotalBalance = BigDecimal.ZERO;

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getSourceAccountType() {
        return sourceAccountType;
    }

    public void setSourceAccountType(String sourceAccountType) {
        this.sourceAccountType = sourceAccountType;
    }

    public String getSourceAccountName() {
        return sourceAccountName;
    }

    public void setSourceAccountName(String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
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

    public List<LineItemView> getNonInvoicedCharges() {
        return nonInvoicedCharges;
    }

    public void setNonInvoicedCharges(List<LineItemView> nonInvoicedCharges) {
        this.nonInvoicedCharges = nonInvoicedCharges;
    }

    public List<LineItemView> getNonInvoicePayments() {
        return nonInvoicePayments;
    }

    public void setNonInvoicePayments(List<LineItemView> nonInvoicePayments) {
        this.nonInvoicePayments = nonInvoicePayments;
    }

    public BigDecimal getNonInvoicedChargesBalance() {
        return nonInvoicedChargesBalance;
    }

    public void setNonInvoicedChargesBalance(BigDecimal nonInvoicedChargesBalance) {
        this.nonInvoicedChargesBalance = nonInvoicedChargesBalance;
    }

    public BigDecimal getNonInvoicedChargesTaxBalance() {
        return nonInvoicedChargesTaxBalance;
    }

    public void setNonInvoicedChargesTaxBalance(BigDecimal nonInvoicedChargesTaxBalance) {
        this.nonInvoicedChargesTaxBalance = nonInvoicedChargesTaxBalance;
    }

    public BigDecimal getNonInvoicedChargesTotalBalance() {
        return nonInvoicedChargesTotalBalance;
    }

    public void setNonInvoicedChargesTotalBalance(BigDecimal nonInvoicedChargesTotalBalance) {
        this.nonInvoicedChargesTotalBalance = nonInvoicedChargesTotalBalance;
    }

    public BigDecimal getNonInvoicedPaymentsTotalBalance() {
        return nonInvoicedPaymentsTotalBalance;
    }

    public void setNonInvoicedPaymentsTotalBalance(BigDecimal nonInvoicedPaymentsTotalBalance) {
        this.nonInvoicedPaymentsTotalBalance = nonInvoicedPaymentsTotalBalance;
    }
}
