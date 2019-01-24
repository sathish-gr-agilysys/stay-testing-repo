/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class AccountSearchResult {
    private String tenantId;
    private String propertyId;
    private String accountId;
    public static final String ACCOUNT_ID_FIELD = "accountId";

    private BigDecimal accountBalance;
    private String accountStatus;
    private String accountType;
    private DateTime arrivalDate;
    private String bookingStatus;
    private DateTime departureDate;
    private List<FolioBalance> folios;
    private String groupCode;
    private String name;
    private String number;
    private String reservationConfirmationId;
    private String reservationStatus;
    private String roomType;
    private String roomNumber;
    // TODO the requirements for this are currently pretty vague, we need to
    // figure out if there are multiple types of statuses such as VIP that an
    // Account can have and how to return them in the search results
    private String vipStatus;

    public AccountSearchResult() {}

    public AccountSearchResult(String accountId, AccountType accountType, String name, String propertyId,
          String tenantId) {
        this.accountId = accountId;
        this.accountType = accountType != null ? accountType.name() : null;
        this.name = name;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
    }

    public AccountSearchResult(String accountId, AccountType accountType, LocalDate arrivalDate, String bookingStatus,
          LocalDate departureDate, String groupCode, String name, String propertyId, String tenantId) {
        this(accountId, accountType, name, propertyId, tenantId);

        this.arrivalDate = arrivalDate != null ? new DateTime(arrivalDate.toDate()) : null;
        this.bookingStatus = bookingStatus;
        this.departureDate = departureDate != null ? new DateTime(departureDate.toDate()) : null;
        this.groupCode = groupCode;
    }

    public AccountSearchResult(String accountId, AccountType accountType, Date arrivalDate, Date departureDate,
          String name, String propertyId, String reservationConfirmationId, String reservationStatus, String roomNumber,
          String roomType, String tenantId, String vipStatus) {
        this(accountId, accountType, name, propertyId, tenantId);

        this.arrivalDate = arrivalDate != null ? new DateTime(arrivalDate) : null;
        this.departureDate = departureDate != null ? new DateTime(departureDate) : null;
        this.reservationConfirmationId = reservationConfirmationId;
        this.reservationStatus = reservationStatus;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.vipStatus = vipStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
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

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public DateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(DateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public DateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(DateTime departureDate) {
        this.departureDate = departureDate;
    }

    public List<FolioBalance> getFolios() {
        return folios;
    }

    public void setFolios(List<FolioBalance> folios) {
        this.folios = folios;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }
}
