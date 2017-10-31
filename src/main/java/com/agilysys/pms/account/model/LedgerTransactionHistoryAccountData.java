/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.pms.property.model.AllocatedRoomDetail;

public class LedgerTransactionHistoryAccountData {
    private String id;

    private String accountType;

    private String accountId;

    private String reservationConfirmationId;

    private String reservationId;

    private String referenceId;

    private String name;

    private LocalDate arrivalDate;

    private LocalDate departureDate;

    private String code;

    private List<AllocatedRoomDetail> allocatedRoomDetail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getReservationConfirmationId() {
        return reservationConfirmationId;
    }

    public void setReservationConfirmationId(String reservationConfirmationId) {
        this.reservationConfirmationId = reservationConfirmationId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<AllocatedRoomDetail> getAllocatedRoomDetail() {
        return allocatedRoomDetail;
    }

    public void setAllocatedRoomDetail(List<AllocatedRoomDetail> allocatedRoomDetail) {
        this.allocatedRoomDetail = allocatedRoomDetail;
    }
}
