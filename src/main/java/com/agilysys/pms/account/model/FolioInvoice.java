/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;

public class FolioInvoice {

    private String id;
    private String tenantId;
    private String propertyId;
    private InvoiceStatus invoiceStatus;
    private String profileId;
    private String accountId;
    private String reservationId;
    private String confirmationCode;
    private String companyId;
    private String groupId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String invoiceNumber;
    private String roomId;
    private LocalDate taxPoint;
    private LocalDate taxDate;
    private String folioId;
    private List<String> folioLineItemIds;
    private List<LineItemView> folioLineItemViews;
    private BigDecimal totalAmount;
    private BigDecimal totalPayments;
    private BigDecimal totalBalances;
    private List<TaxBreakDown> taxBreakDowns;

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

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public LocalDate getTaxPoint() {
        return taxPoint;
    }

    public void setTaxPoint(LocalDate taxPoint) {
        this.taxPoint = taxPoint;
    }

    public LocalDate getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(LocalDate taxDate) {
        this.taxDate = taxDate;
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public List<String> getFolioLineItemIds() {
        return folioLineItemIds;
    }

    public void setFolioLineItemIds(List<String> folioLineItemIds) {
        this.folioLineItemIds = folioLineItemIds;
    }

    public List<LineItemView> getFolioLineItemViews() {
        return folioLineItemViews;
    }

    public void setFolioLineItemViews(List<LineItemView> folioLineItemViews) {
        this.folioLineItemViews = folioLineItemViews;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(BigDecimal totalPayments) {
        this.totalPayments = totalPayments;
    }

    public BigDecimal getTotalBalances() {
        return totalBalances;
    }

    public void setTotalBalances(BigDecimal totalBalances) {
        this.totalBalances = totalBalances;
    }

    public List<TaxBreakDown> getTaxBreakDowns() {
        return taxBreakDowns;
    }

    public void setTaxBreakDowns(List<TaxBreakDown> taxBreakDowns) {
        this.taxBreakDowns = taxBreakDowns;
    }
}
