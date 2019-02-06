/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

import com.agilysys.pms.account.model.external.Reservation;

public class ReservationRevenueReportItem extends RevenueReportItem {
    private String reservationConfirmationCode;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private int nights;
    private String roomTypeId;
    private String ratePlanId;
    private String paymentMethodId;
    private String roomId;
    private String reservationStatus;
    private String reservationId;

    public ReservationRevenueReportItem() {

    }

    public ReservationRevenueReportItem(RevenueReportItem revenueReportItem){
        super(revenueReportItem);
    }

    public String getReservationConfirmationCode() {
        return reservationConfirmationCode;
    }

    public void setReservationConfirmationCode(String reservationConfirmationCode) {
        this.reservationConfirmationCode = reservationConfirmationCode;
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

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
