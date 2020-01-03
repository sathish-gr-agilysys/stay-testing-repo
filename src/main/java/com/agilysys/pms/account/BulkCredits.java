package com.agilysys.pms.account;

import java.util.List;
import java.util.Set;

import com.agilysys.pms.account.model.Credit;

public class BulkCredits {

    private List<Credit> credits;

    private Set<String> reservationIds;

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public Set<String> getReservationIds() {
        return reservationIds;
    }

    public void setReservationIds(Set<String> reservationIds) {
        this.reservationIds = reservationIds;
    }
}
