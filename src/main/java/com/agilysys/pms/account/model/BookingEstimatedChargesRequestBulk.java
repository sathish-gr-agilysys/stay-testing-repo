package com.agilysys.pms.account.model;

import java.util.HashMap;
import java.util.Map;

public class BookingEstimatedChargesRequestBulk {
    private String availableRatePlanId;
    private BookingEstimatedChargesRequest bookingEstimatedChargesRequest;
    private Map<String, BookingEstimatedChargesRequest> bookingEstimatedChargesRequestByRoomTypeId = null;

    public BookingEstimatedChargesRequestBulk() {
        bookingEstimatedChargesRequestByRoomTypeId = new HashMap<>();
    }

    public BookingEstimatedChargesRequestBulk(String availableRatePlanId,BookingEstimatedChargesRequest bookingEstimatedChargesRequest) {
        this.availableRatePlanId = availableRatePlanId;
        this.bookingEstimatedChargesRequest = bookingEstimatedChargesRequest;
    }

    public BookingEstimatedChargesRequestBulk(
          Map<String, BookingEstimatedChargesRequest> bookingEstimatedChargesRequestByAvailableRatePlanId) {
        this.bookingEstimatedChargesRequestByRoomTypeId = bookingEstimatedChargesRequestByAvailableRatePlanId;
    }

    public String getAvailableRatePlanId() {
        return availableRatePlanId;
    }

    public void setAvailableRatePlanId(String availableRatePlanId) {
        this.availableRatePlanId = availableRatePlanId;
    }

    public BookingEstimatedChargesRequest getBookingEstimatedChargesRequest() {
        return bookingEstimatedChargesRequest;
    }

    public void setBookingEstimatedChargesRequest(BookingEstimatedChargesRequest bookingEstimatedChargesRequest) {
        this.bookingEstimatedChargesRequest = bookingEstimatedChargesRequest;
    }

    public Map<String, BookingEstimatedChargesRequest> getBookingEstimatedChargesRequestByRoomTypeId() {
        return bookingEstimatedChargesRequestByRoomTypeId;
    }

    public void setBookingEstimatedChargesRequestByRoomTypeId(
          Map<String, BookingEstimatedChargesRequest> bookingEstimatedChargesRequestByRoomTypeId) {
        this.bookingEstimatedChargesRequestByRoomTypeId = bookingEstimatedChargesRequestByRoomTypeId;
    }
}
