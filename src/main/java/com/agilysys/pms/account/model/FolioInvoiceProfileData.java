/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class FolioInvoiceProfileData {

    private String firstName;
    private String lastName;
    private String title;
    private String middleInitial;
    private FolioInvoiceAddressData folioInvoiceAddressData;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public FolioInvoiceAddressData getFolioInvoiceAddressData() {
        return folioInvoiceAddressData;
    }

    public void setFolioInvoiceAddressData(FolioInvoiceAddressData folioInvoiceAddressData) {
        this.folioInvoiceAddressData = folioInvoiceAddressData;
    }
}
