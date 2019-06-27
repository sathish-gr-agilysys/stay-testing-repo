/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.platform.user.model.Property;

public class FolioInvoiceResponse {

    private FolioInvoiceReservation folioInvoiceReservation;
    private FolioInvoiceAllocation folioInvoiceAllocation;
    private FolioInvoiceProfile folioInvoiceProfile;
    private FolioInvoiceLoyalityInfo folioInvoiceLoyalityInfo;
    private FolioInvoiceGroup folioInvoiceGroup;
    private String companyId;
    private String companyName;
    private String vatNumber;
    private String taxPoint;
    private String taxDate;
    private List<FolioInvoiceSummary> folioInvoiceSummaries;
    private String accountType;
    private boolean showGuestInfo;
    private String folioFooterMessage;
    private Property platformProperty;
    private String contentServicePublicUrl;
    private String totalAmount;
    private String totalBalance;
    private String totalPayment;
    private InvoiceStatus invoiceStatus;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String accountId;
    private LocalDate reportDate;
    private String userName;

    public FolioInvoiceReservation getFolioInvoiceReservation() {
        return folioInvoiceReservation;
    }

    public void setFolioInvoiceReservation(FolioInvoiceReservation folioInvoiceReservation) {
        this.folioInvoiceReservation = folioInvoiceReservation;
    }

    public FolioInvoiceAllocation getFolioInvoiceAllocation() {
        return folioInvoiceAllocation;
    }

    public void setFolioInvoiceAllocation(FolioInvoiceAllocation folioInvoiceAllocation) {
        this.folioInvoiceAllocation = folioInvoiceAllocation;
    }

    public FolioInvoiceProfile getFolioInvoiceProfile() {
        return folioInvoiceProfile;
    }

    public void setFolioInvoiceProfile(FolioInvoiceProfile folioInvoiceProfile) {
        this.folioInvoiceProfile = folioInvoiceProfile;
    }

    public FolioInvoiceLoyalityInfo getFolioInvoiceLoyalityInfo() {
        return folioInvoiceLoyalityInfo;
    }

    public void setFolioInvoiceLoyalityInfo(FolioInvoiceLoyalityInfo folioInvoiceLoyalityInfo) {
        this.folioInvoiceLoyalityInfo = folioInvoiceLoyalityInfo;
    }

    public FolioInvoiceGroup getFolioInvoiceGroup() {
        return folioInvoiceGroup;
    }

    public void setFolioInvoiceGroup(FolioInvoiceGroup folioInvoiceGroup) {
        this.folioInvoiceGroup = folioInvoiceGroup;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getTaxPoint() {
        return taxPoint;
    }

    public void setTaxPoint(String taxPoint) {
        this.taxPoint = taxPoint;
    }

    public String getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(String taxDate) {
        this.taxDate = taxDate;
    }

    public List<FolioInvoiceSummary> getFolioInvoiceSummaries() {
        return folioInvoiceSummaries;
    }

    public void setFolioInvoiceSummaries(List<FolioInvoiceSummary> folioInvoiceSummaries) {
        this.folioInvoiceSummaries = folioInvoiceSummaries;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {
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

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}