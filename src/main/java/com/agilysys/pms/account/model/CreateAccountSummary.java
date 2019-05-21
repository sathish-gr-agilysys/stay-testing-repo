/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.common.json.serialize.LocalDateJsonKeyDeserializer;
import com.agilysys.common.model.rate.AccountRateSnapshot;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Detailed model of an Account
 *
 * @see <a
 * href="">http://confluence.bellevue.ad.local/display/VICTRIAL/Account+Create</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAccountSummary extends AccountSummary {
    /**
     * the company profile id related to the reservation, if there is one
     */
    private String reservationCompanyProfileId;
    /**
     * the group id related to the reservation, if there is one
     */
    private String reservationGroupId;
    /**
     * the start date related to the reservation, if there is one
     */
    private LocalDate reservationStartDate;
    /**
     * the end date related to the reservation, if there is one
     */
    private LocalDate reservationEndDate;

    private LocalDate startDate;
    private LocalDate endDate;

    //TODO add schema validation to this to make this required once it is required by the reservation service
    @JsonDeserialize(keyUsing = LocalDateJsonKeyDeserializer.class)
    protected Map<LocalDate, AccountRateSnapshot> rateSnapshot;

    public String getReservationCompanyProfileId() {
        return reservationCompanyProfileId;
    }

    public void setReservationCompanyProfileId(String reservationCompanyProfileId) {
        this.reservationCompanyProfileId = reservationCompanyProfileId;
    }

    /**
     * Get reservationGroupId
     *
     * @return reservationGroupId
     */
    public String getReservationGroupId() {
        return reservationGroupId;
    }

    /**
     * Set reservationGroupId
     *
     * @param id reservationGroupId to set
     */
    public void setReservationGroupId(String id) {
        this.reservationGroupId = id;
    }

    public Map<LocalDate, AccountRateSnapshot> getRateSnapshot() {
        return rateSnapshot;
    }

    public void setRateSnapshot(Map<LocalDate, AccountRateSnapshot> rateSnapshot) {
        this.rateSnapshot = rateSnapshot;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(LocalDate reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(LocalDate reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }
}
