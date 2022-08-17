/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import com.agilysys.common.DepositChargeDetails;

public class UpdateArcWrapper {

    private Set<String> reservationIds;
    private Map<String, DepositChargeDetails> depositChargeDetails;
    private Map<String, BigDecimal> totalDues;

    public UpdateArcWrapper() {}

    public UpdateArcWrapper(Set<String> reservationIds, Map<String, DepositChargeDetails> depositChargeDetails,
          Map<String, BigDecimal> totalDues) {
        this.reservationIds = reservationIds;
        this.depositChargeDetails = depositChargeDetails;
        this.totalDues = totalDues;
    }

    public Set<String> getReservationIds() {
        return reservationIds;
    }

    public void setReservationIds(Set<String> reservationIds) {
        this.reservationIds = reservationIds;
    }

    public Map<String, DepositChargeDetails> getDepositChargeDetails() {
        return depositChargeDetails;
    }

    public void setDepositChargeDetails(Map<String, DepositChargeDetails> depositChargeDetails) {
        this.depositChargeDetails = depositChargeDetails;
    }

    public Map<String, BigDecimal> getTotalDues() {
        return totalDues;
    }

    public void setTotalDues(Map<String, BigDecimal> totalDues) {
        this.totalDues = totalDues;
    }
}