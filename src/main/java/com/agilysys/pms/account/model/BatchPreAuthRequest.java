package com.agilysys.pms.account.model;

import java.util.Set;

public class BatchPreAuthRequest {
    Set<String> reservationIds;
    int numberOfNights;

    public Set<String> getReservationIds() {
        return reservationIds;
    }

    public void setReservationIds(Set<String> reservationIds) {
        this.reservationIds = reservationIds;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
}
