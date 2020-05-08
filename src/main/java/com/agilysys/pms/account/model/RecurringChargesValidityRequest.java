/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

public class RecurringChargesValidityRequest {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String roomTypeId;
    private int adults;
    private int children;
    private int ageCategory1;
    private int ageCategory2;
    private int ageCategory3;
    private int ageCategory4;
    private int ageCategory5;
    private int ageCategory6;
    private int ageCategory7;
    private int ageCategory8;
    private List<ModifyStayDetails> modifyStayDetails;
    private int numberOfReservations;

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

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getAgeCategory1() {
        return ageCategory1;
    }

    public void setAgeCategory1(int ageCategory1) {
        this.ageCategory1 = ageCategory1;
    }

    public int getAgeCategory2() {
        return ageCategory2;
    }

    public void setAgeCategory2(int ageCategory2) {
        this.ageCategory2 = ageCategory2;
    }

    public int getAgeCategory3() {
        return ageCategory3;
    }

    public void setAgeCategory3(int ageCategory3) {
        this.ageCategory3 = ageCategory3;
    }

    public int getAgeCategory4() {
        return ageCategory4;
    }

    public void setAgeCategory4(int ageCategory4) {
        this.ageCategory4 = ageCategory4;
    }

    public int getAgeCategory5() {
        return ageCategory5;
    }

    public void setAgeCategory5(int ageCategory5) {
        this.ageCategory5 = ageCategory5;
    }

    public int getAgeCategory6() {
        return ageCategory6;
    }

    public void setAgeCategory6(int ageCategory6) {
        this.ageCategory6 = ageCategory6;
    }

    public int getAgeCategory7() {
        return ageCategory7;
    }

    public void setAgeCategory7(int ageCategory7) {
        this.ageCategory7 = ageCategory7;
    }

    public int getAgeCategory8() {
        return ageCategory8;
    }

    public void setAgeCategory8(int ageCategory8) {
        this.ageCategory8 = ageCategory8;
    }

    public List<ModifyStayDetails> getModifyStayDetails() {
        return modifyStayDetails;
    }

    public void setModifyStayDetails(List<ModifyStayDetails> modifyStayDetails) {
        this.modifyStayDetails = modifyStayDetails;
    }

    public int getNumberOfReservations() {
        return numberOfReservations;
    }

    public void setNumberOfReservations(int numberOfReservations) {
        this.numberOfReservations = numberOfReservations;
    }
}
