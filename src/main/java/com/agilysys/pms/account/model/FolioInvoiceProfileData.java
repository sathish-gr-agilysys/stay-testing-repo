/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.pms.profile.model.Email;

public class FolioInvoiceProfileData {

    private String profileId;
    private String firstName;
    private String lastName;
    private String title;
    private String middleInitial;
    private List<Email> emails;
    private FolioInvoiceAddressData folioInvoiceAddressData;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

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

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public FolioInvoiceAddressData getFolioInvoiceAddressData() {
        return folioInvoiceAddressData;
    }

    public void setFolioInvoiceAddressData(FolioInvoiceAddressData folioInvoiceAddressData) {
        this.folioInvoiceAddressData = folioInvoiceAddressData;
    }
}
