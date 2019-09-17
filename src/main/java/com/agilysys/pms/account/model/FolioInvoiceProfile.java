/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.pms.profile.model.Email;
import com.agilysys.pms.profile.model.Phone;

public class FolioInvoiceProfile {

    private String profileId;
    private String firstName;
    private String lastName;
    private String title;
    private String middleInitial;
    private String suffix;
    private List<Email> emails;
    private List<Phone> phoneNos;
    private FolioInvoiceAddress folioInvoiceAddress;

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

    public List<Phone> getPhoneNos() {
        return phoneNos;
    }

    public void setPhoneNos(List<Phone> phoneNos) {
        this.phoneNos = phoneNos;
    }

    public FolioInvoiceAddress getFolioInvoiceAddress() {
        return folioInvoiceAddress;
    }

    public void setFolioInvoiceAddress(FolioInvoiceAddress folioInvoiceAddress) {
        this.folioInvoiceAddress = folioInvoiceAddress;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
