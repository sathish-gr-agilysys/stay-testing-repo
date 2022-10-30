package com.agilysys.pms.account.model;

import java.util.HashMap;
import java.util.Map;

public class BookingEstimatedChargesRequestBulk {
    private String availableRatePlanId;
    private BookingEstimatedChargesRequest bookingEstimatedChargesRequest;
    private Map<String, BookingEstimatedChargesRequest> bookingEstimatedChargesRequestByAvailableRatePlanId = null;

    public BookingEstimatedChargesRequestBulk() {
        bookingEstimatedChargesRequestByAvailableRatePlanId = new HashMap<>();
    }

    public BookingEstimatedChargesRequestBulk(String availableRatePlanId,BookingEstimatedChargesRequest bookingEstimatedChargesRequest) {
        this.availableRatePlanId = availableRatePlanId;
        this.bookingEstimatedChargesRequest = bookingEstimatedChargesRequest;
    }

    public BookingEstimatedChargesRequestBulk(
          Map<String, BookingEstimatedChargesRequest> bookingEstimatedChargesRequestByAvailableRatePlanId) {
        this.bookingEstimatedChargesRequestByAvailableRatePlanId = bookingEstimatedChargesRequestByAvailableRatePlanId;
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

    public Map<String, BookingEstimatedChargesRequest> getBookingEstimatedChargesRequestByAvailableRatePlanId() {
        return bookingEstimatedChargesRequestByAvailableRatePlanId;
    }

    public void setBookingEstimatedChargesRequestByAvailableRatePlanId(
          Map<String, BookingEstimatedChargesRequest> bookingEstimatedChargesRequestByAvailableRatePlanId) {
        this.bookingEstimatedChargesRequestByAvailableRatePlanId = bookingEstimatedChargesRequestByAvailableRatePlanId;
    }
}
