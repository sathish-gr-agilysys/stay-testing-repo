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
    protected String confirmationCode;
    protected String referenceId; // reservationId for GUEST, groupId for GROUP, companyProfileId for COMPANY
    protected LocalDate arrivalDate;
    protected LocalDate departureDate;
    protected String name;
    protected String groupCode;
    protected AddressDetails addressDetails;
    protected List<LineItemView> invoicedCharges = new ArrayList<>();
    protected BigDecimal chargesBalance = BigDecimal.ZERO;
    protected BigDecimal taxBalance = BigDecimal.ZERO;
    protected BigDecimal totalBalance = BigDecimal.ZERO;
    protected List<String> additionalGuestDetails;
    protected RoomInfo roomInfo;
    protected String reservationAlias;

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
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

    public List<String> getAdditionalGuestDetails() {
        return additionalGuestDetails;
    }

    public void setAdditionalGuestDetails(List<String> additionalGuestDetails) {
        this.additionalGuestDetails = additionalGuestDetails;
    }

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(RoomInfo roomInfo) {
        this.roomInfo = roomInfo;
    }

    public String getReservationAlias() {
        return reservationAlias;
    }

    public void setReservationAlias(String reservationAlias) {
        this.reservationAlias = reservationAlias;
    }
}
