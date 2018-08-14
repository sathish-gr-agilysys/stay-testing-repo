/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

public class AccountSearchResult {
    // values shared by different account types
    private String tenantId;

    private String propertyId;

    private String accountId;

    private String accountType;

    private String accountStatus;

    private String name;

    private String number;

    private BigDecimal accountBalance;

    private List<FolioBalance> folios;

    private DateTime arrivalDate;

    private DateTime departureDate;

    // TODO the requirements for this are currently pretty vague, we need to
    // figure out if there are multiple types of statuses such as VIP that an
    // Account can have and how to return them in the search results
    private String vipStatus;

    // specific guest account values
    private String reservationConfirmationId;

    private String reservationStatus;

    private String roomType;

    private String roomNumber;

    // group account values
    private String groupCode;

    private String bookingStatus;

    public AccountSearchResult() {}

    public AccountSearchResult(String accountId, String accountType, String name, String propertyId, String tenantId) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.name = name;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
    }

    public AccountSearchResult(String accountId, String accountType, DateTime arrivalDate, String bookingStatus,
          DateTime departureDate, String groupCode, String name, String propertyId, String tenantId) {
        this(accountId, accountType, name, propertyId, tenantId);

        this.arrivalDate = arrivalDate;
        this.bookingStatus = bookingStatus;
        this.departureDate = departureDate;
        this.groupCode = groupCode;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<FolioBalance> getFolios() {
        return folios;
    }

    public void setFolios(List<FolioBalance> folios) {
        this.folios = folios;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(DateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public DateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(DateTime departureDate) {
        this.departureDate = departureDate;
    }

    public String getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

    public String getReservationConfirmationId() {
        return reservationConfirmationId;
    }

    public void setReservationConfirmationId(String reservationConfirmationId) {
        this.reservationConfirmationId = reservationConfirmationId;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
