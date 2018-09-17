/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

/**
 * To get the various validity parameter of recurring charge during modify stay/undo cancel flow
 */
public class RecurringChargesValidityResponse extends RecurringChargesDatesValidationResponse {
    //applicable for transaction and inventory recurring charges
    private int chargesIndependentOfReservationDates;

    //true,if item in component package is also added manually in estimated charges section
    private boolean redundantInventoryCharges;

    //applicable for only inventory recurring charges
    private Set<RecurringChargeDetail> chargesWithMaxPerReservationRestriction;
    private Set<RecurringChargeDetail> chargesWithRoomTypeRestriction;

    private AvailabilityResponse availabilityResponse;

    public RecurringChargesValidityResponse() {

    }

    public RecurringChargesValidityResponse(AvailabilityResponse availabilityResponse,
          Set<RecurringChargeDetail> chargesWithMaxPerReservationRestriction,
          Set<RecurringChargeDetail> chargesWithRoomTypeRestriction) {
        this.availabilityResponse = availabilityResponse;
        this.chargesWithMaxPerReservationRestriction = chargesWithMaxPerReservationRestriction;
        this.chargesWithRoomTypeRestriction = chargesWithRoomTypeRestriction;
    }

    public int getChargesIndependentOfReservationDates() {
        return chargesIndependentOfReservationDates;
    }

    public boolean isRedundantInventoryCharges() {
        return redundantInventoryCharges;
    }

    public void setRedundantInventoryCharges(boolean redundantInventoryCharges) {
        this.redundantInventoryCharges = redundantInventoryCharges;
    }

    public void setChargesIndependentOfReservationDates(int chargesIndependentOfReservationDates) {
        this.chargesIndependentOfReservationDates = chargesIndependentOfReservationDates;
    }

    public Set<RecurringChargeDetail> getChargesWithMaxPerReservationRestriction() {
        return chargesWithMaxPerReservationRestriction;
    }

    public void setChargesWithMaxPerReservationRestriction(
          Set<RecurringChargeDetail> chargesWithMaxPerReservationRestriction) {
        this.chargesWithMaxPerReservationRestriction = chargesWithMaxPerReservationRestriction;
    }

    public Set<RecurringChargeDetail> getChargesWithRoomTypeRestriction() {
        return chargesWithRoomTypeRestriction;
    }

    public void setChargesWithRoomTypeRestriction(Set<RecurringChargeDetail> chargesWithRoomTypeRestriction) {
        this.chargesWithRoomTypeRestriction = chargesWithRoomTypeRestriction;
    }

    public AvailabilityResponse getAvailabilityResponse() {
        return availabilityResponse;
    }

    public void setAvailabilityResponse(AvailabilityResponse availabilityResponse) {
        this.availabilityResponse = availabilityResponse;
    }

    public static class AvailabilityResponse {
        //applicable for only inventory recurring charges
        private int chargesWithInsufficientQuantity;

        //availability of components in new package rate plan user try to add when modify stay
        private int componentChargesWithInsufficientQuantity;

        public int getChargesWithInsufficientQuantity() {
            return chargesWithInsufficientQuantity;
        }

        public void setChargesWithInsufficientQuantity(int chargesWithInsufficientQuantity) {
            this.chargesWithInsufficientQuantity = chargesWithInsufficientQuantity;
        }

        public int getComponentChargesWithInsufficientQuantity() {
            return componentChargesWithInsufficientQuantity;
        }

        public void setComponentChargesWithInsufficientQuantity(int componentChargesWithInsufficientQuantity) {
            this.componentChargesWithInsufficientQuantity = componentChargesWithInsufficientQuantity;
        }
    }
}
