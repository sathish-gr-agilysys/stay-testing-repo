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
    private String roomTypeId;
    private String roomId;
    private LocalDate taxPoint;
    private LocalDate taxDate;
    private String folioId;
    private List<String> folioLineItemIds;
    private BigDecimal totalAmount;
    private BigDecimal totalPayments;
    private BigDecimal totalBalances;
    private VATTotalBreakDown vatTotalBreakDown;
    private int numberOfAdults;
    private int numberOfChildren;
    private Integer numberOfAgeCategory1;
    private Integer numberOfAgeCategory2;
    private Integer numberOfAgeCategory3;
    private Integer numberOfAgeCategory4;
    private Integer numberOfAgeCategory5;
    private Integer numberOfAgeCategory6;
    private Integer numberOfAgeCategory7;
    private Integer numberOfAgeCategory8;

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

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
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

    public VATTotalBreakDown getVatTotalBreakDown() {
        return vatTotalBreakDown;
    }

    public void setVatTotalBreakDown(VATTotalBreakDown vatTotalBreakDown) {
        this.vatTotalBreakDown = vatTotalBreakDown;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Integer getNumberOfAgeCategory1() {
        return numberOfAgeCategory1 == null ? 0 : numberOfAgeCategory1;
    }

    public void setNumberOfAgeCategory1(Integer numberOfAgeCategory1) {
        this.numberOfAgeCategory1 = numberOfAgeCategory1;
    }

    public Integer getNumberOfAgeCategory2() {
        return numberOfAgeCategory2 == null ? 0 : numberOfAgeCategory2;
    }

    public void setNumberOfAgeCategory2(Integer numberOfAgeCategory2) {
        this.numberOfAgeCategory2 = numberOfAgeCategory2;
    }

    public Integer getNumberOfAgeCategory3() {
        return numberOfAgeCategory3 == null ? 0 : numberOfAgeCategory3;
    }

    public void setNumberOfAgeCategory3(Integer numberOfAgeCategory3) {
        this.numberOfAgeCategory3 = numberOfAgeCategory3;
    }

    public Integer getNumberOfAgeCategory4() {
        return numberOfAgeCategory4 == null ? 0 : numberOfAgeCategory4;
    }

    public void setNumberOfAgeCategory4(Integer numberOfAgeCategory4) {
        this.numberOfAgeCategory4 = numberOfAgeCategory4;
    }

    public Integer getNumberOfAgeCategory5() {
        return numberOfAgeCategory5 == null ? 0 : numberOfAgeCategory5;
    }

    public void setNumberOfAgeCategory5(Integer numberOfAgeCategory5) {
        this.numberOfAgeCategory5 = numberOfAgeCategory5;
    }

    public Integer getNumberOfAgeCategory6() {
        return numberOfAgeCategory6 == null ? 0 : numberOfAgeCategory6;
    }

    public void setNumberOfAgeCategory6(Integer numberOfAgeCategory6) {
        this.numberOfAgeCategory6 = numberOfAgeCategory6;
    }

    public Integer getNumberOfAgeCategory7() {
        return numberOfAgeCategory7 == null ? 0 : numberOfAgeCategory7;
    }

    public void setNumberOfAgeCategory7(Integer numberOfAgeCategory7) {
        this.numberOfAgeCategory7 = numberOfAgeCategory7;
    }

    public Integer getNumberOfAgeCategory8() {
        return numberOfAgeCategory8 == null ? 0 : numberOfAgeCategory8;
    }

    public void setNumberOfAgeCategory8(Integer numberOfAgeCategory8) {
        this.numberOfAgeCategory8 = numberOfAgeCategory8;
    }
}
