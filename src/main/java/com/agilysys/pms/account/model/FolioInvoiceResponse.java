/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.platform.user.model.Property;

public class FolioInvoiceResponse {

    private FolioInvoiceReservationData folioInvoiceReservationData;
    private FolioInvoiceAddressData folioInvoiceAddressData;
    private FolioInvoiceAllocationData folioInvoiceAllocationData;
    private FolioInvoiceProfileData folioInvoiceProfileData;
    private FolioInvoicePropertyData folioInvoicePropertyData;
    private FolioInvoiceLoyalityInfo folioInvoiceLoyalityInfo;
    private String groupId;
    private String groupName;
    private String companyId;
    private String companyName;
    private List<TaxBreakDown> taxBreakDownList;
    private String vatNumber;
    private LocalDate taxPoint;
    private LocalDate taxDate;
    private FolioInvoiceSummaryData folioInvoiceSummaryData;
    private String paymentSettingId;
    private String folioId;
    private String folioName;
    private String accountType;
    private boolean showGuestInfo;
    private String folioFooterMessage;
    private Property platformProperty;
    private String contentServicePublicUrl;
    private String folioInvoiceNumber;
    private List<LineItemView> lineItemViews;
    private BigDecimal totalAmount;
    private BigDecimal totalBalance;
    private BigDecimal totalPayment;
    private InvoiceStatus invoiceStatus;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String accountId;

    public FolioInvoiceReservationData getFolioInvoiceReservationData() {
        return folioInvoiceReservationData;
    }

    public void setFolioInvoiceReservationData(FolioInvoiceReservationData folioInvoiceReservationData) {
        this.folioInvoiceReservationData = folioInvoiceReservationData;
    }

    public FolioInvoiceAddressData getFolioInvoiceAddressData() {
        return folioInvoiceAddressData;
    }

    public void setFolioInvoiceAddressData(FolioInvoiceAddressData folioInvoiceAddressData) {
        this.folioInvoiceAddressData = folioInvoiceAddressData;
    }

    public FolioInvoiceAllocationData getFolioInvoiceAllocationData() {
        return folioInvoiceAllocationData;
    }

    public void setFolioInvoiceAllocationData(FolioInvoiceAllocationData folioInvoiceAllocationData) {
        this.folioInvoiceAllocationData = folioInvoiceAllocationData;
    }

    public FolioInvoiceProfileData getFolioInvoiceProfileData() {
        return folioInvoiceProfileData;
    }

    public void setFolioInvoiceProfileData(FolioInvoiceProfileData folioInvoiceProfileData) {
        this.folioInvoiceProfileData = folioInvoiceProfileData;
    }

    public FolioInvoicePropertyData getFolioInvoicePropertyData() {
        return folioInvoicePropertyData;
    }

    public void setFolioInvoicePropertyData(FolioInvoicePropertyData folioInvoicePropertyData) {
        this.folioInvoicePropertyData = folioInvoicePropertyData;
    }

    public FolioInvoiceLoyalityInfo getFolioInvoiceLoyalityInfo() {
        return folioInvoiceLoyalityInfo;
    }

    public void setFolioInvoiceLoyalityInfo(FolioInvoiceLoyalityInfo folioInvoiceLoyalityInfo) {
        this.folioInvoiceLoyalityInfo = folioInvoiceLoyalityInfo;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<TaxBreakDown> getTaxBreakDownList() {
        return taxBreakDownList;
    }

    public void setTaxBreakDownList(List<TaxBreakDown> taxBreakDownList) {
        this.taxBreakDownList = taxBreakDownList;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
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

    public FolioInvoiceSummaryData getFolioInvoiceSummaryData() {
        return folioInvoiceSummaryData;
    }

    public void setFolioInvoiceSummaryData(FolioInvoiceSummaryData folioInvoiceSummaryData) {
        this.folioInvoiceSummaryData = folioInvoiceSummaryData;
    }

    public String getPaymentSettingId() {
        return paymentSettingId;
    }

    public void setPaymentSettingId(String paymentSettingId) {
        this.paymentSettingId = paymentSettingId;
    }

    public String getFolioName() {
        return folioName;
    }

    public void setFolioName(String folioName) {
        this.folioName = folioName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean isShowGuestInfo() {
        return showGuestInfo;
    }

    public void setShowGuestInfo(boolean showGuestInfo) {
        this.showGuestInfo = showGuestInfo;
    }

    public String getFolioFooterMessage() {
        return folioFooterMessage;
    }

    public void setFolioFooterMessage(String folioFooterMessage) {
        this.folioFooterMessage = folioFooterMessage;
    }

    public Property getPlatformProperty() {
        return platformProperty;
    }

    public void setPlatformProperty(Property platformProperty) {
        this.platformProperty = platformProperty;
    }

    public String getContentServicePublicUrl() {
        return contentServicePublicUrl;
    }

    public void setContentServicePublicUrl(String contentServicePublicUrl) {
        this.contentServicePublicUrl = contentServicePublicUrl;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public String getFolioInvoiceNumber() {
        return folioInvoiceNumber;
    }

    public void setFolioInvoiceNumber(String folioInvoiceNumber) {
        this.folioInvoiceNumber = folioInvoiceNumber;
    }

    public List<LineItemView> getLineItemViews() {
        return lineItemViews;
    }

    public void setLineItemViews(List<LineItemView> lineItemViews) {
        this.lineItemViews = lineItemViews;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}