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
    protected String referenceId; // reservationId for GUEST, groupId for GROUP, companyProfileId for COMPANYprivate LocalDate arrivalDate;
    protected LocalDate arrivalDate;
    protected LocalDate departureDate;
    protected String name;
    protected String groupCode;
    protected AddressDetails addressDetails;
    protected List<LineItemView> nonInvoicedCharges;
    protected List<LineItemView> nonInvoicePayments;

    public NonInvoicedSourceAccountDetail(){
        nonInvoicedCharges = new ArrayList<>();
        nonInvoicePayments = new ArrayList<>();
    }

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
        if (nonInvoicedCharges != null) {
            return nonInvoicedCharges.stream().map(nonInvoicedCharge -> nonInvoicedCharge.getLineItemChargesBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return BigDecimal.ZERO;
    }

    public BigDecimal getNonInvoicedChargesTaxBalance() {
        if (nonInvoicedCharges != null) {
            return nonInvoicedCharges.stream().map(nonInvoicedCharge -> nonInvoicedCharge.getLineItemTaxBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return BigDecimal.ZERO;
    }

    public BigDecimal getNonInvoicedChargesTotalBalance() {
        if (nonInvoicedCharges != null) {
            return nonInvoicedCharges.stream().map(nonInvoicedCharge -> nonInvoicedCharge.getLineItemBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return BigDecimal.ZERO;
    }

    public BigDecimal getNonInvoicedPaymentsTotalBalance() {
        if (nonInvoicePayments != null) {
            return nonInvoicePayments.stream().map(nonInvoicePayment -> nonInvoicePayment.getLineItemBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return BigDecimal.ZERO;
    }
}
