/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.common.template.TemplateData;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

public class FolioInvoiceReservation implements TemplateData {

    private String reservationId;
    private String confirmationCode;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private int totalAdults;
    private int totalChildren;
    private String allocationId;
    private boolean reservationAliasEnabled;
    private String reservationAlias;

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

    public int getTotalAdults() {
        return totalAdults;
    }

    public void setTotalAdults(int totalAdults) {
        this.totalAdults = totalAdults;
    }

    public int getTotalChildren() {
        return totalChildren;
    }

    public void setTotalChildren(int totalChildren) {
        this.totalChildren = totalChildren;
    }

    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }

    public boolean isReservationAliasEnabled() {
        return reservationAliasEnabled;
    }

    public void setReservationAliasEnabled(boolean reservationAliasEnabled) {
        this.reservationAliasEnabled = reservationAliasEnabled;
    }

    public String getReservationAlias() {
        return reservationAlias;
    }

    public void setReservationAlias(String reservationAlias) {
        this.reservationAlias = reservationAlias;
    }

    @Override
    public Map<String, Object> rawFields() {
        Map<String, Object> rawFieldMap = new HashMap<>(2);
        if (arrivalDate != null) {
            rawFieldMap.put(TemplateData.rawField("arrivalDate"), arrivalDate);
        }
        if (departureDate != null) {
            rawFieldMap.put(TemplateData.rawField("departureDate"), departureDate);
        }

        return rawFieldMap;
    }
}
