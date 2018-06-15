/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

import com.agilysys.pms.profile.model.AddressDetails;

public class AccountReferenceInfo {

    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String name;
    private AddressDetails addressDetails;
    private String groupCode;

    private String id;

    public AccountReferenceInfo() {

    }

    public AccountReferenceInfo(String sourceName, LocalDate arrivalDate, LocalDate departureDate,
          String id) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.name = sourceName;
        this.id = id;
    }

    public AccountReferenceInfo(String sourceName, String code, LocalDate arrivalDate, LocalDate departureDate,
          String id) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.name = sourceName;
        this.id = id;
        this.groupCode = code;
    }

    public AccountReferenceInfo(String sourceName, AddressDetails addressDetails, String id) {
        this.name = sourceName;
        this.addressDetails = addressDetails;
        this.id = id;
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

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
